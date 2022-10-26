package tictactoe

class Result(_play: List<Char>) : Game(_play) {

   fun result() {

       print()

        if (horizontal().size == 1 && vertical().size == 0 && diagonal().size == 0) {
            println("${horizontal()[0][0]} wins")
        } else if (vertical().size == 1 && horizontal().size == 0 && diagonal().size == 0) {
            println("${vertical()[0][0]} wins")
        } else if (diagonal().size == 1 && horizontal().size == 0 && vertical().size == 0) {
            println("${diagonal()[0][0]} wins")
        } else if (diagonal().size == 0 && vertical().size == 0 && horizontal().size == 0 && '_' !in _play) {
            println("Draw")
        } else if (countPlays() && diagonal().size == 0 && vertical().size == 0 && horizontal().size == 0 && '_' in _play) {
            println("Game not finished")
        } else {
            println("Impossible")
        }

   }

}