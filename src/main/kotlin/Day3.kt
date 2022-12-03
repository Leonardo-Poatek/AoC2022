class Day3 {

    fun Char.toValue(): Int = if (isLowerCase()) {
        code - 'a'.code + 1
    } else {
        code - 'A'.code + 27
    }

    fun solve(items: List<String>): Int {
        return items.sumOf { line ->
            val first = line.substring(0, line.length / 2).toSet()
            val second = line.substring(line.length / 2, line.length).toSet()
            first.first { it in second }.toValue()
        }
    }

    fun solve2(items: List<String>): Int {
        return items.windowed(3, 3) { group ->
            val sortedGGroup = group.map { it.toSet() }.sortedBy { it.size }
            sortedGGroup[0].first { it in sortedGGroup[1] && it in sortedGGroup[2] }
        }.sumOf { it.toValue() }
    }

}

fun main() {

    val items = """
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw
    """.trimIndent()

    val day = Day3()

    println(day.solve(items.lines()))

}