import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

inline val Pair<Int, Int>.x: Int
    get() = first

inline val Pair<Int, Int>.y: Int
    get() = second


class Day15 {

    val regex = "Sensor at x=(-*[0-9]+), y=(-*[0-9]+): closest beacon is at x=(-*[0-9]+), y=(-*[0-9]+)".toRegex()

    fun solve(input: List<String>, countRow: Int, minCoord: Int, maxCoord: Int): Int {

        val rangePositions = hashMapOf<Int, HashSet<IntRange>>()

        val beacons = hashSetOf<Pair<Int, Int>>()
        val sensors = hashSetOf<Pair<Int, Int>>()

        input.map {
            val match = regex.find(it)?.groups!!
            val sensor = match[1]!!.value.toInt() to match[2]!!.value.toInt()
            sensors.add(sensor)

            val beacon = match[3]!!.value.toInt() to match[4]!!.value.toInt()
            beacons.add(beacon)

            /*
            Get a square where the beacon is at the corner
            the remaining left and right triangles are the height / 2 (int division)
            the remaining top and bottom are width / 2 (int division)
             */

            val boxHeight = abs(sensor.y - beacon.y) * 2 + 1
            val boxWidth = abs(sensor.x - beacon.x) * 2 + 1

            val remainingSide = boxHeight / 2
            val remainingTop = boxWidth / 2

            val topY = (sensor.y - boxHeight / 2 - remainingTop)
            val bottomY = (sensor.y + boxHeight / 2 + remainingTop)
            var minX = sensor.x
            var maxX = sensor.x

            //Go from top to middle
            for (y in topY until sensor.y) {
                if (y in minCoord..maxCoord) {
                    val range = minX.coerceAtLeast(minCoord)..maxX.coerceAtMost(maxCoord)
                    rangePositions.getOrPut(y) { hashSetOf() }.add(range)
                }
                minX--; maxX++
            }

            //From middle to bottom
            for (y in sensor.y until bottomY) {
                if (y in minCoord..maxCoord) {
                    val range = minX.coerceAtLeast(minCoord)..maxX.coerceAtMost(maxCoord)
                    rangePositions.getOrPut(y) { hashSetOf() }.add(range)
                }
                minX++; maxX--
            }
        }

//        val line = hashSetOf<Int>()
//        rangePositions[countRow]?.let {
//            it.forEach { range -> range.forEach { line.add(it) } }
//        }

        rangePositions.forEach { line ->
            val beaconsOnLine = beacons.filter { it.y == line.key }.map { it.x..it.x }.toSet()
            var ranges = listOf((minCoord..maxCoord))
            beaconsOnLine.forEach { beaconPos ->
                ranges = ranges.subtract(beaconPos)
            }
            line.value.forEach {
                ranges = ranges.subtract(it)
            }
            //IDK wtf happens here. Change to a range intersection instead.
            if(ranges.size == 1) {
                val posX = ranges.first().first
                println("Position: ${posX}, ${line.key}")
                println(posX*4000000L + line.key)
            }
            ranges.forEach {
                println("Position: ${it.first}, ${line.key}")
            }

        }

        return 0//line.size - beaconsOnLine
    }

}

fun List<IntRange>.subtract(remove: IntRange): List<IntRange> {
    val result = arrayListOf<IntRange>()
    forEach { range ->
        when {
            remove.first < range.first && remove.last > range.first && remove.last < range.last -> {
                //Starts outside and ends inside
                result.add((remove.last + 1..range.last).isValid())
            }

            remove.first > range.first && remove.last < range.last -> {
                //Starts and ends inside
                result.add((range.first..remove.first - 1).isValid())
                result.add((remove.last + 1..range.last).isValid())
            }

            remove.last > range.last && remove.first > range.first && remove.first <= range.last -> {
                //Starts inside and ends outside
                result.add((range.first..remove.first - 1).isValid())
            }

            remove.last < range.first || remove.first > range.last -> {
                //Its completely before or after the range.
                result.add(range)
            }
            //Else starts and ends outside
            //Don't re-add it.
        }
    }
    return result
}

fun IntRange.isValid(): IntRange = apply {
    if(first > last) println("Pair $this is invalid")
}
