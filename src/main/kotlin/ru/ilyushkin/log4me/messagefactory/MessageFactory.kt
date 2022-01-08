package ru.ilyushkin.log4me.messagefactory

import ru.ilyushkin.log4me.message.Message

/**
 * Creates [Message]s
 *
 * @author Alex Ilyushkin
 */
interface MessageFactory {

    /**
     * @param baseMessage [Message] that becomes base of new message
     * @return new [Message] based on [Message] provided as parameter
     */
    fun newMessage(baseMessage: Message): Message
}
