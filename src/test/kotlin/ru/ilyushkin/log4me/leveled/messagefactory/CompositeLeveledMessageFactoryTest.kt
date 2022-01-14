package ru.ilyushkin.log4me.leveled.messagefactory

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifySequence
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.ilyushkin.log4me.message.Message
import kotlin.test.assertEquals

/**
 * @author Alex Ilyushkin
 */
@DisplayName("CompositeLeveledMessageFactory")
class CompositeLeveledMessageFactoryTest {

    @Test
    @DisplayName("newTraceMessage(Message): decorates Message provided as parameter through all underlying LeveledMessageFactories")
    fun `newTraceMessage(Message) test`() {
        val messageParam = mockk<Message>()
        val leveledMessageFactoryNewTraceMessageMethodResult = mockk<Message>()
        val leveledMessageFactory = mockk<LeveledMessageFactory> {
            every {
                newTraceMessage(messageParam)
            } returns leveledMessageFactoryNewTraceMessageMethodResult
        }
        val leveledMessageFactoryNewTraceMessageMethodResult1 = mockk<Message>()
        val leveledMessageFactory1 = mockk<LeveledMessageFactory> {
            every {
                newTraceMessage(leveledMessageFactoryNewTraceMessageMethodResult)
            } returns leveledMessageFactoryNewTraceMessageMethodResult1
        }
        val leveledMessageFactoryNewTraceMessageMethodResult2 = mockk<Message>()
        val leveledMessageFactory2 = mockk<LeveledMessageFactory> {
            every {
                newTraceMessage(leveledMessageFactoryNewTraceMessageMethodResult1)
            } returns leveledMessageFactoryNewTraceMessageMethodResult2
        }

        val compositeLeveledMessageFactory = CompositeLeveledMessageFactory(
            leveledMessageFactory,
            leveledMessageFactory1,
            leveledMessageFactory2,
        )

        assertEquals(
            expected  = leveledMessageFactoryNewTraceMessageMethodResult2,
            actual = compositeLeveledMessageFactory.newTraceMessage(
                baseMessage = messageParam
            )
        )
        verifySequence {
            leveledMessageFactory.newTraceMessage(messageParam)
            leveledMessageFactory1.newTraceMessage(leveledMessageFactoryNewTraceMessageMethodResult)
            leveledMessageFactory2.newTraceMessage(leveledMessageFactoryNewTraceMessageMethodResult1)
            leveledMessageFactoryNewTraceMessageMethodResult2 == leveledMessageFactoryNewTraceMessageMethodResult2
        }
        confirmVerified(
            messageParam,
            leveledMessageFactoryNewTraceMessageMethodResult,
            leveledMessageFactory,
            leveledMessageFactoryNewTraceMessageMethodResult1,
            leveledMessageFactory1,
            leveledMessageFactoryNewTraceMessageMethodResult2,
            leveledMessageFactory2
        )
    }

    @Test
    @DisplayName("newDebugMessage(Message): decorates Message provided as parameter through all underlying LeveledMessageFactories")
    fun `newDebugMessage(Message) test`() {
        val messageParam = mockk<Message>()
        val leveledMessageFactoryNewDebugMessageMethodResult = mockk<Message>()
        val leveledMessageFactory = mockk<LeveledMessageFactory> {
            every {
                newDebugMessage(messageParam)
            } returns leveledMessageFactoryNewDebugMessageMethodResult
        }
        val leveledMessageFactoryNewDebugMessageMethodResult1 = mockk<Message>()
        val leveledMessageFactory1 = mockk<LeveledMessageFactory> {
            every {
                newDebugMessage(leveledMessageFactoryNewDebugMessageMethodResult)
            } returns leveledMessageFactoryNewDebugMessageMethodResult1
        }
        val leveledMessageFactoryNewDebugMessageMethodResult2 = mockk<Message>()
        val leveledMessageFactory2 = mockk<LeveledMessageFactory> {
            every {
                newDebugMessage(leveledMessageFactoryNewDebugMessageMethodResult1)
            } returns leveledMessageFactoryNewDebugMessageMethodResult2
        }

        val compositeLeveledMessageFactory = CompositeLeveledMessageFactory(
            leveledMessageFactory,
            leveledMessageFactory1,
            leveledMessageFactory2,
        )

        assertEquals(
            expected  = leveledMessageFactoryNewDebugMessageMethodResult2,
            actual = compositeLeveledMessageFactory.newDebugMessage(
                baseMessage = messageParam
            )
        )
        verifySequence {
            leveledMessageFactory.newDebugMessage(messageParam)
            leveledMessageFactory1.newDebugMessage(leveledMessageFactoryNewDebugMessageMethodResult)
            leveledMessageFactory2.newDebugMessage(leveledMessageFactoryNewDebugMessageMethodResult1)
            leveledMessageFactoryNewDebugMessageMethodResult2 == leveledMessageFactoryNewDebugMessageMethodResult2
        }
        confirmVerified(
            messageParam,
            leveledMessageFactoryNewDebugMessageMethodResult,
            leveledMessageFactory,
            leveledMessageFactoryNewDebugMessageMethodResult1,
            leveledMessageFactory1,
            leveledMessageFactoryNewDebugMessageMethodResult2,
            leveledMessageFactory2
        )
    }

