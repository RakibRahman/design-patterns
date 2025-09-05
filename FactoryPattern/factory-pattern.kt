package FactoryPattern

interface Document{
    fun open()
}

class WordDocument : Document {
    override fun open() {
        println("Opening Word FactoryPattern.Document.")
    }
}

class ExcelDocument : Document {
    override fun open() {
        println("Opening Excel FactoryPattern.Document.")
    }
}

class PdfDocument:Document{
    override fun open() {
        println("Successfully opened PDF FactoryPattern.Document.")
    }
}

class NullDocument:Document{
    override fun open(){
        println("Unknown document type")
    }
}

class DocumentFactory{
    enum class DocumentType{WORD,EXCEL,PDF}

    companion object{
        fun createDocument(type: DocumentType):Document{
            return when(type){
                DocumentType.WORD -> WordDocument()
                DocumentType.EXCEL -> ExcelDocument()
                DocumentType.PDF -> PdfDocument()
                else -> NullDocument()
            }
        }
    }
}

interface Instrument{
    fun play()
}

class Guitar:Instrument{
    override fun play(){
        println("Playing the guitar")
    }
}

class Piano:Instrument{
    override fun play(){
        println("Playing the FactoryPattern.Piano")
    }
}

class NullInstrument:Instrument{
    override fun play(){
        println("Unsupported instrument")
    }
}

class InstrumentFactory{
    enum class InstrumentType{GUITAR,PIANO}

    companion object{
        fun getInstrument(type: InstrumentType?):Instrument{
           return when(type){
               InstrumentType.PIANO -> Piano()
               InstrumentType.GUITAR -> Guitar()
               else -> NullInstrument()
            }
        }
    }
}


fun main(){
    val wordDoc: Document = DocumentFactory.createDocument(DocumentFactory.DocumentType.WORD)
    wordDoc.open()

    val excelDoc: Document = DocumentFactory.createDocument(DocumentFactory.DocumentType.EXCEL)
    excelDoc.open()

    val pdfDoc: Document = DocumentFactory.createDocument(DocumentFactory.DocumentType.PDF)
    pdfDoc.open()

    val guitar :Instrument = InstrumentFactory.getInstrument(InstrumentFactory.InstrumentType.GUITAR)
    guitar.play()

    val piano :Instrument = InstrumentFactory.getInstrument(InstrumentFactory.InstrumentType.PIANO)
    piano.play()

    val invalidInstrument :Instrument = InstrumentFactory.getInstrument(null)
    invalidInstrument.play()

}