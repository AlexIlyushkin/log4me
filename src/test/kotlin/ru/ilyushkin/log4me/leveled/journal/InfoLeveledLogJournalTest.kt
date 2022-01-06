package ru.ilyushkin.log4me.leveled.journal

import io.mockk.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.ilyushkin.log4me.LogJournal
import ru.ilyushkin.log4me.message.Message

/**
 * @author Alex Ilyushkin
 */
@DisplayName("InfoLeveledLogJournal")
class InfoLeveledLogJournalTest {

    @Test
    @DisplayName("logTrace(Message): doesn't log trace message")
    fun `logTrace(Message) test`() {
        val message = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = message) }
        }

        val infoLeveledLogJournal = InfoLeveledLogJournal(
            logJournal = logJournal
        )
        infoLeveledLogJournal.logTrace(message = message)

        confirmVerified(message, logJournal)
    }

    @Test
    @DisplayName("logDebug(Message): doesn't log debug message")
    fun `logDebug(Message) test`() {
        val message = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = message) }
        }

        val infoLeveledLogJournal = InfoLeveledLogJournal(
            logJournal = logJournal
        )
        infoLeveledLogJournal.logDebug(message = message)

        confirmVerified(message, logJournal)
    }

    @Test
    @DisplayName("logInfo(Message): logs info message by LogJournal")
    fun `logInfo(Message) test`() {
        val message = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = message) }
        }

        val infoLeveledLogJournal = InfoLeveledLogJournal(
            logJournal = logJournal
        )
        infoLeveledLogJournal.logInfo(message = message)

        verify(exactly = 1) { logJournal.log(message = message) }
        confirmVerified(message, logJournal)
    }

    @Test
    @DisplayName("logWarning(Message): logs warning message by LogJournal")
    fun `logWarning(Message) test`() {
        val message = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = message) }
        }

        val infoLeveledLogJournal = InfoLeveledLogJournal(
            logJournal = logJournal
        )
        infoLeveledLogJournal.logWarning(message = message)

        verify(exactly = 1) { logJournal.log(message = message) }
        confirmVerified(message, logJournal)
    }

    @Test
    @DisplayName("logError(Message): logs error message by LogJournal")
    fun `logError(Message) test`() {
        val message = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = message) }
        }

        val infoLeveledLogJournal = InfoLeveledLogJournal(
            logJournal = logJournal
        )
        infoLeveledLogJournal.logError(message = message)

        verify(exactly = 1) { logJournal.log(message = message) }
        confirmVerified(message, logJournal)
    }

    @Test
    @DisplayName("logFatal(Message): logs fatal message by LogJournal")
    fun `logFatal(Message) test`() {
        val message = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = message) }
        }

        val infoLeveledLogJournal = InfoLeveledLogJournal(
            logJournal = logJournal
        )
        infoLeveledLogJournal.logFatal(message = message)

        verify(exactly = 1) { logJournal.log(message = message) }
        confirmVerified(message, logJournal)
    }
}
