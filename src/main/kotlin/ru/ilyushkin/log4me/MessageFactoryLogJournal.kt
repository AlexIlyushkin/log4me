package ru.ilyushkin.log4me

import ru.ilyushkin.log4me.message.Message
import ru.ilyushkin.log4me.messagefactory.MessageFactory

/**
 * [LogJournal] implementation that logs a messages created by [MessageFactory] through underlying [LogJournal]
 *
 * @author Alex Ilyushkin
 */
class MessageFactoryLogJournal(
    private val origin: LogJournal,
    private val messageFactory: MessageFactory
) : LogJournal {

    /**
     * Logs [Message]
     *
     * @param message [Message] that should be logged
     */
    override fun log(message: Message) =
        origin.log(
            message = messageFactory.newMessage(
                baseMessage = message
            )
        )
}
