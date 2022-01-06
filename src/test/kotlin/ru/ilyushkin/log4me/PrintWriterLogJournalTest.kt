package ru.ilyushkin.log4me

import io.mockk.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ru.ilyushkin.log4me.message.Message
import java.io.PrintWriter

/**
 * @author Alex Ilyushkin
 */
@DisplayName("PrintWriterLogJournal")
class PrintWriterLogJournalTest {

    @Test
    @DisplayName("log(Message): invokes `asString()` method of the Message provided as parameter " +
            "and provides result string to `println()` method of underlying PrintWriter")
    fun `log(Message) test`() {
        val messageAsString = "I'm message"
        val message = mockk<Message> {
            every { asString() } returns messageAsString
        }
        val printWriter = mockk<PrintWriter> {
            justRun { println(messageAsString) }
        }

        val printWriterLogJournal = PrintWriterLogJournal(
            printWriter = printWriter
        )
        printWriterLogJournal.log(message = message)

        verifySequence {
            message.asString()
            printWriter.println(messageAsString)
        }
        confirmVerified(message, printWriter)
    }

    @Test
    @DisplayName("log(Message): doesn't keep silent if an exception is thrown " +
            "by `println()` method of underlying PrintWriter")
    fun `failed log(Message) test`() {
        val messageAsString = "I'm message"
        val message = mockk<Message> {
            every { asString() } returns messageAsString
        }
        val printWriter = mockk<PrintWriter> {
            every { println(messageAsString) } throws Exception()
        }

        val printWriterLogJournal = PrintWriterLogJournal(
            printWriter = printWriter
        )
        assertThrows<Exception> { printWriterLogJournal.log(message = message) }

        verifySequence {
            message.asString()
            printWriter.println(messageAsString)
        }
        confirmVerified(message, printWriter)
    }

    @Test
    @DisplayName("flush(): calls `flush()` method of underlying PrintWriter")
    fun `flush() test`() {
        val printWriter = mockk<PrintWriter> {
            justRun { flush() }
        }

        val printWriterLogJournal = PrintWriterLogJournal(
            printWriter = printWriter
        )
        printWriterLogJournal.flush()

        verify(exactly = 1) { printWriter.flush() }
        confirmVerified(printWriter)
    }
}
