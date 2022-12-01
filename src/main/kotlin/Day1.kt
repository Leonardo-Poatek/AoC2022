class Day1 {

    private fun groupElves(input: List<String>): ArrayList<Int> {
        return input.fold(arrayListOf(0)) { acc, s ->
            if(s.isEmpty()) acc.add(0)
            else acc[acc.lastIndex] += s.toInt()
            acc
        }
    }

    fun solve(input: List<String>): Int {
        val elves = groupElves(input)
        return elves.max()
    }

    fun solve2(input: List<String>): Int {
        val elves = groupElves(input)
        return elves.sortedDescending().take(3).sum()
    }

}