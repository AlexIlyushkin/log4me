package ru.ilyushkin.log4me.message

import io.mockk.confirmVerified
import io.mockk.every
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
@DisplayName("ThreadMessage")
class ThreadNameMessageTest {

    @Test
    @DisplayName(
        """asString(): concatenates current thread name 
           and result of origin message `asString()` method and returns concatenated string"""
    )
    fun `asString() test`() {
        val messageAsString = "It's message `asString()` method result"
        val message = mockk<Message> {
            every { asString() } returns messageAsString
        }

        val threadNameMessage = ThreadNameMessage(
            origin = message
        )
        val resultAsString = threadNameMessage.asString()

        val expectedResultAsString = "[${Thread.currentThread().name}] $messageAsString"
        assertEquals(
            expected = expectedResultAsString,
            actual = resultAsString
        )
    }

    @Test
    @DisplayName("equals(Any): returns true on itself comparing")
    fun `equals(Any) test`() {
        val message = mockk<Message>()

        val threadNameMessage = ThreadNameMessage(
            origin = message
        )

        assertTrue { threadNameMessage.equals(threadNameMessage) }
        confirmVerified(message)
    }

    @Test
    @DisplayName("equals(Any): returns false if an object of another type provided as parameter")
    fun `equals(Any) for object of another type`() {
        val message = mockk<Message>()

        val threadNameMessage = ThreadNameMessage(
            origin = message
        )

        assertTrue { threadNameMessage != Any() }
        confirmVerified(message)
    }

    @Test
    @DisplayName("equals(Any): returns true if compared ThreadNameMessage have the same underlying messages")
    fun `equals(Any) for the same underlying messages`() {
        val message = mockk<Message>()

        val threadNameMessage = ThreadNameMessage(
            origin = message
        )
        val threadNameMessage1 = ThreadNameMessage(
            origin = message
        )

        assertTrue { threadNameMessage == threadNameMessage1 }
        verify(exactly = 1) { message == message }
        confirmVerified(message)
    }

    @Test
    @DisplayName("equals(Any): returns false if compared ThreadNameMessages have different underlying messages")
    fun `equals(Any) for different underlying messages`() {
        val message = mockk<Message>()
        val message1 = mockk<Message>()

        val threadNameMessage = ThreadNameMessage(
            origin = message
        )
        val threadNameMessage1 = ThreadNameMessage(
            origin = message1
        )

        assertFalse { threadNameMessage == threadNameMessage1 }
        verify(exactly = 1) { message != message1 }
        confirmVerified(message, message1)
    }

    @Test
    @DisplayName("hashCode(): returns hash code of underlying message")
    fun `hashCode() test`() {
        val message = mockk<Message>()

        val threadNameMessage = ThreadNameMessage(
            origin = message
        )
        val hashCodeResult = threadNameMessage.hashCode()

        assertEquals(
            expected = message.hashCode(),
            actual = hashCodeResult
        )
        verify(exactly = 2) { message.hashCode() }
        confirmVerified(message)
    }
}
