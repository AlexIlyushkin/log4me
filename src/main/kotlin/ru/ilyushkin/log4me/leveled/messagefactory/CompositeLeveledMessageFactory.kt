package ru.ilyushkin.log4me.leveled.messagefactory

import ru.ilyushkin.log4me.message.Message

/**
 * Decorates [Message] thorough every underlying [LeveledMessageFactory]
 *
 * @author Alex Ilyushkin
 */
class CompositeLeveledMessageFactory(
    private val leveledMessageFactories: Iterable<LeveledMessageFactory>
) : LeveledMessageFactory {

    constructor(vararg leveledMessageFactories: LeveledMessageFactory)
            : this(leveledMessageFactories = leveledMessageFactories.asIterable())

    override fun newTraceMessage(baseMessage: Message): Message =
        leveledMessageFactories.fold(initial = baseMessage) { message, leveledMessageFactory ->
            leveledMessageFactory.newTraceMessage(baseMessage = message)
        }

    override fun newDebugMessage(baseMessage: Message): Message =
        leveledMessageFactories.fold(initial = baseMessage) { message, leveledMessageFactory ->
            leveledMessageFactory.newDebugMessage(baseMessage = message)
        }

    override fun newInfoMessage(baseMessage: Message): Message =
        leveledMessageFactories.fold(initial = baseMessage) { message, leveledMessageFactory ->
            leveledMessageFactory.newInfoMessage(baseMessage = message)
        }

    override fun newWarningMessage(baseMessage: Message): Message =
        leveledMessageFactories.fold(initial = baseMessage) { message, leveledMessageFactory ->
            leveledMessageFactory.newWarningMessage(baseMessage = message)
        }

    override fun newErrorMessage(baseMessage: Message): Message =
        leveledMessageFactories.fold(initial = baseMessage) { message, leveledMessageFactory ->
            leveledMessageFactory.newErrorMessage(baseMessage = message)
        }

    override fun newFatalMessage(baseMessage: Message): Message =
        leveledMessageFactories.fold(initial = baseMessage) { message, leveledMessageFactory ->
            leveledMessageFactory.newFatalMessage(baseMessage = message)
        }
}
