class Day10 {

    sealed class Instruction(var remainingCycles: Int) {
        class Noop : Instruction(1)
        class Add(val value: Int) : Instruction(2)

        fun decrement() = --remainingCycles == 0
    }

    private fun String.toInstruction(): Instruction {
        if (this == "noop") return Instruction.Noop()
        return this.split(" ").let {
            Instruction.Add(it.last().toInt())
        }
    }

    fun solve(program: List<String>): Int {
        var cycle = 1
        var x = 1
        var targetCycle = 20
        var targetSum = 0
        val display = arrayListOf<Char>()

        val ongoing = ArrayList(program.map { it.toInstruction() })

        while (ongoing.isNotEmpty()) {

            if (cycle == targetCycle) {
                targetSum += cycle * x
                targetCycle += 40
            }

            val hPos = (cycle - 1) % 40
            if (hPos >= x - 1 && hPos <= x + 1) {
                display.add('#')
            } else {
                display.add('.')
            }

            val first = ongoing.first()
            if (first.decrement()) {
                if (first is Instruction.Add) {
                    x += first.value
                }
                ongoing.removeAt(0)
            }

            cycle++
        }

        printDisplay(display)
        return targetSum
    }

    private fun printDisplay(display: List<Char>) {
        display.forEachIndexed { index, c ->
            if (index % 40 == 0) println()
            print(c)
        }
    }

}