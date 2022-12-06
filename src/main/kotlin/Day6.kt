class Day6 {

    fun solve(items: String, size:Int = 4): Int {

        for (i in size until items.length) {
            if (items.subSequence(i - size, i).toSet().size == size) return i
        }

        return -1
    }


}