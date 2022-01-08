package ru.ilyushkin.log4me.message

import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
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

    @Test
    @DisplayName("equals(Any): returns true on itself comparing")
    fun `equals(Any) test for itself comparing`() {
        val messageBody = mockk<() -> String>()

        val stringMessage = StringMessage(
            messageBody = messageBody
        )

        assertTrue { stringMessage == stringMessage }
        confirmVerified(messageBody)
    }

    @Test
    @DisplayName("equals(Any): returns false if an object of another type provided as parameter")
    fun `equals(Any) for object of another type`() {
        val messageBody = mockk<() -> String>()

        val stringMessage = StringMessage(
            messageBody = messageBody
        )

        assertFalse { stringMessage.equals(Any()) }
        confirmVerified(messageBody)
    }

    @Test
    @DisplayName("equals(Any): returns true if compared StringMessages have the same message bodies")
    fun `equals(Any) test for the same message bodies`() {
        val messageBody = mockk<() -> String>()

        val stringMessage = StringMessage(
            messageBody = messageBody
        )
        val stringMessage1 = StringMessage(
            messageBody = messageBody
        )

        assertTrue { stringMessage == stringMessage1 }
        verify(exactly = 1) { messageBody.equals(messageBody) }
        confirmVerified(messageBody)
    }

    @Test
    @DisplayName("equals(Any): returns false if compared StringMessages have different message bodies")
    fun `equals(Any) test for different message bodies`() {
        val messageBody = mockk<() -> String>()
        val messageBody1 = mockk<() -> String>()

        val stringMessage = StringMessage(
            messageBody = messageBody
        )
        val stringMessage1 = StringMessage(
            messageBody = messageBody1
        )

        assertTrue { stringMessage != stringMessage1 }
        verify(exactly = 1) { messageBody.equals(messageBody1) }
        confirmVerified(messageBody, messageBody1)
    }

    @Test
    @DisplayName("hashCode(): returns hashcode of underlying message body")
    fun `hashCode() test`() {
        val messageBody = mockk<() -> String>()

        val stringMessage = StringMessage(
            messageBody = messageBody
        )
        val hashCodeResult: Int = stringMessage.hashCode()

        assertEquals(
            expected = messageBody.hashCode(),
            actual = hashCodeResult
        )
        verify(exactly = 2) { messageBody.hashCode() }
        confirmVerified(messageBody)
    }
}
