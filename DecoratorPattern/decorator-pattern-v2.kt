// Define the Text interface with a format() method.
interface Text {
    fun format(): String
}

// SimpleText: base implementation of Text
class SimpleText(private val text: String) : Text {
    override fun format(): String = text
}

// Abstract decorator
abstract class TextDecorator(private val decoratedText: Text) : Text {
    override fun format(): String = decoratedText.format()
}

// BoldText decorator
class BoldText(text: Text) : TextDecorator(text) {
    override fun format(): String {
        return "<b>${super.format()}</b>"
    }
}

// ItalicText decorator
class ItalicText(text: Text) : TextDecorator(text) {
    override fun format(): String {
        return "<i>${super.format()}</i>"
    }
}

fun main() {
    val simpleText = SimpleText("Hello, World!")

    val boldText = BoldText(simpleText)
    println(boldText.format()) // <b>Hello, World!</b>

    val italicText = ItalicText(simpleText)
    println(italicText.format()) // <i>Hello, World!</i>

    // Combine Bold + Italic
    val decoratedText = ItalicText(BoldText(simpleText))
    println(decoratedText.format()) // <i><b>Hello, World!</b></i>
}
