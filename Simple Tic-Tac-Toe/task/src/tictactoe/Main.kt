package tictactoe

fun main() {

    val play = readln().uppercase().toList()
   result(game(play))

}

fun game(play: List<Char>): List<List<Char>> {

    val list1 = play.subList(0, 3)
    val list2 = play.subList(3, 6)
    val list3 = play.subList(6, 9)

    println("---------")
    println("| ${list1.joinToString(" ")} |")
    println("| ${list2.joinToString(" ")} |")
    println("| ${list3.joinToString(" ")} |")
    println("---------")

    return listOf(list1, list2, list3)
}

fun result(game: List<List<Char>>) {
    var check = ""
    var a = 2
    var b = 2

    for (i in game.indices) {

        //game not finished
        if (game[i].contains('_') && game[i].all { it != 'X' } || game[i].all { it != 'O' }) {
            check = "_ nf"
        }

        //horizontal
        if (game[i].all { it == 'X' }) {
            check = "x h"

        } else if (game[i].all { it == 'O' }) {
            check = "o h"

        }

        //vertical
        for (j in game[i].indices) {
            if (game[j][i] == 'X') {
                check = "x v"

            } else if (game[j][i] == 'O') {
                check = "o v"
            }
        }


        //diagonal 0 to 2
        for (j in game.indices) {
            if (i + j == game.size - 1) {
                if (game.indices.all {game[i][j] == 'X'}) {
                    check = "x d"
                } else if (game.all {game[i][j] == 'O'}) {
                    check = "o d"
                }
            }
        }

        /* //diagonal 2 to 0
         for (j in game[i].last() downTo game[i].first()) {
             println(game[i])

         }*/



    }
    println(check)
}






    /*return when (check){
        "x" -> "X wins"
        "o" -> "O wins"
        "_" -> "Game not finished"
        "i" -> "Impossible"
        else -> "Draw"

    }*/
