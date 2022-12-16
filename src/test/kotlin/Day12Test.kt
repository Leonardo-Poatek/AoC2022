import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day12Test {

    val solution = Day12()

    @Test
    fun solve1() {
        assertEquals(31, solution.solve(sampleInput.lines()))
        //println(solution.solve(realInput.trim()))
    }

    @Test
    fun solve2() {
        assertEquals(2713310158, solution.solve(sampleInput.lines()))
        //println(solution.solve(realInput.trim()))
    }

    val sampleInput = """
        Sabqponm
        abcryxxl
        accszExk
        acctuvwj
        abdefghi
    """.trimIndent().trim()
}