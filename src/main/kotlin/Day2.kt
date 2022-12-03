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
        val playValue = round[2] - 'X' + 1
        val opponentValue = round[0] - 'A' + 1
        val result = when {
            playValue == opponentValue -> 3
            round[2] == 'X' && round[0] == 'C'
                    || round[2] == 'Y' && round[0] == 'A'
                    || round[2] == 'Z' && round[0] == 'B' -> 6
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
        val goal = (round[2] - 'X') * 3
        var play =  when(round[2]) {
            'X' -> 2
            'Y' -> 3
            else -> 1
        }
        play = (((round[0] - 'A') + play) % 3) + 1
        return goal + play
    }

}