package ru.ilyushkin.log4me.leveled.journal

import ru.ilyushkin.log4me.LogJournal
import ru.ilyushkin.log4me.message.Message

/**
 * [LeveledLogJournal] implementation that logs on FATAL logging level.
 *
 * Ignores attempt to log on TRACE or DEBUG or INFO or WARNING or ERROR level.
 *
 * Delegates logging to underlying [LogJournal]
 *
 * @author Alex Ilyushkin
 */
class FatalLeveledLogJournal(
    private val logJournal: LogJournal,
) : LeveledLogJournal {

    override fun logTrace(message: Message) {
        //Do nothing. Logging level of this log journal is higher than TRACE
    }

    override fun logDebug(message: Message) {
        //Do nothing. Logging level of this log journal is higher than DEBUG
    }

    override fun logInfo(message: Message) {
        //Do nothing. Logging level of this log journal is higher than INFO
    }

    override fun logWarning(message: Message) {
        //Do nothing. Logging level of this log journal is higher than WARNING
    }

    override fun logError(message: Message) {
        //Do nothing. Logging level of this log journal is higher than ERROR
    }

    override fun logFatal(message: Message) {
        logJournal.log(message = message)
    }
}
