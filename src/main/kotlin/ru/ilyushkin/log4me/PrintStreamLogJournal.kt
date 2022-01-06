package ru.ilyushkin.log4me

import ru.ilyushkin.log4me.message.Message
import java.io.PrintStream

/**
 * [BufferedLogJournal] implementation based on [PrintStream]
 *
 * @author Alex Ilyushkin
 */
class PrintStreamLogJournal(
    private val printStream: PrintStream
) : BufferedLogJournal {

    override fun log(message: Message) = printStream.println(message.asString())

    override fun flush() = printStream.flush()
}
