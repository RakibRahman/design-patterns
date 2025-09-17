package structural_patterns.AdapterPattern

interface MediaPlayer {
    fun playAudio(filename: String)
}

class VLCPlayer {
    fun playVLCFile(filename: String) {
        println("Playing VLC file: $filename")
    }
}

class MediaPlayerAdapter(private val vlcPlayer: VLCPlayer) : MediaPlayer {
    override fun playAudio(filename: String) {
        vlcPlayer.playVLCFile(filename)
    }
}

interface Hdmi {
    fun connectWithHdmiCable()
}

class DisplayPort {
    fun connectWithDisplayPortCable() {
        println("Connected with DisplayPort cable.")
    }
}

class Adapter(private val hdmi: DisplayPort) : Hdmi {
    override fun connectWithHdmiCable() {
        hdmi.connectWithDisplayPortCable()
    }
}

fun main() {
    val vlcPlayer = VLCPlayer()
    val mediaPlayerAdapter = MediaPlayerAdapter(vlcPlayer)
    mediaPlayerAdapter.playAudio("make it rain")

    val displayPort = DisplayPort()
    val adapter: Hdmi = Adapter(displayPort)
    adapter.connectWithHdmiCable()
}
