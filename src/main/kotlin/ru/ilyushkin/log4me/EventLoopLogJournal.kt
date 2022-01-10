package ru.ilyushkin.log4me

import ru.ilyushkin.log4me.message.Message
import java.util.concurrent.BlockingQueue

/**
 * Event loop based [AsyncLogJournal] implementation
 *
 * Delegates logging to underlying [LogJournal]
 *
 * @author Alex Ilyushkin
 */
class EventLoopLogJournal(
    private val origin: LogJournal,
    private val eventQueue: BlockingQueue<Message>,
) : AsyncLogJournal {

    /**
     * Puts [Message] provided as parameter to the [BlockingQueue]
     *
     * @param message [Message] that should be logged
     */
    override fun log(message: Message) {
        eventQueue.put(message)
    }

    /**
     * Starts to take [Message]s from the [BlockingQueue] and delegates logging to underlying [LogJournal]
     *
     * Blocks current thread
     */
    override fun start() {
        while (true) {
            origin.log(message = eventQueue.take())
        }
    }
}
