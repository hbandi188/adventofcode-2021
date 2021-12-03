fun main() {
    Day2Problem2.solve()
}

object Day2Problem2 {
    fun solve() {
        val instructions = getInput()

        val start = State(distance = 0, depth = 0, aim = 0)
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
        override fun applyToState(state: State) =
            state.copy(distance = state.distance + magnitude, depth = state.depth + (state.aim * magnitude).toLong())
    }

    private class Up(magnitude: Int) : Instruction(magnitude) {
        override fun applyToState(state: State) = state.copy(aim = state.aim - magnitude)
    }

    private class Down(magnitude: Int) : Instruction(magnitude) {
        override fun applyToState(state: State) = state.copy(aim = state.aim + magnitude)
    }

    private data class State(val distance: Long, val depth: Long, val aim: Int)
}