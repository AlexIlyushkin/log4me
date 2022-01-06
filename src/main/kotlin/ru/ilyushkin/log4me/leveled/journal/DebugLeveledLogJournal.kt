package ru.ilyushkin.log4me.leveled.journal

import ru.ilyushkin.log4me.LogJournal
import ru.ilyushkin.log4me.message.Message

/**
 * [LeveledLogJournal] implementation that logs on DEBUG logging level.
 *
 * Ignores attempt to log on TRACE level.
 *
 * Delegates logging to underlying [LogJournal]
 *
 * @author Alex Ilyushkin
 */
class DebugLeveledLogJournal(
    private val logJournal: LogJournal,
) : LeveledLogJournal {

    override fun logTrace(message: Message) {
        //Do nothing. Logging level of this log journal is higher than TRACE
    }

    override fun logDebug(message: Message) {
        logJournal.log(message = message)
    }

    override fun logInfo(message: Message) {
        logJournal.log(message = message)
    }

    override fun logWarning(message: Message) {
        logJournal.log(message = message)
    }

    override fun logError(message: Message) {
        logJournal.log(message = message)
    }

    override fun logFatal(message: Message) {
        logJournal.log(message = message)
    }
}
