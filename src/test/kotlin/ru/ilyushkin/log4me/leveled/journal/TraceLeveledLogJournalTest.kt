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
@DisplayName("TraceLeveledLogJournal")
class TraceLeveledLogJournalTest {

    @Test
    @DisplayName("logTrace(Message): logs trace message by LogJournal")
    fun `logTrace(Message) test`() {
        val message = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = message) }
        }

        val traceLeveledLogJournal = TraceLeveledLogJournal(
            logJournal = logJournal
        )
        traceLeveledLogJournal.logTrace(message = message)

        verify(exactly = 1) { logJournal.log(message = message) }
        confirmVerified(message, logJournal)
    }

    @Test
    @DisplayName("logDebug(Message): logs debug message by LogJournal")
    fun `logDebug(Message) test`() {
        val message = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = message) }
        }

        val traceLeveledLogJournal = TraceLeveledLogJournal(
            logJournal = logJournal
        )
        traceLeveledLogJournal.logDebug(message = message)

        verify(exactly = 1) { logJournal.log(message = message) }
        confirmVerified(message, logJournal)
    }

    @Test
    @DisplayName("logInfo(Message): logs info message by LogJournal")
    fun `logInfo(Message) test`() {
        val message = mockk<Message>()
        val logJournal = mockk<LogJournal> {
            justRun { log(message = message) }
        }

        val traceLeveledLogJournal = TraceLeveledLogJournal(
            logJournal = logJournal
        )
        traceLeveledLogJournal.logInfo(message = message)

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

        val traceLeveledLogJournal = TraceLeveledLogJournal(
            logJournal = logJournal
        )
        traceLeveledLogJournal.logWarning(message = message)

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

        val traceLeveledLogJournal = TraceLeveledLogJournal(
            logJournal = logJournal
        )
        traceLeveledLogJournal.logError(message = message)

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

        val traceLeveledLogJournal = TraceLeveledLogJournal(
            logJournal = logJournal
        )
        traceLeveledLogJournal.logFatal(message = message)

        verify(exactly = 1) { logJournal.log(message = message) }
        confirmVerified(message, logJournal)
    }
}
