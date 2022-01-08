package ru.ilyushkin.log4me

import io.mockk.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.ilyushkin.log4me.message.Message
import ru.ilyushkin.log4me.messagefactory.MessageFactory

/**
 * @author Alex Ilyushkin
 */
@DisplayName("MessageFactoryLogJournal")
class MessageFactoryLogJournalTest {

    @Test
    @DisplayName("log(Message): provides Message to MessageFactory.newMessage(Message) and logs result message through underlying LogJournal")
    fun `log(Message) test`() {
        val messageParam = mockk<Message>()
        val newMessageMethodResult = mockk<Message>()
        val messageFactory = mockk<MessageFactory> {
            every { newMessage(messageParam) } returns newMessageMethodResult
        }
        val originLogJournal = mockk<LogJournal> {
            justRun { log(newMessageMethodResult) }
        }

        val messageFactoryLogJournal = MessageFactoryLogJournal(
            origin = originLogJournal,
            messageFactory = messageFactory,
        )
        messageFactoryLogJournal.log(messageParam)

        verifySequence {
            messageFactory.newMessage(messageParam)
            originLogJournal.log(newMessageMethodResult)
        }
        confirmVerified(messageParam, newMessageMethodResult, messageFactory, originLogJournal)
    }
}
