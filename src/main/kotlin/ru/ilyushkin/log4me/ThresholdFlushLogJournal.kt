package ru.ilyushkin.log4me

import ru.ilyushkin.log4me.message.Message

/**
 * Logs messages through underlying [BufferedLogJournal]
 * and flushes it on reaching threshold of logging operations quantity
 *
 * NOT THREAD SAFE
 *
 * @author Alex Ilyushkin
 */
class ThresholdFlushLogJournal(
    private val origin: BufferedLogJournal,
    private val threshold: Int,
) : LogJournal {

    private var counter = 0

    /**
     * Logs [Message]
     *
     * @param message [Message] that should be logged
     */
    override fun log(message: Message) {
        origin.log(message = message)
        tryToFlush()
    }

    private fun tryToFlush() {
        if (counter++ == threshold) {
            origin.flush()
            counter = 0
        }
    }
}
