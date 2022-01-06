package ru.ilyushkin.log4me.message

/**
 * Presents message to be logged
 *
 * @author Alex Ilyushkin
 */
interface Message {

    /**
     * @return returns a string representation of the message
     */
    fun asString(): String
}
