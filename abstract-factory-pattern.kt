
// Abstract Factory Interface
interface DocumentAbstractFactory{
    fun createDocument():Document
}


// Concrete Factories
class WordDocumentFactory:DocumentAbstractFactory{
    override fun createDocument(): Document {
        return WordDocument()
    }
}

class ExcelDocumentFactory : DocumentAbstractFactory {
    override fun createDocument(): Document {
        return ExcelDocument()
    }
}

class Client(factory: DocumentAbstractFactory){
    private val document:Document = factory.createDocument()

    fun openDocument(){
        document.open()
    }
}

fun main(){
    val wordFactory:DocumentAbstractFactory = WordDocumentFactory()
    val client1 = Client(wordFactory)
    client1.openDocument() // Outputs: Opening Word Document

    val excelFactory: DocumentAbstractFactory = ExcelDocumentFactory()
    val client2 = Client(excelFactory)
    client2.openDocument() // Outputs: Opening Excel Document
}