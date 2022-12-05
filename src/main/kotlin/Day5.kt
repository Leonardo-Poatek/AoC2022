import java.util.Stack

class Day5 {

    private val regexInstruction = "move ([0-9]+) from ([0-9]+) to ([0-9]+)".toRegex()

    private fun Sequence<String>.forEachInstruction(action: (qnt: Int, from: Int, to: Int) -> Unit) {
        forEach {
            val instruction = regexInstruction.find(it)
            val qnt = instruction!!.groups[1]!!.value.toInt()
            val from = instruction.groups[2]!!.value.toInt() - 1
            val to = instruction.groups[3]!!.value.toInt() - 1
            action(qnt, from, to)
        }
    }

    private fun parseStacks(lines: List<String>): List<Stack<Char>> {
        val stacks = arrayListOf<Stack<Char>>()

        lines.filter { it.isNotBlank() }.dropLast(1).reversed().apply {
            repeat((first().length + 1) / 4) { stacks.add(Stack()) }
        }.forEach { line ->

            /*
            [Z] [M] [P]
             1   5   9
             0   4   8
             (Index * 4) + 1 = letter or nothing

             35 chars
             [Q] [Q] [B] [D] [J] [W] [H] [R] [J] = 11
              1   5   9   13
             */

            (0 until stacks.size).forEach { index ->
                (line[(index * 4) + 1]).takeIf { it.isLetter() }?.let { stacks[index].add(it) }
            }

        }

        return stacks
    }

    fun solve(items: String): String {

        val split = items.split("\n\n")
        val stacks = parseStacks(split.first().lines())

        split.last().lineSequence().filter { it.isNotBlank() }.forEachInstruction { qnt, from, to ->
            repeat(qnt) {
                stacks[to].push(stacks[from].pop())
            }
        }

        return stacks.map { it.peek() }.joinToString("")
    }

    fun solve2(items: String): String {

        val split = items.split("\n\n")
        val stacks = parseStacks(split.first().lines())

        split.last().lineSequence().filter { it.isNotBlank() }.forEachInstruction { qnt, from, to ->
            val tempList = arrayListOf<Char>()
            repeat(qnt) {
                tempList.add(stacks[from].pop())
            }
            stacks[to].addAll(tempList.reversed())
        }

        return stacks.map { it.peek() }.joinToString("")
    }

}