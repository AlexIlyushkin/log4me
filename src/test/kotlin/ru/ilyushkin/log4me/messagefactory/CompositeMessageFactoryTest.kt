package ru.ilyushkin.log4me.messagefactory

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifySequence
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.ilyushkin.log4me.message.Message
import kotlin.test.assertEquals

/**
 * @author Alex Ilyushkin
 */
@DisplayName("CompositeMessageFactory")
class CompositeMessageFactoryTest {

    @Test
    @DisplayName("newMessage(Message): decorates Message provided as parameter thorough all underlying MessageFactories")
    fun `newMessage(Message) test`() {
        val messageParam = mockk<Message>()
        val messageFactoryNewMessageMethodResult = mockk<Message>()
        val messageFactory = mockk<MessageFactory> {
            every {
                newMessage(messageParam)
            } returns messageFactoryNewMessageMethodResult
        }
        val messageFactoryNewMessageMethodResult1 = mockk<Message>()
        val messageFactory1 = mockk<MessageFactory> {
            every {
                newMessage(messageFactoryNewMessageMethodResult)
            } returns messageFactoryNewMessageMethodResult1
        }
        val messageFactoryNewMessageMethodResult2 = mockk<Message>()
        val messageFactory2 = mockk<MessageFactory> {
            every {
                newMessage(messageFactoryNewMessageMethodResult1)
            } returns messageFactoryNewMessageMethodResult2
        }

        val compositeMessageFactory = CompositeMessageFactory(
            messageFactory,
            messageFactory1,
            messageFactory2
        )

        assertEquals(
            expected  = messageFactoryNewMessageMethodResult2,
            actual = compositeMessageFactory.newMessage(
                baseMessage = messageParam
            )
        )
        verifySequence {
            messageFactory.newMessage(messageParam)
            messageFactory1.newMessage(messageFactoryNewMessageMethodResult)
            messageFactory2.newMessage(messageFactoryNewMessageMethodResult1)
            messageFactoryNewMessageMethodResult2 == messageFactoryNewMessageMethodResult2
        }
        confirmVerified(
            messageParam,
            messageFactoryNewMessageMethodResult,
            messageFactory,
            messageFactoryNewMessageMethodResult1,
            messageFactory1,
            messageFactoryNewMessageMethodResult2,
            messageFactory2
        )
    }
}
