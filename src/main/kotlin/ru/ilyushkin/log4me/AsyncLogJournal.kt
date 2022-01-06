package ru.ilyushkin.log4me

/**
 * [LogJournal] with asynchronous working principle
 *
 * @author Alex Ilyushkin
 */
interface AsyncLogJournal : LogJournal {

    /**
     * Starts to handle queued messages.
     */
    fun start()
}
