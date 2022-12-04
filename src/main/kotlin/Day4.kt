class Day4 {

    private fun String.toRange(): IntRange {
        return split("-").let { it.first().toInt() .. it.last().toInt() }
    }

    fun solve(items: List<String>): Int {
        return items.count {
            val ranges = it.split(",")
            val range1 = ranges.first().toRange()
            val range2 = ranges.last().toRange()
            (range1.first >= range2.first && range1.last <= range2.last) || (range2.first >= range1.first && range2.last <= range1.last)
        }
    }

    /*
    .234.....  2-4
    .....678.  6-8

    .23......  2-3
    ...45....  4-5

    ....567..  5-7
    ......789  7-9

    .2345678.  2-8
    ..34567..  3-7

    .....6...  6-6
    ...456...  4-6

    .23456...  2-6
    ...45678.  4-8
     */

    fun solve2(items: List<String>): Int {
        return items.count {
            val ranges = it.split(",")
            val range1 = ranges.first().toRange()
            val range2 = ranges.last().toRange()
            (range1.first >= range2.first && range1.last <= range2.last)
                    || (range2.first >= range1.first && range2.last <= range1.last)
                    || (range1.first < range2.first && range1.last >= range2.first)
                    || (range1.last > range2.last && range1.first <= range2.last)
        }
    }

}