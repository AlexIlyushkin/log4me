package ru.ilyushkin.log4me

import io.mockk.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.concurrent.BlockingQueue
import ru.ilyushkin.log4me.message.Message

/**
 * @author Alex Ilyushkin
 */
@DisplayName("EventLoopLogJournal")
class EventLoopLogJournalTest {

    @Test
    @DisplayName("log(Message): puts an message to the event queue")
    fun `log(Message) test`() {
        val messageParam = mockk<Message>()
        val originLogJournal = mockk<LogJournal>()
        val eventQueue = mockk<BlockingQueue<Message>> {
            justRun { put(messageParam) }
        }

        val eventLoopLogJournal = EventLoopLogJournal(
            origin = originLogJournal,
            eventQueue = eventQueue
        )
        eventLoopLogJournal.log(message = messageParam)

        verify(exactly = 1) { eventQueue.put(messageParam) }
        confirmVerified(messageParam, originLogJournal, eventQueue)
    }

    @Test
    @DisplayName("start(): takes messages from the event queue and logs it through origin log journal")
    fun `start() test`() {
        val message = mockk<Message>()
        val originLogJournal = mockk<LogJournal> {
            justRun { log(message) }
        }
        val eventQueue = mockk<BlockingQueue<Message>> {
            //throw exception on second method call to interrupt endless event loop cycle
            every { take() } returns message andThenThrows InterruptingEndlessEventLoopCycleException()
        }

        val eventLoopLogJournal = EventLoopLogJournal(
            origin = originLogJournal,
            eventQueue = eventQueue,
        )
        assertThrows<InterruptingEndlessEventLoopCycleException> { eventLoopLogJournal.start() }

        verifySequence {
            eventQueue.take()
            originLogJournal.log(message)
            eventQueue.take()
        }
        confirmVerified(message, originLogJournal, eventQueue)
    }

    class InterruptingEndlessEventLoopCycleException : RuntimeException()
}
