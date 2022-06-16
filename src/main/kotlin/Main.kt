package gabof

import kotlin.io.path.*
import kotlin.system.exitProcess

import com.squareup.kotlinpoet.FileSpec
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.int
import com.squareup.kotlinpoet.FunSpec
import java.io.File

class App : CliktCommand() {
    private val defaultNumberOfFiles = 10
    private val numberOfFiles: Int by option(help = "Number of files").int().default(defaultNumberOfFiles)
    private val outDir: String by argument()
    private val nameForDirOfGeneratedFiles = "gabof"
    private val packageNameForGeneratedFiles = "gabof"
    private val numberOfFnsPerFile = 100
    private val numberOfPrintlnsPerFn = 100
    // TODO: add flag "language" - for Kotlin, kotlin-poet, for Java, java-poet

    override fun run() {
        val outPath = Path(outDir)
        if (!outPath.exists()) {
            println("The provided input path `$outDir` does not point to an existing file. Exiting.")
            exitProcess(1)
        }
        if (!outPath.isDirectory()) {
            println("The provided input path `$outDir` is not a directory. Exiting.")
            exitProcess(1)
        }
        if (!outPath.isWritable()) {
            println("The directory at `$outDir` is is not writeable. Exiting.")
            exitProcess(1)
        }
        val gabofSubdirPath = Path(outPath.pathString, nameForDirOfGeneratedFiles)
        val gabofSubdir = outPath.listDirectoryEntries().find { it.isDirectory() && it == gabofSubdirPath }
        // TODO: ask user first before deletion OR provide flag to control this behavior
        gabofSubdir?.let {
            println("Found subdirectory named `$nameForDirOfGeneratedFiles` at `$outPath`, removing it...")
            File(it.pathString).deleteRecursively()
        }
        gabofSubdirPath.createDirectory()
        println("Created subdirectory at `$gabofSubdirPath`.")

        val progressModulo = 10
        for (fileNo in 1..numberOfFiles) {
            val fileName = "file$fileNo"
            val kotlinFile = FileSpec.builder(packageNameForGeneratedFiles, fileName)
            (1..numberOfFnsPerFile).forEach {
                val fnName = "fn${fileNo}_$it"
                val fnSpec = FunSpec.builder(fnName).returns(Int::class)
                (1..numberOfPrintlnsPerFn).forEach { fnSpec.addStatement("println(41414141)") }
                fnSpec.addStatement("return $fileNo")
                kotlinFile.addFunction(fnSpec.build())
            }
            kotlinFile.build().writeTo(outPath)

            if(fileNo % progressModulo == 0) {
                println("Wrote $fileNo/$numberOfFiles to `$outPath`.")
            }
        }
    }
}

fun main(args: Array<String>) = App().main(args)