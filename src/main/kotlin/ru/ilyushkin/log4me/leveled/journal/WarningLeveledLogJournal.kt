package ru.ilyushkin.log4me.leveled.journal

import ru.ilyushkin.log4me.LogJournal
import ru.ilyushkin.log4me.message.Message

/**
 * [LeveledLogJournal] implementation that logs on WARNING logging level.
 *
 * Ignores attempt to log on TRACE or DEBUG or INFO level.
 *
 * Delegates logging to underlying [LogJournal]
 *
 * @author Alex Ilyushkin
 */
class WarningLeveledLogJournal(
    private val logJournal: LogJournal,
) : LeveledLogJournal {

    override fun logTrace(message: Message) {
        //Do nothing. Logging level of this log journal is higher than TRACE
    }

    override fun logDebug(message: Message) {
        //Do nothing. Logging level of the log journal is higher than DEBUG
    }

    override fun logInfo(message: Message) {
        //Do nothing. Logging level of the log journal is higher than INFO
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
