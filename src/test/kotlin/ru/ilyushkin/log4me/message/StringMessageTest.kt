package ru.ilyushkin.log4me.message

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

/**
 * @author Alex Ilyushkin
 */
@DisplayName("StringMessage")
class StringMessageTest {

    @Test
    @DisplayName("asString(): returns underlying String. For created through constructor with function argument.")
    fun `asString() test for StringMessage created through constructor with function argument`() {
        //create a string though constructor to avoid string pool to purely prove referential equality
        val string = String("I'm underlying string".toCharArray())

        val stringMessage = StringMessage(
            messageBody = { string }
        )
        val asStringResult: String = stringMessage.asString()

        assertTrue { string === asStringResult }
    }

    @Test
    @DisplayName("asString(): returns underlying String. For created through constructor with String argument.")
    fun `asString() test for created through constructor with String argument`() {
        //create a string though constructor to avoid string pool to purely prove referential equality
        val string = String("I'm underlying string".toCharArray())

        val stringMessage = StringMessage(
            messageBody = string
        )
        val asStringResult: String = stringMessage.asString()

        assertTrue { string === asStringResult }
    }
}
