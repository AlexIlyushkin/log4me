package ru.ilyushkin.log4me

import io.mockk.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ru.ilyushkin.log4me.message.Message
import java.io.PrintStream

/**
 * @author Alex Ilyushkin
 */
@DisplayName("PrintStreamLogJournal")
class PrintStreamLogJournalTest {

    @Test
    @DisplayName("log(Message): Invokes `asString()` method of the Message provided as parameter " +
            "and provides the result string to `println()` method of underlying PrintStream")
    fun `log(Message) test`() {
        val messageAsString = "I'm message"
        val message = mockk<Message> {
            every { asString() } returns messageAsString
        }
        val printStream = mockk<PrintStream> {
            justRun { println(messageAsString) }
        }

        val printStreamLogJournal = PrintStreamLogJournal(
            printStream = printStream
        )
        printStreamLogJournal.log(message = message)

        verifySequence {
            message.asString()
            printStream.println(messageAsString)
        }
        confirmVerified(message, printStream)
    }

    @Test
    @DisplayName("log(Message): doesn't keep silent if an exception is thrown " +
            "by `println()` method of underlying PrintStream")
    fun `failed log(Message) test`() {
        val messageAsString = "I'm message"
        val message = mockk<Message> {
            every { asString() } returns messageAsString
        }
        val printStream = mockk<PrintStream> {
            every { println(messageAsString) } throws Exception()
        }

        val printStreamLogJournal = PrintStreamLogJournal(
            printStream = printStream
        )
        assertThrows<Exception> { printStreamLogJournal.log(message = message) }

        verifySequence {
            message.asString()
            printStream.println(messageAsString)
        }
        confirmVerified(message, printStream)
    }

    @Test
    @DisplayName("flush(): calls `flush()` method of underlying PrintStream")
    fun `flush() test`() {
        val printStream = mockk<PrintStream> {
            justRun { flush() }
        }

        val printStreamLogJournal = PrintStreamLogJournal(
            printStream = printStream
        )
        printStreamLogJournal.flush()

        verify(exactly = 1) { printStream.flush() }
        confirmVerified(printStream)
    }
}
