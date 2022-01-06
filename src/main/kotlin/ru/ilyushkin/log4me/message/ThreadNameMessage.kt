package ru.ilyushkin.log4me.message

/**
 * Decorator for any [Message]. Adds current thread name as prefix to underlying message `asString()` method result
 *
 * @author Alex Ilyushkin
 */
class ThreadNameMessage(
    private val origin: Message
) : Message by origin {

    override fun asString(): String = "[${Thread.currentThread().name}] ${origin.asString()}"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ThreadNameMessage

        if (origin != other.origin) return false

        return true
    }

    override fun hashCode(): Int {
        return origin.hashCode()
    }
}
