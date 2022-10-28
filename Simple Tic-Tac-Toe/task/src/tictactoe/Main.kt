package tictactoe

fun main() {

    val game = Game(readln().uppercase().toList())
    game.result()

    var move = readln()

    while (!game.userInput(move)) {
        move = readln()
    }
    game.setX(move)
    game.result()







}