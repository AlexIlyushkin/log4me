package ru.ilyushkin.log4me.messagefactory

import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.ilyushkin.log4me.message.Message
import ru.ilyushkin.log4me.message.ThreadNameMessage
import kotlin.test.assertEquals

/**
 * @author Alex Ilyushkin
 */
@DisplayName("ThreadNameMessageFactory")
class ThreadNameMessageFactoryTest {

    @Test
    @DisplayName("newMessage(Message): wraps Message provided as parameter to ThreadNameMessage and returns result message")
    fun `newMessage(Message) test`() {
        val message = mockk<Message>()

        val threadNameMessageFactory = ThreadNameMessageFactory()

        assertEquals(
            expected = ThreadNameMessage(
                origin = message
            ),
            actual = threadNameMessageFactory.newMessage(
                baseMessage = message
            )
        )
        verify(exactly = 1) { message == message }
        confirmVerified(message)
    }
}
