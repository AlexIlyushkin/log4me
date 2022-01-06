package ru.ilyushkin.log4me

import io.mockk.confirmVerified
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verifySequence
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.ilyushkin.log4me.message.Message

/**
 * @author Alex Ilyushkin
 */
@DisplayName("CompositeLogJournal")
class CompositeLogJournalTest {

    @Test
    @DisplayName("log(Message): delegates logging Message provided as parameter to all underlying LogJournals")
    fun `log(Message) test`() {
        val messageParam = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = messageParam) }
        }
        val logJournal1 = mockk<LogJournal> {
            justRun { log(message = messageParam) }
        }
        val logJournal2 = mockk<LogJournal> {
            justRun { log(message = messageParam) }
        }

        val compositeLogJournal = ru.ilyushkin.log4me.CompositeLogJournal(
            logJournal,
            logJournal1,
            logJournal2
        )
        compositeLogJournal.log(message = messageParam)

        verifySequence {
            logJournal.log(message = messageParam)
            logJournal1.log(message = messageParam)
            logJournal2.log(message = messageParam)
        }
        confirmVerified(logJournal, logJournal1, logJournal2)
    }
}
