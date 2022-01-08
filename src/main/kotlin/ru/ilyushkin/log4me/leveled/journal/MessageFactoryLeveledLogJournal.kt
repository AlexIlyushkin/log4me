package ru.ilyushkin.log4me.leveled.journal

import ru.ilyushkin.log4me.leveled.messagefactory.LeveledMessageFactory
import ru.ilyushkin.log4me.message.Message

/**
 * [LeveledLogJournal] implementation that logs a messages created by [LeveledMessageFactory] through underlying [LeveledLogJournal]
 * @see [LeveledLogJournal]
 * @see [LeveledMessageFactory]
 *
 * @author Alex Ilyushkin
 */
class MessageFactoryLeveledLogJournal(
    private val origin: LeveledLogJournal,
    private val messageFactory: LeveledMessageFactory
) : LeveledLogJournal {

    /**
     * Logs [Message] on TRACE logging level
     *
     * @param message [Message] that should be logged
     */
    override fun logTrace(message: Message) =
        origin.logTrace(
            message = messageFactory.newTraceMessage(
                baseMessage = message
            )
        )

    /**
     * Logs [Message] on DEBUG logging level
     *
     * @param message [Message] that should be logged
     */
    override fun logDebug(message: Message) =
        origin.logDebug(
            message = messageFactory.newDebugMessage(
                baseMessage = message
            )
        )

    /**
     * Logs [Message] on INFO logging level
     *
     * @param message [Message] that should be logged
     */
    override fun logInfo(message: Message) =
        origin.logInfo(
            message = messageFactory.newInfoMessage(
                baseMessage = message
            )
        )

    /**
     * Logs [Message] on WARNING logging level
     *
     * @param message [Message] that should be logged
     */
    override fun logWarning(message: Message) =
        origin.logWarning(
            message = messageFactory.newWarningMessage(
                baseMessage = message
            )
        )
    /**
     * Logs [Message] on ERROR logging level
     *
     * @param message [Message] that should be logged
     */
    override fun logError(message: Message) =
        origin.logError(
            message = messageFactory.newErrorMessage(
                baseMessage = message
            )
        )

    /**
     * Logs [Message] on FATAL logging level
     *
     * @param message [Message] that should be logged
     */
    override fun logFatal(message: Message) =
        origin.logFatal(
            message = messageFactory.newFatalMessage(
                baseMessage = message
            )
        )
}
