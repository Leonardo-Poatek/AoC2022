import java.math.BigInteger
import java.util.ArrayDeque
import java.util.Queue

class Day11 {

    /**
     * If X can be divided by Y, then any factor of X is also dividable by Y.
     */
    data class Item(val worry: Int, val knownDividers: HashSet<Int> = hashSetOf(), val previous: Item? = null) {
        fun multiply(value: Int): Item {
            val item = if (worry * value < 0) {
                Item(knownDividers.fold(value) { acc: Int, i: Int -> acc * i }, knownDividers.toHashSet(), this)
            } else {
                Item(worry * value, knownDividers.toHashSet(), this)
            }
            return item
        }

        fun add(value: Int) = Item(worry + value, knownDividers.filter { it % (worry + value) == 0 }.toHashSet(), this)
    }

    val monkeyRegex = ("Monkey ([0-9]+):\n" +
            "  Starting items: (.*)\n" +
            "  Operation: new = (old|[0-9]+) ([*+]) (old|[0-9]+)\n" +
            "  Test: divisible by ([0-9]+)\n" +
            "    If true: throw to monkey ([0-9]+)\n" +
            "    If false: throw to monkey ([0-9]+)").toRegex()

    data class Monkey(
        val number: Int,
        val items: Queue<Long>,
        val operationRaw: MatchResult,
        val testDivisible: Int,
        val successThrow: Int,
        val failThrow: Int,
    ) {

        var inspections = 0L

        fun operation(old: Long): Long {

            val operator = operationRaw.groups[4]!!.value

            val second: Long = if (operationRaw.groups[5]!!.value == "old") {
                old
            } else {
                operationRaw.groups[5]!!.value.toLong()
            }

            return if (operator == "+") {
                old + second
            } else {
                old * second
            }
        }

        fun inspect(otherMonkeys: List<Monkey>, factor: Long) {
            inspections++

            var item = items.poll()

            item = operation(item) % factor

            if (item % testDivisible == 0L) {
                otherMonkeys[successThrow].items.add(item)
            } else {
                otherMonkeys[failThrow].items.add(item)
            }
        }

        companion object {
            fun fromMatchResult(monkeyText: MatchResult): Monkey {

                return Monkey(
                    monkeyText.groups[1]!!.value.toInt(),
                    ArrayDeque(monkeyText.groups[2]!!.value.split(", ").map { it.toLong() }),
                    monkeyText,
                    monkeyText.groups[6]!!.value.toInt(),
                    monkeyText.groups[7]!!.value.toInt(),
                    monkeyText.groups[8]!!.value.toInt(),
                )
            }
        }

    }

    private fun parseMonkeys(input: String): List<Monkey> {
        return input.split("\n\n").map {
            Monkey.fromMatchResult(monkeyRegex.find(it)!!)
        }
    }


    fun solve(input: String): Long {
        val monkeys = parseMonkeys(input)
        val factor = monkeys.fold(1L) { acc, monkey -> acc * monkey.testDivisible }
        repeat(10_000) {
            //println("Round $it")
            monkeys.forEach {
                while (it.items.isNotEmpty()) {
                    it.inspect(monkeys, factor)
                }
            }
        }
        return monkeys.sortedByDescending { it.inspections }.take(2).let {
            it.first().inspections * it.last().inspections
        }
    }

    fun solve2(input: List<String>): Int {
        return 0
    }

}