fun main() {
    Day3Problem1.solve()
}

object Day3Problem1 {
    fun solve() {
        val input = getInput()
        // Assumption 1: all rows are the same width
        val width = input[0].size

        val sums =
            input.fold(IntArray(width)) { acc, list -> IntArray(width) { acc[it] + (if (list[it] == '1') 1 else 0) } }

        val binaryFlagsBigEndian = sums.map { it > input.size / 2 }

        val gammaRate =
            (0 until width).fold(0) { acc, i -> acc + ((if (binaryFlagsBigEndian[width - i - 1]) 1 else 0) shl i) }

        val mask = (0 until width).fold(0) { acc, i -> acc + (1 shl i) }
        // Assumption 2: width is never more than the width of an Int
        val epsilonRate = gammaRate.inv() and mask

        println("Result: ${gammaRate * epsilonRate}")
    }

    private fun getInput(): List<List<Char>> = readInput3().map { line -> line.map { it } }
}