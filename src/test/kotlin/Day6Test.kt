import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day6Test {

    val day = Day6()

    val items = """
        
    """.trimIndent()

    @Test
    fun solve1() {
        assertEquals(2, day.solve(items.lines()))
        println(day.solve(realInput.lines()))
    }

    @Test
    fun solve2() {
        assertEquals(4, day.solve2(items.lines()))
        println(day.solve2(realInput.lines()))
    }

    val realInput = """
        
    """.trimIndent()

}