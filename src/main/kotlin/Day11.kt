import java.io.InvalidObjectException
import java.math.BigInteger
import java.util.ArrayDeque
import java.util.Queue

class Day11 {

    data class Item(val worry: BigInteger, val knownDividers: HashSet<Int>) {
        fun multiply(value: Int): Item = Item(worry * value.toBigInteger(), knownDividers)
        fun add(value: Int) = Item(worry + value.toBigInteger(), HashSet())
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
        val operation: (Long) -> Long,
        val testDivisible: Int,
        val successThrow: Int,
        val failThrow: Int,
    ) {

        var inspections = 0L

        companion object {
            fun fromMatchResult(monkeyText: MatchResult): Monkey {

                val operation = { old: Long ->
                    val first: Long = if(monkeyText.groups[3]!!.value == "old") {
                        old
                    } else {
                        monkeyText.groups[3]!!.value.toLong()
                    }

                    val second: Long = if(monkeyText.groups[5]!!.value == "old") {
                        old
                    } else {
                        monkeyText.groups[5]!!.value.toLong()
                    }

                    if(monkeyText.groups[4]!!.value == "+") {
                        first + second
                    } else {
                        first * second
                    }
                }

                return Monkey(
                    monkeyText.groups[1]!!.value.toInt(),
                    ArrayDeque(monkeyText.groups[2]!!.value.split(", ").map { it.toLong() }),
                    operation,
                    monkeyText.groups[6]!!.value.toInt(),
                    monkeyText.groups[7]!!.value.toInt(),
                    monkeyText.groups[8]!!.value.toInt(),
                )
            }
        }

        fun inspect(otherMonkeys: List<Monkey>) {
            inspections++
            val item = operation(items.poll())
            if(item < 0) throw InvalidObjectException("Overflow")
            if(item.mod(testDivisible) == 0) {
                otherMonkeys[successThrow].items.add(item)
            } else {
                otherMonkeys[failThrow].items.add(item)
            }
        }
    }

    private fun parseMonkeys(input: String): List<Monkey> {
        return input.split("\n\n").map {
            Monkey.fromMatchResult(monkeyRegex.find(it)!!)
        }
    }

    /**
     * If X can be divided by Y, then any factor of X is also dividable by Y.
     */

    fun solve(input: String): Long {
        val monkeys = parseMonkeys(input)
        repeat(10_000) {
            //println("Round $it")
            monkeys.forEach {
                while (it.items.isNotEmpty()) {
                    it.inspect(monkeys)
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