package ru.ilyushkin.log4me

import ru.ilyushkin.log4me.message.Message

/**
 * Presents a log journal that provides main logging API
 *
 * @author Alex Ilyushkin
 */
interface LogJournal {

    /**
     * Logs [Message]
     *
     * @param message [Message] that should be logged
     */
    fun log(message: Message)
}
