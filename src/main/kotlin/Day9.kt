class Day9 {

    data class Knot(
        var x: Int = 0,
        var y: Int = 0
    ) {

        fun move(dir: Char) {
            when (dir) {
                'L' -> x--
                'R' -> x++
                'U' -> y++
                else -> y--
            }
        }
    }

    fun solve(input: List<String>, length: Int = 2): Int {
        val visited = hashSetOf(Pair(0, 0))

        val rope = List(length) { Knot() }

        input.forEach { move ->
            repeat(move.split(" ").last().toInt()) {

                rope.first().move(move[0])

                for (i in 1 until rope.size) {

                    if ((rope[i - 1].x > rope[i].x + 1))

                        if ((rope[i - 1].x > rope[i].x + 1)) { //Right
                            rope[i].x++
                            //Se tem um link em 0,0 e outro em 2,2, o de 0,0 precisa ir para 1,1, e nao o lado do outro
                            //Porem se tem um link em 1,2 e outro em 0,0, o de 0,0 precisa ir pra 1,1
                            if ((rope[i - 1].y > rope[i].y)) {
                                rope[i].y++
                            } else if (rope[i - 1].y < rope[i].y) {
                                rope[i].y--
                            }
                        }

                    if ((rope[i - 1].x < rope[i].x - 1)) { //Left
                        rope[i].x--
                        if ((rope[i - 1].y > rope[i].y)) {
                            rope[i].y++
                        } else if (rope[i - 1].y < rope[i].y) {
                            rope[i].y--
                        }
                    }

                    if (rope[i - 1].y > rope[i].y + 1) { //Up
                        rope[i].y++
                        if ((rope[i - 1].x > rope[i].x)) {
                            rope[i].x++
                        } else if (rope[i - 1].x < rope[i].x) {
                            rope[i].x--
                        }
                    }

                    if (rope[i - 1].y < rope[i].y - 1) { //Down
                        rope[i].y--
                        if ((rope[i - 1].x > rope[i].x)) {
                            rope[i].x++
                        } else if (rope[i - 1].x < rope[i].x) {
                            rope[i].x--
                        }
                    }

                }

                visited.add(Pair(rope.last().x, rope.last().y))

            }
        }

        return visited.size
    }

    fun print(rope: List<Knot>) {

        val maxX = rope.maxOf { it.x }
        val minX = rope.minOf { it.x }

        val maxY = rope.maxOf { it.y }
        val minY = rope.minOf { it.y }

        for (y in maxY - minY downTo 0) {
            for (x in 0..maxX - minX) {
                val atPos = rope.indexOfFirst { it.x == x && it.y == y }
                if (atPos != -1) {
                    print(atPos)
                } else {
                    print(".")
                }
            }
            println()
        }

        println()
    }

}
