import java.io.BufferedReader

fun String.readResource(): BufferedReader =
    object {}.javaClass.classLoader.getResourceAsStream(this)!!.bufferedReader()