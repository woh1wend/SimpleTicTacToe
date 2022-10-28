package tictactoe

fun main() {

    val game = Game("         ".uppercase().toList())
    game.print()

    while (!game.result()) {

        var move = readln()

        while (!game.userInput(move)) {
            move = readln()
        }
        game.setX(move)
        game.print()
        if(game.result()) break

        move = readln()

        while (!game.userInput(move)) {
            move = readln()
        }
        game.setO(move)
        game.print()
        if(game.result()) break
    }
    game.result()











}