package ru.ilyushkin.log4me

import io.mockk.confirmVerified
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verifySequence
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.ilyushkin.log4me.message.Message

/**
 * @author Alex Ilyushkin
 */
@DisplayName("ThresholdFlushLogJournal")
class ThresholdFlushLogJournalTest {

    @Test
    @DisplayName(
        """log(Message): calls `flush()` method on every
            `log(Message)` method call of underlying BufferedLogJournal"""
    )
    fun `log(Message) test for 0 threshold`() {
        val messageParam = mockk<Message>()
        val origin = mockk<BufferedLogJournal> {
            justRun { log(message = messageParam) }
            justRun { flush() }
        }

        val thresholdFlushLogJournal = ThresholdFlushLogJournal(
            origin = origin,
            threshold = 0,
        )
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)

        verifySequence {
            origin.log(message = messageParam)
            origin.flush()
            origin.log(message = messageParam)
            origin.flush()
            origin.log(message = messageParam)
            origin.flush()
        }
        confirmVerified(messageParam, origin)
    }

    @Test
    @DisplayName(
        """log(Message): calls `flush()` method on 6th
           `log(Message)` method call of underlying BufferedLogJournal"""
    )
    fun `log(Message) test for 5 threshold`() {
        val messageParam = mockk<Message>()
        val origin = mockk<BufferedLogJournal> {
            justRun { log(message = messageParam) }
            justRun { flush() }
        }

        val thresholdFlushLogJournal = ThresholdFlushLogJournal(
            origin = origin,
            threshold = 5,
        )
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)

        verifySequence {
            origin.log(message = messageParam)
            origin.log(message = messageParam)
            origin.log(message = messageParam)
            origin.log(message = messageParam)
            origin.log(message = messageParam)
            origin.log(message = messageParam)
            origin.flush()
        }
        confirmVerified(messageParam, origin)
    }

    @Test
    @DisplayName(
        """log(Message): calls `flush()` method on 11th 
           `log(Message)` method call of underlying BufferedLogJournal"""
    )
    fun `log(Message) test for 10 threshold`() {
        val messageParam = mockk<Message>()
        val origin = mockk<BufferedLogJournal> {
            justRun { log(message = messageParam) }
            justRun { flush() }
        }

        val thresholdFlushLogJournal = ThresholdFlushLogJournal(
            origin = origin,
            threshold = 10,
        )
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)
        thresholdFlushLogJournal.log(message = messageParam)

        verifySequence {
            origin.log(message = messageParam)
            origin.log(message = messageParam)
            origin.log(message = messageParam)
            origin.log(message = messageParam)
            origin.log(message = messageParam)
            origin.log(message = messageParam)
            origin.log(message = messageParam)
            origin.log(message = messageParam)
            origin.log(message = messageParam)
            origin.log(message = messageParam)
            origin.log(message = messageParam)
            origin.flush()
        }
        confirmVerified(messageParam, origin)
    }
}
