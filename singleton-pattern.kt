object Singleton{
    fun showLogs(){
        println("Hello from the Singleton instance!")
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


fun main(){
    Singleton.showLogs()
    SessionManager.getSessionId()
}