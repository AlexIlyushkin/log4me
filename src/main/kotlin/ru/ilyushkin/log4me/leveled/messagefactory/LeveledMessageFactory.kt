package ru.ilyushkin.log4me.leveled.messagefactory

import ru.ilyushkin.log4me.message.Message

/**
 * Creates [Message]s on logging levels
 *
 * @author Alex Ilyushkin
 */
interface LeveledMessageFactory {

    /**
     * Creates new message on TRACE logging level
     *
     * @param baseMessage [Message] that becomes base of new message
     * @return new [Message] based on [Message] provided as parameter
     */
    fun newTraceMessage(baseMessage: Message): Message

    /**
     * Creates new message on DEBUG logging level
     *
     * @param baseMessage [Message] that becomes base of new message
     * @return new [Message] based on [Message] provided as parameter
     */
    fun newDebugMessage(baseMessage: Message): Message

    /**
     * Creates new message on INFO logging level
     *
     * @param baseMessage [Message] that becomes base of new message
     * @return new [Message] based on [Message] provided as parameter
     */
    fun newInfoMessage(baseMessage: Message): Message

    /**
     * Creates new message on WARNING logging level
     *
     * @param baseMessage [Message] that becomes base of new message
     * @return new [Message] based on [Message] provided as parameter
     */
    fun newWarningMessage(baseMessage: Message): Message

    /**
     * Creates new message on ERROR logging level
     *
     * @param baseMessage [Message] that becomes base of new message
     * @return new [Message] based on [Message] provided as parameter
     */
    fun newErrorMessage(baseMessage: Message): Message

    /**
     * Creates new message on FATAL logging level
     *
     * @param baseMessage [Message] that becomes base of new message
     * @return new [Message] based on [Message] provided as parameter
     */
    fun newFatalMessage(baseMessage: Message): Message
}
