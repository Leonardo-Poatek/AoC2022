class Day8 {

    data class Tree(
        val x: Int,
        val y: Int,
        var furthestUp: Int,
        var furthestDown: Int,
        var furthestLeft: Int,
        var furthestRight: Int
    )

    fun solve(forest: List<String>): Int {

        /*
        Varre em todas as direcoes, guarda a arvore mais alta encontrada, se for maior incrementa

         */
        val visible = hashSetOf<Pair<Int, Int>>()

        var highest = -1

        //Left to right
        for (y in forest.indices) {
            highest = -1
            val line = forest[y]
            for (x in line.indices) {
                val tree = forest[y][x].digitToInt()
                if (tree > highest) {
                    highest = tree
                    visible.add(x to y)
                }
            }
        }

        //Right to left
        for (y in forest.indices) {
            highest = -1
            for (x in forest[y].indices.reversed()) {
                val tree = forest[y][x].digitToInt()
                if (tree > highest) {
                    highest = tree
                    visible.add(x to y)
                }
            }
        }

        //Top to bottom
        for (x in forest.first().indices) {
            highest = -1
            for (y in forest.indices) {
                val tree = forest[y][x].digitToInt()
                if (tree > highest) {
                    highest = tree
                    visible.add(x to y)
                }
            }
        }

        //Bottom to top
        for (x in forest.first().indices) {
            highest = -1
            for (y in forest.indices.reversed()) {
                val tree = forest[y][x].digitToInt()
                if (tree > highest) {
                    highest = tree
                    visible.add(x to y)
                }
            }
        }

        return visible.size
    }

    private fun calculateArea(centerX: Int, centerY: Int, forest: List<String>): Int {
        var top = 0
        var bottom = 0
        var left = 0
        var right = 0

        val centerValue = forest[centerY][centerX].digitToInt()

        for (x in centerX + 1 until forest.size) {
            right++
            if(forest[centerY][x].digitToInt() >= centerValue) {
                break
            }
        }

        for (x in centerX - 1 downTo 0) {
            left++
            if(forest[centerY][x].digitToInt() >= centerValue) {
                break
            }
        }

        for (y in centerY + 1 until forest[0].length) {
            bottom++
            if(forest[y][centerX].digitToInt() >= centerValue) {
                break
            }
        }

        for (y in centerY - 1 downTo 0) {
            top++
            if(forest[y][centerX].digitToInt() >= centerValue) {
                break
            }
        }

        return top * bottom * left * right
    }

    fun solve2(forest: List<String>): Int {

        /*
        Varre em todas as direcoes, guarda a arvore mais alta encontrada, se for maior incrementa

        - Ignorar as das pontas, pq a distancia vai ser 0 mesmo
        -
         */

        var largestArea = 0

        calculateArea(2, 1, forest)

        for (y in 1 until forest.size - 1) {
            val line = forest[y]
            for (x in 1 until forest.size - 1) {
                val tree = forest[y][x].digitToInt()
                val area = calculateArea(x, y, forest)
                if(area > largestArea) {
                    largestArea = area
                }
            }
        }

        return largestArea
    }


}