package ru.ilyushkin.log4me

import ru.ilyushkin.log4me.message.Message

/**
 * [LogJournal] implementation that delegates logging to underlying [LogJournal]s
 *
 * @author Alex Ilyushkin
 */
class CompositeLogJournal(
    private val logJournals: Iterable<LogJournal>
) : LogJournal {

    constructor(vararg logJournals: LogJournal)
            : this(logJournals.toList())

    /**
     * Delegates logging [Message] provided as parameter to all underlying [LogJournal]s
     *
     * @param message [Message] that should be logged
     */
    override fun log(message: Message) =
        logJournals.forEach { it.log(message = message) }
}
