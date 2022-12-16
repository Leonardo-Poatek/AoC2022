import java.math.BigInteger
import java.util.ArrayDeque
import java.util.Queue

class Day12 {

    data class Position(
        val char: Char,
        val x: Int,
        val y: Int,
        val top: Int = Int.MAX_VALUE,
        val down: Int = Int.MAX_VALUE,
        val left: Int = Int.MAX_VALUE,
        val right: Int = Int.MAX_VALUE
    )

    fun solve(input: List<String>): Int {
        var start: Position
        var end: Position
        val map = input.mapIndexed { y, line ->
            line.mapIndexed { x, c ->
                val pos = Position(c, x, y)
                if (c == 'S') start = pos
                else if (c == 'E') end = pos
                pos
            }
        }



        println(map)
        return 0
    }

    fun List<List<Position>>.getTop(position: Position): Position {
        return this[position.y + 1][position.x]
    }

    fun List<List<Position>>.getBottom(position: Position): Position {
        return this[position.y - 1][position.x]
    }

    fun List<List<Position>>.getLeft(position: Position): Position {
        return this[position.y][position.x - 1]
    }

    fun List<List<Position>>.getRight(position: Position): Position {
        return this[position.y][position.x + 1]
    }

    fun explore(position: Position, map:List<List<Position>>) {
        map.getTop(position).char > position.char
        if(map[position.y + 1][position.x + 1].char > position.char) {

        }
    }

    fun solve2(input: List<String>): Int {
        return 0
    }

}