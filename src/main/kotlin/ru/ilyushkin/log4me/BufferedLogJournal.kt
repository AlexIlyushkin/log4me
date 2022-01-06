package ru.ilyushkin.log4me

/**
 * Presents [LogJournal] with message buffering support
 *
 * @author Alex Ilyushkin
 */
interface BufferedLogJournal : LogJournal {

    /**
     * Forces any buffered log messages
     * to be logged out. If any messages previously
     * logged have been buffered by the implementation,
     * such messages should immediately be logged to their
     * intended destination.
     */
    fun flush()
}
