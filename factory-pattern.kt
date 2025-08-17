import javax.print.Doc

interface Document{
    fun open()
}

class WordDocument : Document {
    override fun open() {
        println("Opening Word Document.")
    }
}

class ExcelDocument : Document {
    override fun open() {
        println("Opening Excel Document.")
    }
}

class DocumentFactory{
    enum class DocumentType{WORD,EXCEL}

    companion object{
        fun createDocument(type: DocumentType):Document{
            return when(type){
                DocumentType.WORD -> WordDocument()
                DocumentType.EXCEL -> ExcelDocument()
                else -> throw IllegalArgumentException("Unknown document type: $type")
            }
        }
    }
}

fun main(){
    val wordDoc: Document = DocumentFactory.createDocument(DocumentFactory.DocumentType.WORD)
    wordDoc.open()

    val excelDoc: Document = DocumentFactory.createDocument(DocumentFactory.DocumentType.EXCEL)
    excelDoc.open()
}