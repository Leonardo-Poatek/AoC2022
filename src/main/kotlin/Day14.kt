import kotlin.math.max

class Day14 {

    private fun drawLine(map: HashSet<Pair<Int, Int>>, line: List<Pair<Int, Int>>) {
        val start = line.first()
        val end = line.last()
        if (start.first == end.first) {
            //Vertical line
            val startY: Int
            val endY: Int

            if (start.second < end.second) {
                startY = start.second
                endY = end.second
            } else {
                startY = end.second
                endY = start.second
            }

            for (y in startY..endY) {
                map.add(start.first to y)
            }

        } else {
            //Horizontal line
            val startX: Int
            val endX: Int

            if (start.first < end.first) {
                startX = start.first
                endX = end.first
            } else {
                startX = end.first
                endX = start.first
            }

            for (x in startX..endX) {
                map.add(x to start.second)
            }
        }
    }

    fun solve(input: List<String>, hasFloor: Boolean = false): Int {

        var lowestRock = 0

        val lines = input.map {
            it.split(" -> ").map {
                it.split(",").let {
                    val x = it.first().toInt()
                    val y = it.last().toInt()
                    lowestRock = max(lowestRock, y)
                    (x to y)
                }
            }
        }

        val map = HashSet<Pair<Int, Int>>()

        lines.forEach { line ->
            line.windowed(2, 1) { drawLine(map, it) }
        }

        var finished = false
        var rocks = 0
        val floor = map.maxOf { it.second } + 2

        if (!hasFloor) {
            while (!finished) {
                val pos = fall(500, 0, map)
                if (pos == -1 to -1) finished = true
                else {
                    map.add(pos)
                    rocks++
                }
            }
        } else {
            while (!finished) {
                rocks++
                val pos = fallWithFloor(500, 0, map, floor)
                if (pos == 500 to 0) finished = true
                else map.add(pos)
            }
        }

        return rocks
    }

    private fun fall(x: Int, y: Int, map: HashSet<Pair<Int, Int>>): Pair<Int, Int> {

        var settled = false
        var newX = x
        var newY = y
        val floor = map.maxOf { it.second }

        while (!settled) {
            if (newY > floor) {
                return -1 to -1
            } else if (newX to newY + 1 !in map) {
                newY++
            } else if (newX - 1 to newY + 1 !in map) {
                newY++
                newX--
            } else if (newX + 1 to newY + 1 !in map) {
                newY++
                newX++
            } else {
                settled = true
            }
        }

        return newX to newY
    }

    private fun fallWithFloor(x: Int, y: Int, map: HashSet<Pair<Int, Int>>, floor: Int): Pair<Int, Int> {

        var settled = false
        var newX = x
        var newY = y

        while (!settled) {
            if (newY + 1 == floor) {
                settled = true
            } else if (newX to newY + 1 !in map) {
                newY++
            } else if (newX - 1 to newY + 1 !in map) {
                newY++
                newX--
            } else if (newX + 1 to newY + 1 !in map) {
                newY++
                newX++
            } else {
                settled = true
            }
        }

        return newX to newY
    }
}