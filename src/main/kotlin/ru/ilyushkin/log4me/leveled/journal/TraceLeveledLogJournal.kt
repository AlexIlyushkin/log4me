package ru.ilyushkin.log4me.leveled.journal

import ru.ilyushkin.log4me.LogJournal
import ru.ilyushkin.log4me.message.Message

/**
 * [LeveledLogJournal] implementation that logs on TRACE logging level
 *
 * Delegates logging to underlying [LogJournal]
 *
 * @author Alex Ilyushkin
 */
class TraceLeveledLogJournal(
    private val logJournal: LogJournal,
) : LeveledLogJournal {

    override fun logTrace(message: Message) {
        logJournal.log(message = message)
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
