package ru.ilyushkin.log4me.messagefactory

import ru.ilyushkin.log4me.message.Message

/**
 * Decorates [Message] thorough every underlying [MessageFactory]
 *
 * @author Alex Ilyushkin
 */
class CompositeMessageFactory(
    private val messageFactories: Iterable<MessageFactory>
) : MessageFactory {

    constructor(vararg messageFactories: MessageFactory)
            : this(messageFactories = messageFactories.asIterable())

    override fun newMessage(baseMessage: Message): Message =
        messageFactories.fold(initial = baseMessage) { message, messageFactory ->
            messageFactory.newMessage(message)
        }
}