    @Test
    @DisplayName("newInfoMessage(Message): decorates Message provided as parameter through all underlying LeveledMessageFactories")
    fun `newInfoMessage(Message) test`() {
        val messageParam = mockk<Message>()
        val leveledMessageFactoryNewInfoMessageMethodResult = mockk<Message>()
        val leveledMessageFactory = mockk<LeveledMessageFactory> {
            every {
                newInfoMessage(messageParam)
            } returns leveledMessageFactoryNewInfoMessageMethodResult
        }
        val leveledMessageFactoryNewInfoMessageMethodResult1 = mockk<Message>()
        val leveledMessageFactory1 = mockk<LeveledMessageFactory> {
            every {
                newInfoMessage(leveledMessageFactoryNewInfoMessageMethodResult)
            } returns leveledMessageFactoryNewInfoMessageMethodResult1
        }
        val leveledMessageFactoryNewInfoMessageMethodResult2 = mockk<Message>()
        val leveledMessageFactory2 = mockk<LeveledMessageFactory> {
            every {
                newInfoMessage(leveledMessageFactoryNewInfoMessageMethodResult1)
            } returns leveledMessageFactoryNewInfoMessageMethodResult2
        }

        val compositeLeveledMessageFactory = CompositeLeveledMessageFactory(
            leveledMessageFactory,
            leveledMessageFactory1,
            leveledMessageFactory2,
        )

        assertEquals(
            expected  = leveledMessageFactoryNewInfoMessageMethodResult2,
            actual = compositeLeveledMessageFactory.newInfoMessage(
                baseMessage = messageParam
            )
        )
        verifySequence {
            leveledMessageFactory.newInfoMessage(messageParam)
            leveledMessageFactory1.newInfoMessage(leveledMessageFactoryNewInfoMessageMethodResult)
            leveledMessageFactory2.newInfoMessage(leveledMessageFactoryNewInfoMessageMethodResult1)
            leveledMessageFactoryNewInfoMessageMethodResult2 == leveledMessageFactoryNewInfoMessageMethodResult2
        }
        confirmVerified(
            messageParam,
            leveledMessageFactoryNewInfoMessageMethodResult,
            leveledMessageFactory,
            leveledMessageFactoryNewInfoMessageMethodResult1,
            leveledMessageFactory1,
            leveledMessageFactoryNewInfoMessageMethodResult2,
            leveledMessageFactory2
        )
    }

    @Test
    @DisplayName("newWarningMessage(Message): decorates Message provided as parameter through all underlying LeveledMessageFactories")
    fun `newWarningMessage(Message) test`() {
        val messageParam = mockk<Message>()
        val leveledMessageFactoryNewWarningMessageMethodResult = mockk<Message>()
        val leveledMessageFactory = mockk<LeveledMessageFactory> {
            every {
                newWarningMessage(messageParam)
            } returns leveledMessageFactoryNewWarningMessageMethodResult
        }
        val leveledMessageFactoryNewWarningMessageMethodResult1 = mockk<Message>()
        val leveledMessageFactory1 = mockk<LeveledMessageFactory> {
            every {
                newWarningMessage(leveledMessageFactoryNewWarningMessageMethodResult)
            } returns leveledMessageFactoryNewWarningMessageMethodResult1
        }
        val leveledMessageFactoryNewWarningMessageMethodResult2 = mockk<Message>()
        val leveledMessageFactory2 = mockk<LeveledMessageFactory> {
            every {
                newWarningMessage(leveledMessageFactoryNewWarningMessageMethodResult1)
            } returns leveledMessageFactoryNewWarningMessageMethodResult2
        }

        val compositeLeveledMessageFactory = CompositeLeveledMessageFactory(
            leveledMessageFactory,
            leveledMessageFactory1,
            leveledMessageFactory2,
        )

        assertEquals(
            expected  = leveledMessageFactoryNewWarningMessageMethodResult2,
            actual = compositeLeveledMessageFactory.newWarningMessage(
                baseMessage = messageParam
            )
        )
        verifySequence {
            leveledMessageFactory.newWarningMessage(messageParam)
            leveledMessageFactory1.newWarningMessage(leveledMessageFactoryNewWarningMessageMethodResult)
            leveledMessageFactory2.newWarningMessage(leveledMessageFactoryNewWarningMessageMethodResult1)
            leveledMessageFactoryNewWarningMessageMethodResult2 == leveledMessageFactoryNewWarningMessageMethodResult2
        }
        confirmVerified(
            messageParam,
            leveledMessageFactoryNewWarningMessageMethodResult,
            leveledMessageFactory,
            leveledMessageFactoryNewWarningMessageMethodResult1,
            leveledMessageFactory1,
            leveledMessageFactoryNewWarningMessageMethodResult2,
            leveledMessageFactory2
        )
    }

