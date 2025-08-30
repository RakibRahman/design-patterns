// Define the abstract class MusicFile with an abstract play method
abstract class MusicFile {
    abstract fun play()
}

// Define MP3File class which extends MusicFile
class MP3File : MusicFile() {
    override fun play() {
        println("Playing MP3 File.")
    }
}

// Define WAVFile class which extends MusicFile
class WAVFile : MusicFile() {
    override fun play() {
        println("Playing WAV File.")
    }
}

// Define FLACFile class which extends MusicFile
class FLACFile : MusicFile() {
    override fun play() {
        println("Playing FLAC File.")
    }
}

// Define the MusicFileAbstractFactory interface with a createMusicFile method
interface MusicFileAbstractFactory {
    fun createMusicFile(): MusicFile
}

// Define MP3FileFactory class which implements MusicFileAbstractFactory
class MP3FileFactory : MusicFileAbstractFactory {
    override fun createMusicFile(): MusicFile {
        return MP3File()
    }
}

// Define WAVFileFactory class which implements MusicFileAbstractFactory
class WAVFileFactory : MusicFileAbstractFactory {
    override fun createMusicFile(): MusicFile {
        return WAVFile()
    }
}

// Define FLACFileFactory class which implements MusicFileAbstractFactory
class FLACFileFactory : MusicFileAbstractFactory {
    override fun createMusicFile(): MusicFile {
        return FLACFile()
    }
}

// Define MusicFileFactory object with a static createMusicFile method
object MusicFileFactory {
    fun createMusicFile(factory: MusicFileAbstractFactory): MusicFile {
        return factory.createMusicFile()
    }
}

fun main() {
    // Create an MP3File using MusicFileFactory and the respective factory
    val mp3File = MusicFileFactory.createMusicFile(MP3FileFactory())
    // Call play method on the created MP3File
    mp3File.play()

    // Create a WAVFile using MusicFileFactory and the respective factory
    val wavFile = MusicFileFactory.createMusicFile(WAVFileFactory())
    // Call play method on the created WAVFile
    wavFile.play()

    // Create a FLACFile using MusicFileFactory and the respective factory
    val flacFile = MusicFileFactory.createMusicFile(FLACFileFactory())
    // Call play method on the created FLACFile
    flacFile.play()
}