package ru.ilyushkin.log4me

import ru.ilyushkin.log4me.message.Message
import java.io.PrintWriter

/**
 * [BufferedLogJournal] implementation based on [PrintWriter]
 *
 * @author Alex Ilyushkin
 */
class PrintWriterLogJournal(
    private val printWriter: PrintWriter,
) : BufferedLogJournal {

    override fun log(message: Message) = printWriter.println(message.asString())

    override fun flush() = printWriter.flush()
}
