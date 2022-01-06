package ru.ilyushkin.log4me.leveled.journal

import io.mockk.confirmVerified
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.ilyushkin.log4me.LogJournal
import ru.ilyushkin.log4me.message.Message

/**
 * @author Alex Ilyushkin
 */
@DisplayName("FatalLeveledLogJournal")
class FatalLeveledLogJournalTest {

    @Test
    @DisplayName("logTrace(Message): doesn't log trace message")
    fun `logTrace(Message) test`() {
        val message = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = message) }
        }

        val fatalLeveledLogJournalTest = FatalLeveledLogJournal(
            logJournal = logJournal
        )
        fatalLeveledLogJournalTest.logTrace(message = message)

        confirmVerified(message, logJournal)
    }

    @Test
    @DisplayName("logDebug(Message): doesn't log debug message by LogJournal")
    fun `logDebug(Message) test`() {
        val message = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = message) }
        }

        val fatalLeveledLogJournal = FatalLeveledLogJournal(
            logJournal = logJournal
        )
        fatalLeveledLogJournal.logDebug(message = message)

        confirmVerified(message, logJournal)
    }

    @Test
    @DisplayName("logInfo(Message): doesn't log info message by LogJournal")
    fun `logInfo(Message) test`() {
        val message = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = message) }
        }

        val fatalLeveledLogJournal = FatalLeveledLogJournal(
            logJournal = logJournal
        )
        fatalLeveledLogJournal.logInfo(message = message)

        confirmVerified(message, logJournal)
    }

    @Test
    @DisplayName("logWarning(Message): doesn't log warning message by LogJournal")
    fun `logWarning(Message) test`() {
        val message = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = message) }
        }

        val fatalLeveledLogJournal = FatalLeveledLogJournal(
            logJournal = logJournal
        )
        fatalLeveledLogJournal.logWarning(message = message)

        confirmVerified(message, logJournal)
    }

    @Test
    @DisplayName("logError(Message): doesn't log error message by LogJournal")
    fun `logError(Message) test`() {
        val message = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = message) }
        }

        val fatalLeveledLogJournal = FatalLeveledLogJournal(
            logJournal = logJournal
        )
        fatalLeveledLogJournal.logError(message = message)

        confirmVerified(message, logJournal)
    }

    @Test
    @DisplayName("logFatal(Message): logs fatal message by LogJournal")
    fun `logFatal(Message) test`() {
        val message = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = message) }
        }

        val fatalLeveledLogJournal = FatalLeveledLogJournal(
            logJournal = logJournal
        )
        fatalLeveledLogJournal.logFatal(message = message)

        verify(exactly = 1) { logJournal.log(message = message) }
        confirmVerified(message, logJournal)
    }
}
