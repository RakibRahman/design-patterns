package creational_patterns

object Singleton{
    fun showLogs(){
        println("Hello from the creational_patterns.Singleton instance!")
    }
}

object SessionManager{
    init{
        println("Session Manager initialized")
    }

    fun getSessionId(){
        println("session123")
    }
}

class DatabaseConnection private constructor() {

    companion object {
        // creational_patterns.Singleton instance
        private var instance: DatabaseConnection? = null

        fun getInstance(): DatabaseConnection {
            if (instance == null) {
                instance = DatabaseConnection()
            }
            return instance!!
        }
    }

    fun connect() {
        println("Database connected.")
    }
}




fun main(){
    Singleton.showLogs()
    SessionManager.getSessionId()


    // Create the first instance
    val firstInstance = DatabaseConnection.getInstance()

    // Create the second instance
    val secondInstance = DatabaseConnection.getInstance()

    // Verify if both instances are the same
    println(firstInstance == secondInstance) // true

    // Test the connect method
    firstInstance.connect()
}