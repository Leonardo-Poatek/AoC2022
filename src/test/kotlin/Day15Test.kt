import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day15Test {

    val solution = Day15()

    @Test
    fun solve1() {
       // assertEquals(26, solution.solve(sampleInput.lines(), 10, 0, 20))
        assertEquals(873, solution.solve(realInput.lines(), 2_000_000, 0, 4_000_000))
    }

    @Test
    fun testIntersections() {
        /*
        assertEquals(listOf((4..5)), listOf(0..3, 4..5).subtract(0..3))
        assertEquals(listOf((0..3)), listOf(0..3, 4..5).subtract(4..5))

        assertEquals(listOf((0..3)), listOf(0..3, 4..5).subtract(4..10))
        assertEquals(listOf((4..5)), listOf(0..3, 4..5).subtract(-2..3))
        assertEquals(emptyList<IntRange>(), listOf(0..3, 4..5).subtract(-2..15))
        assertEquals(emptyList<IntRange>(), listOf(0..3, 4..5).subtract(0..5))

        assertEquals(listOf(0..2, 5..10), listOf(0..2, 5..10).subtract(3..4))

         */
        assertEquals(listOf(0..1, 7..10), listOf(0..2, 5..10).subtract(2..6))

    }

    /*
    @Test
    fun solve2() {
        assertEquals(93, solution.solve(sampleInput.lines(), true))
        assertEquals(24, solution.solve(realInput.lines(), true))
    }
     */

    val sampleInput = """ 
        Sensor at x=2, y=18: closest beacon is at x=-2, y=15
        Sensor at x=9, y=16: closest beacon is at x=10, y=16
        Sensor at x=13, y=2: closest beacon is at x=15, y=3
        Sensor at x=12, y=14: closest beacon is at x=10, y=16
        Sensor at x=10, y=20: closest beacon is at x=10, y=16
        Sensor at x=14, y=17: closest beacon is at x=10, y=16
        Sensor at x=8, y=7: closest beacon is at x=2, y=10
        Sensor at x=2, y=0: closest beacon is at x=2, y=10
        Sensor at x=0, y=11: closest beacon is at x=2, y=10
        Sensor at x=20, y=14: closest beacon is at x=25, y=17
        Sensor at x=17, y=20: closest beacon is at x=21, y=22
        Sensor at x=16, y=7: closest beacon is at x=15, y=3
        Sensor at x=14, y=3: closest beacon is at x=15, y=3
        Sensor at x=20, y=1: closest beacon is at x=15, y=3
    """.trimIndent().trim()

    val realInput = """
        Sensor at x=3844106, y=3888618: closest beacon is at x=3225436, y=4052707
        Sensor at x=1380352, y=1857923: closest beacon is at x=10411, y=2000000
        Sensor at x=272, y=1998931: closest beacon is at x=10411, y=2000000
        Sensor at x=2119959, y=184595: closest beacon is at x=2039500, y=-250317
        Sensor at x=1675775, y=2817868: closest beacon is at x=2307516, y=3313037
        Sensor at x=2628344, y=2174105: closest beacon is at x=3166783, y=2549046
        Sensor at x=2919046, y=3736158: closest beacon is at x=3145593, y=4120490
        Sensor at x=16, y=2009884: closest beacon is at x=10411, y=2000000
        Sensor at x=2504789, y=3988246: closest beacon is at x=3145593, y=4120490
        Sensor at x=2861842, y=2428768: closest beacon is at x=3166783, y=2549046
        Sensor at x=3361207, y=130612: closest beacon is at x=2039500, y=-250317
        Sensor at x=831856, y=591484: closest beacon is at x=-175938, y=1260620
        Sensor at x=3125600, y=1745424: closest beacon is at x=3166783, y=2549046
        Sensor at x=21581, y=3243480: closest beacon is at x=10411, y=2000000
        Sensor at x=2757890, y=3187285: closest beacon is at x=2307516, y=3313037
        Sensor at x=3849488, y=2414083: closest beacon is at x=3166783, y=2549046
        Sensor at x=3862221, y=757146: closest beacon is at x=4552923, y=1057347
        Sensor at x=3558604, y=2961030: closest beacon is at x=3166783, y=2549046
        Sensor at x=3995832, y=1706663: closest beacon is at x=4552923, y=1057347
        Sensor at x=1082213, y=3708082: closest beacon is at x=2307516, y=3313037
        Sensor at x=135817, y=1427041: closest beacon is at x=-175938, y=1260620
        Sensor at x=2467372, y=697908: closest beacon is at x=2039500, y=-250317
        Sensor at x=3448383, y=3674287: closest beacon is at x=3225436, y=4052707
    """.trimIndent().trim()

}