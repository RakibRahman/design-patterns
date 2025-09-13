package creational_patterns.AbstractFactoryPattern

// Define the abstract class creational_patterns.MusicFile with an abstract play method
abstract class MusicFile {
    abstract fun play()
}

// Define creational_patterns.MP3File class which extends creational_patterns.MusicFile
class MP3File : MusicFile() {
    override fun play() {
        println("Playing MP3 File.")
    }
}

// Define creational_patterns.WAVFile class which extends creational_patterns.MusicFile
class WAVFile : MusicFile() {
    override fun play() {
        println("Playing WAV File.")
    }
}

// Define creational_patterns.FLACFile class which extends creational_patterns.MusicFile
class FLACFile : MusicFile() {
    override fun play() {
        println("Playing FLAC File.")
    }
}

// Define the creational_patterns.MusicFileAbstractFactory interface with a createMusicFile method
interface MusicFileAbstractFactory {
    fun createMusicFile(): MusicFile
}

// Define creational_patterns.MP3FileFactory class which implements creational_patterns.MusicFileAbstractFactory
class MP3FileFactory : MusicFileAbstractFactory {
    override fun createMusicFile(): MusicFile {
        return MP3File()
    }
}

// Define creational_patterns.WAVFileFactory class which implements creational_patterns.MusicFileAbstractFactory
class WAVFileFactory : MusicFileAbstractFactory {
    override fun createMusicFile(): MusicFile {
        return WAVFile()
    }
}

// Define creational_patterns.FLACFileFactory class which implements creational_patterns.MusicFileAbstractFactory
class FLACFileFactory : MusicFileAbstractFactory {
    override fun createMusicFile(): MusicFile {
        return FLACFile()
    }
}

// Define creational_patterns.MusicFileFactory object with a static createMusicFile method
object MusicFileFactory {
    fun createMusicFile(factory: MusicFileAbstractFactory): MusicFile {
        return factory.createMusicFile()
    }
}

fun main() {
    // Create an creational_patterns.MP3File using creational_patterns.MusicFileFactory and the respective factory
    val mp3File = MusicFileFactory.createMusicFile(MP3FileFactory())
    // Call play method on the created creational_patterns.MP3File
    mp3File.play()

    // Create a creational_patterns.WAVFile using creational_patterns.MusicFileFactory and the respective factory
    val wavFile = MusicFileFactory.createMusicFile(WAVFileFactory())
    // Call play method on the created creational_patterns.WAVFile
    wavFile.play()

    // Create a creational_patterns.FLACFile using creational_patterns.MusicFileFactory and the respective factory
    val flacFile = MusicFileFactory.createMusicFile(FLACFileFactory())
    // Call play method on the created creational_patterns.FLACFile
    flacFile.play()
}