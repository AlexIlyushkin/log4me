package ru.ilyushkin.log4me.messagefactory

import ru.ilyushkin.log4me.message.Message
import ru.ilyushkin.log4me.message.ThreadNameMessage

/**
 * Wraps base [Message] provided as parameter to [ThreadNameMessage]
 *
 * @author Alex Ilyushkin
 */
class ThreadNameMessageFactory : MessageFactory {

    /**
     * @param baseMessage [Message] that becomes base of new message
     * @return new [Message] based on [Message] provided as parameter
     */
    override fun newMessage(baseMessage: Message): Message =
        ThreadNameMessage(origin = baseMessage)
}
