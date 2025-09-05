package AbstractFactoryPattern

// Define the abstract class AbstractFactoryPattern.MusicFile with an abstract play method
abstract class MusicFile {
    abstract fun play()
}

// Define AbstractFactoryPattern.MP3File class which extends AbstractFactoryPattern.MusicFile
class MP3File : MusicFile() {
    override fun play() {
        println("Playing MP3 File.")
    }
}

// Define AbstractFactoryPattern.WAVFile class which extends AbstractFactoryPattern.MusicFile
class WAVFile : MusicFile() {
    override fun play() {
        println("Playing WAV File.")
    }
}

// Define AbstractFactoryPattern.FLACFile class which extends AbstractFactoryPattern.MusicFile
class FLACFile : MusicFile() {
    override fun play() {
        println("Playing FLAC File.")
    }
}

// Define the AbstractFactoryPattern.MusicFileAbstractFactory interface with a createMusicFile method
interface MusicFileAbstractFactory {
    fun createMusicFile(): MusicFile
}

// Define AbstractFactoryPattern.MP3FileFactory class which implements AbstractFactoryPattern.MusicFileAbstractFactory
class MP3FileFactory : MusicFileAbstractFactory {
    override fun createMusicFile(): MusicFile {
        return MP3File()
    }
}

// Define AbstractFactoryPattern.WAVFileFactory class which implements AbstractFactoryPattern.MusicFileAbstractFactory
class WAVFileFactory : MusicFileAbstractFactory {
    override fun createMusicFile(): MusicFile {
        return WAVFile()
    }
}

// Define AbstractFactoryPattern.FLACFileFactory class which implements AbstractFactoryPattern.MusicFileAbstractFactory
class FLACFileFactory : MusicFileAbstractFactory {
    override fun createMusicFile(): MusicFile {
        return FLACFile()
    }
}

// Define AbstractFactoryPattern.MusicFileFactory object with a static createMusicFile method
object MusicFileFactory {
    fun createMusicFile(factory: MusicFileAbstractFactory): MusicFile {
        return factory.createMusicFile()
    }
}

fun main() {
    // Create an AbstractFactoryPattern.MP3File using AbstractFactoryPattern.MusicFileFactory and the respective factory
    val mp3File = MusicFileFactory.createMusicFile(MP3FileFactory())
    // Call play method on the created AbstractFactoryPattern.MP3File
    mp3File.play()

    // Create a AbstractFactoryPattern.WAVFile using AbstractFactoryPattern.MusicFileFactory and the respective factory
    val wavFile = MusicFileFactory.createMusicFile(WAVFileFactory())
    // Call play method on the created AbstractFactoryPattern.WAVFile
    wavFile.play()

    // Create a AbstractFactoryPattern.FLACFile using AbstractFactoryPattern.MusicFileFactory and the respective factory
    val flacFile = MusicFileFactory.createMusicFile(FLACFileFactory())
    // Call play method on the created AbstractFactoryPattern.FLACFile
    flacFile.play()
}