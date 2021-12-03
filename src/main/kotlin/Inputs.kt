fun readInput1(): List<Int> = "input1_1.txt".readResource().use { reader ->
    reader.readLines().map { it.toInt() }
}

fun readInput2(): List<Pair<String, Int>> = "input2_1.txt".readResource().use { reader ->
    reader.readLines()
        .map { it.split(" ") }
        .filter { it.size == 2 }
        .map { it[0] to it[1].toInt() }
}