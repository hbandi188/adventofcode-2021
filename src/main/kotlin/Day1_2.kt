fun main() {
    val input = readInput1()

    val count = input.windowed(3).map { it.sum() }.windowed(2).count { it[0] < it[1] }
    println("Num of increases: $count")
}

