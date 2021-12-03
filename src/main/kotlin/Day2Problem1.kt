fun main() {
    Day2Problem1.solve()
}

object Day2Problem1 {
    fun solve() {
        val instructions = getInput()

        val start = State(distance = 0, depth = 0)
        val end = instructions.fold(start) { state, instruction -> instruction.applyToState(state) }
        println("Result: ${end.distance * end.depth}")
    }

    private fun getInput(): List<Instruction> = readInput2().mapNotNull { (code, magnitude) ->
        when (code) {
            "forward" -> Forward(magnitude)
            "up" -> Up(magnitude)
            "down" -> Down(magnitude)
            else -> null
        }
    }

    private sealed class Instruction(protected val magnitude: Int) {
        abstract fun applyToState(state: State): State
    }

    private class Forward(magnitude: Int) : Instruction(magnitude) {
        override fun applyToState(state: State) = state.copy(distance = state.distance + magnitude)
    }

    private class Up(magnitude: Int) : Instruction(magnitude) {
        override fun applyToState(state: State) = state.copy(depth = state.depth - magnitude)
    }

    private class Down(magnitude: Int) : Instruction(magnitude) {
        override fun applyToState(state: State) = state.copy(depth = state.depth + magnitude)
    }

    private data class State(val distance: Long, val depth: Long)
}