    @Test
    @DisplayName("newErrorMessage(Message): decorates Message provided as parameter through all underlying LeveledMessageFactories")
    fun `newErrorMessage(Message) test`() {
        val messageParam = mockk<Message>()
        val leveledMessageFactoryNewErrorMessageMethodResult = mockk<Message>()
        val leveledMessageFactory = mockk<LeveledMessageFactory> {
            every {
                newErrorMessage(messageParam)
            } returns leveledMessageFactoryNewErrorMessageMethodResult
        }
        val leveledMessageFactoryNewErrorMessageMethodResult1 = mockk<Message>()
        val leveledMessageFactory1 = mockk<LeveledMessageFactory> {
            every {
                newErrorMessage(leveledMessageFactoryNewErrorMessageMethodResult)
            } returns leveledMessageFactoryNewErrorMessageMethodResult1
        }
        val leveledMessageFactoryNewErrorMessageMethodResult2 = mockk<Message>()
        val leveledMessageFactory2 = mockk<LeveledMessageFactory> {
            every {
                newErrorMessage(leveledMessageFactoryNewErrorMessageMethodResult1)
            } returns leveledMessageFactoryNewErrorMessageMethodResult2
        }

        val compositeLeveledMessageFactory = CompositeLeveledMessageFactory(
            leveledMessageFactory,
            leveledMessageFactory1,
            leveledMessageFactory2,
        )

        assertEquals(
            expected  = leveledMessageFactoryNewErrorMessageMethodResult2,
            actual = compositeLeveledMessageFactory.newErrorMessage(
                baseMessage = messageParam
            )
        )
        verifySequence {
            leveledMessageFactory.newErrorMessage(messageParam)
            leveledMessageFactory1.newErrorMessage(leveledMessageFactoryNewErrorMessageMethodResult)
            leveledMessageFactory2.newErrorMessage(leveledMessageFactoryNewErrorMessageMethodResult1)
            leveledMessageFactoryNewErrorMessageMethodResult2 == leveledMessageFactoryNewErrorMessageMethodResult2
        }
        confirmVerified(
            messageParam,
            leveledMessageFactoryNewErrorMessageMethodResult,
            leveledMessageFactory,
            leveledMessageFactoryNewErrorMessageMethodResult1,
            leveledMessageFactory1,
            leveledMessageFactoryNewErrorMessageMethodResult2,
            leveledMessageFactory2
        )
    }

    @Test
    @DisplayName("newFatalMessage(Message): decorates Message provided as parameter through all underlying LeveledMessageFactories")
    fun `newFatalMessage(Message) test`() {
        val messageParam = mockk<Message>()
        val leveledMessageFactoryNewFatalMessageMethodResult = mockk<Message>()
        val leveledMessageFactory = mockk<LeveledMessageFactory> {
            every {
                newFatalMessage(messageParam)
            } returns leveledMessageFactoryNewFatalMessageMethodResult
        }
        val leveledMessageFactoryNewFatalMessageMethodResult1 = mockk<Message>()
        val leveledMessageFactory1 = mockk<LeveledMessageFactory> {
            every {
                newFatalMessage(leveledMessageFactoryNewFatalMessageMethodResult)
            } returns leveledMessageFactoryNewFatalMessageMethodResult1
        }
        val leveledMessageFactoryNewFatalMessageMethodResult2 = mockk<Message>()
        val leveledMessageFactory2 = mockk<LeveledMessageFactory> {
            every {
                newFatalMessage(leveledMessageFactoryNewFatalMessageMethodResult1)
            } returns leveledMessageFactoryNewFatalMessageMethodResult2
        }

        val compositeLeveledMessageFactory = CompositeLeveledMessageFactory(
            leveledMessageFactory,
            leveledMessageFactory1,
            leveledMessageFactory2,
        )

        assertEquals(
            expected  = leveledMessageFactoryNewFatalMessageMethodResult2,
            actual = compositeLeveledMessageFactory.newFatalMessage(
                baseMessage = messageParam
            )
        )
        verifySequence {
            leveledMessageFactory.newFatalMessage(messageParam)
            leveledMessageFactory1.newFatalMessage(leveledMessageFactoryNewFatalMessageMethodResult)
            leveledMessageFactory2.newFatalMessage(leveledMessageFactoryNewFatalMessageMethodResult1)
            leveledMessageFactoryNewFatalMessageMethodResult2 == leveledMessageFactoryNewFatalMessageMethodResult2
        }
        confirmVerified(
            messageParam,
            leveledMessageFactoryNewFatalMessageMethodResult,
            leveledMessageFactory,
            leveledMessageFactoryNewFatalMessageMethodResult1,
            leveledMessageFactory1,
            leveledMessageFactoryNewFatalMessageMethodResult2,
            leveledMessageFactory2
        )
    }
}
