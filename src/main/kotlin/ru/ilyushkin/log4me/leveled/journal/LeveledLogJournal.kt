package ru.ilyushkin.log4me.leveled.journal

import ru.ilyushkin.log4me.message.Message

/**
 * Provides the ability to log by logging levels
 *
 * @author Alex Ilyushkin
 */
interface LeveledLogJournal {

    /**
     * Logs [Message] on TRACE logging level
     *
     * @param message [Message] that should be logged
     */
    fun logTrace(message: Message)

    /**
     * Logs [Message] on DEBUG logging level
     *
     * @param message [Message] that should be logged
     */
    fun logDebug(message: Message)

    /**
     * Logs [Message] on INFO logging level
     *
     * @param message [Message] that should be logged
     */
    fun logInfo(message: Message)

    /**
     * Logs [Message] on WARNING logging level
     *
     * @param message [Message] that should be logged
     */
    fun logWarning(message: Message)

    /**
     * Logs [Message] on ERROR logging level
     *
     * @param message [Message] that should be logged
     */
    fun logError(message: Message)

    /**
     * Logs [Message] on FATAL logging level
     *
     * @param message [Message] that should be logged
     */
    fun logFatal(message: Message)
}
