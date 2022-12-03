class Day2 {

    /**
     *  A for Rock, B for Paper, and C for Scissors. The second column--" Suddenly, the Elf is called away to help with someone's tent.

    The second column, you reason, must be what you should play in response:
    X for Rock, Y for Paper, and Z for Scissors. Winning every time would be suspicious, so the responses must have been carefully chosen.
     */


    fun solve(input: List<String>): Int {
        val rounds = input.map { getRoundSum(it) }
        return rounds.sum()
    }

    private fun getRoundSum(round:String): Int {
        val split = round.split(" ")
        val playValue = split[1].codePointAt(0) - 'X'.code + 1
        val opponentValue = split[0].codePointAt(0) - 'A'.code + 1
        val result = when {
            playValue == opponentValue -> 3
            split[1] == "X" && split[0] == "C"
                    || split[1] == "Y" && split[0] == "A"
                    || split[1] == "Z" && split[0] == "B" -> 6
            else -> 0
        }
        return result + playValue
    }

    fun solve2(input: List<String>): Int {
        val rounds = input.map { getRoundSum2(it) }
        return rounds.sum()
    }

    //Onde eu to + 1 = quem eu ganho
    //Onde eu to + 2 = quem eu perco

    //Outcome do esquema + escolha
    //Escolha = index do primeiro + 2 ou + 1 % 3 dependendo.
    //Index do primeiro = primeiro - A.code

    // Rock -> Paper -> Scisors -> Rock -> Paper

    private fun getRoundSum2(round:String): Int {
        //Get the objective points, that is X,Y,Z mapped to 0,3,6
        val goal = (round[2].code - 'X'.code) * 3
        var play =  when(round[2]) {
            'X' -> 2
            'Y' -> 3
            else -> 1
        }
        play = (((round[0].code - 'A'.code) + play) % 3) + 1
        return goal + play
    }

}