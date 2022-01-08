package ru.ilyushkin.log4me.leveled.journal

import io.mockk.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.ilyushkin.log4me.leveled.messagefactory.LeveledMessageFactory
import ru.ilyushkin.log4me.message.Message

/**
 * @author Alex Ilyushkin
 */
@DisplayName("MessageFactoryLeveledLogJournal")
class MessageFactoryLeveledLogJournalTest {

    @Test
    @DisplayName(
        """logTrace(Message): provides Message to LeveledMessageFactory.newTraceMessage(Message) 
           and logs result message on TRACE logging level through underlying LeveledLogJournal"""
    )
    fun `logTrace(Message) test`() {
        val messageParam = mockk<Message>()
        val newTraceMessageMethodResult = mockk<Message>()
        val leveledMessageFactory = mockk<LeveledMessageFactory> {
            every { newTraceMessage(baseMessage = messageParam) } returns newTraceMessageMethodResult
        }
        val origin = mockk<LeveledLogJournal> {
            justRun { logTrace(message = newTraceMessageMethodResult) }
        }

        val messageFactoryLeveledLogJournal = MessageFactoryLeveledLogJournal(
            origin = origin,
            messageFactory = leveledMessageFactory
        )
        messageFactoryLeveledLogJournal.logTrace(message = messageParam)

        verifySequence {
            leveledMessageFactory.newTraceMessage(baseMessage = messageParam)
            origin.logTrace(message = newTraceMessageMethodResult)
        }
        confirmVerified(messageParam, newTraceMessageMethodResult, leveledMessageFactory, origin)
    }

    @Test
    @DisplayName(
        """logDebug(Message): provides Message to LeveledMessageFactory.newDebugMessage(Message) 
           and logs result message on DEBUG logging level through underlying LeveledLogJournal"""
    )
    fun `logDebug(Message) test`() {
        val messageParam = mockk<Message>()
        val newDebugMessageMethodResult = mockk<Message>()
        val leveledMessageFactory = mockk<LeveledMessageFactory> {
            every { newDebugMessage(baseMessage = messageParam) } returns newDebugMessageMethodResult
        }
        val origin = mockk<LeveledLogJournal> {
            justRun { logDebug(message = newDebugMessageMethodResult) }
        }

        val messageFactoryLeveledLogJournal = MessageFactoryLeveledLogJournal(
            origin = origin,
            messageFactory = leveledMessageFactory
        )
        messageFactoryLeveledLogJournal.logDebug(message = messageParam)

        verifySequence {
            leveledMessageFactory.newDebugMessage(baseMessage = messageParam)
            origin.logDebug(message = newDebugMessageMethodResult)
        }
        confirmVerified(messageParam, newDebugMessageMethodResult, leveledMessageFactory, origin)
    }

    @Test
    @DisplayName(
        """logInfo(Message): provides Message to LeveledMessageFactory.newInfoMessage(Message) 
           and logs result message on INFO logging level through underlying LeveledLogJournal"""
    )
    fun `logInfo(Message) test`() {
        val messageParam = mockk<Message>()
        val newInfoMessageMethodResult = mockk<Message>()
        val leveledMessageFactory = mockk<LeveledMessageFactory> {
            every { newInfoMessage(baseMessage = messageParam) } returns newInfoMessageMethodResult
        }
        val origin = mockk<LeveledLogJournal> {
            justRun { logInfo(message = newInfoMessageMethodResult) }
        }

        val messageFactoryLeveledLogJournal = MessageFactoryLeveledLogJournal(
            origin = origin,
            messageFactory = leveledMessageFactory
        )
        messageFactoryLeveledLogJournal.logInfo(message = messageParam)

        verifySequence {
            leveledMessageFactory.newInfoMessage(baseMessage = messageParam)
            origin.logInfo(message = newInfoMessageMethodResult)
        }
        confirmVerified(messageParam, newInfoMessageMethodResult, leveledMessageFactory, origin)
    }

    @Test
    @DisplayName(
        """logWarning(Message): provides Message to LeveledMessageFactory.newWarningMessage(Message) 
           and logs result message on WARNING logging level through underlying LeveledLogJournal"""
    )
    fun `logWarning(Message) test`() {
        val messageParam = mockk<Message>()
        val newWarningMessageMethodResult = mockk<Message>()
        val leveledMessageFactory = mockk<LeveledMessageFactory> {
            every { newWarningMessage(baseMessage = messageParam) } returns newWarningMessageMethodResult
        }
        val origin = mockk<LeveledLogJournal> {
            justRun { logWarning(message = newWarningMessageMethodResult) }
        }

        val messageFactoryLeveledLogJournal = MessageFactoryLeveledLogJournal(
            origin = origin,
            messageFactory = leveledMessageFactory
        )
        messageFactoryLeveledLogJournal.logWarning(message = messageParam)

        verifySequence {
            leveledMessageFactory.newWarningMessage(baseMessage = messageParam)
            origin.logWarning(message = newWarningMessageMethodResult)
        }
        confirmVerified(messageParam, newWarningMessageMethodResult, leveledMessageFactory, origin)
    }

    @Test
    @DisplayName(
        """logError(Message): provides Message to LeveledMessageFactory.newErrorMessage(Message) 
           and logs result message on ERROR logging level through underlying LeveledLogJournal"""
    )
    fun `logError(Message) test`() {
        val messageParam = mockk<Message>()
        val newErrorMessageMethodResult = mockk<Message>()
        val leveledMessageFactory = mockk<LeveledMessageFactory> {
            every { newErrorMessage(baseMessage = messageParam) } returns newErrorMessageMethodResult
        }
        val origin = mockk<LeveledLogJournal> {
            justRun { logError(message = newErrorMessageMethodResult) }
        }

        val messageFactoryLeveledLogJournal = MessageFactoryLeveledLogJournal(
            origin = origin,
            messageFactory = leveledMessageFactory
        )
        messageFactoryLeveledLogJournal.logError(message = messageParam)

        verifySequence {
            leveledMessageFactory.newErrorMessage(baseMessage = messageParam)
            origin.logError(message = newErrorMessageMethodResult)
        }
        confirmVerified(messageParam, newErrorMessageMethodResult, leveledMessageFactory, origin)
    }

    @Test
    @DisplayName(
        """logFatal(Message): provides Message to LeveledMessageFactory.newFatalMessage(Message) 
           and logs result message on FATAL logging level through underlying LeveledLogJournal"""
    )
    fun `logFatal(Message) test`() {
        val messageParam = mockk<Message>()
        val newFatalMessageMethodResult = mockk<Message>()
        val leveledMessageFactory = mockk<LeveledMessageFactory> {
            every { newFatalMessage(baseMessage = messageParam) } returns newFatalMessageMethodResult
        }
        val origin = mockk<LeveledLogJournal> {
            justRun { logFatal(message = newFatalMessageMethodResult) }
        }

        val messageFactoryLeveledLogJournal = MessageFactoryLeveledLogJournal(
            origin = origin,
            messageFactory = leveledMessageFactory
        )
        messageFactoryLeveledLogJournal.logFatal(message = messageParam)

        verifySequence {
            leveledMessageFactory.newFatalMessage(baseMessage = messageParam)
            origin.logFatal(message = newFatalMessageMethodResult)
        }
        confirmVerified(messageParam, newFatalMessageMethodResult, leveledMessageFactory, origin)
    }
}
