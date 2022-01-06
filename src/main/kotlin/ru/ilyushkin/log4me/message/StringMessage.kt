package ru.ilyushkin.log4me.message

/**
 * Simple [String] based implementation of [Message]
 *
 * @author Alex Ilyushkin
 */
class StringMessage(
    private val messageBody: () -> String
) : Message {

    constructor(messageBody: String) : this({ messageBody })

    override fun asString(): String = messageBody()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StringMessage

        if (messageBody != other.messageBody) return false

        return true
    }

    override fun hashCode(): Int {
        return messageBody.hashCode()
    }
}
