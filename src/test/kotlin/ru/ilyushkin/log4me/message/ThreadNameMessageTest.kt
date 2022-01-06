package ru.ilyushkin.log4me.message

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * @author Alex Ilyushkin
 */
@DisplayName("ThreadMessage")
class ThreadNameMessageTest {

    @Test
    @DisplayName("asString(): concatenates current thread name " +
            "and result of origin message `asString()` method and returns concatenated string"
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
}
