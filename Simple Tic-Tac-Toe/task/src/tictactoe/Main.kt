package tictactoe

class Tictactoe constructor (private val _play: List<Char>) {

    private fun matrix(): List<List<Char>> {
        val list1 = _play.subList(0, 3)
        val list2 = _play.subList(3, 6)
        val list3 = _play.subList(6, 9)
        return listOf(list1, list2, list3)


    }

    fun gamePrint() {
        println("---------")
        for (i in matrix().indices) {
        println("| ${matrix()[i].joinToString(" ")} |")
        }
        println("---------")
    }

    fun result() {
        when {
            horizontal() -> println("is horizontal")
            vertical() -> println("is vertical")
            diagonal() -> println("is diagonal")
            else -> println("is false")
        }

    }

    private fun horizontal(): Boolean {
        for (row in matrix().indices) {
            if (matrix()[row].all {it == 'X'} || matrix()[row].all {it == 'O'} ) {
                return true
            }
        }
        return false
    }

    private fun vertical(): Boolean {
        val list = mutableListOf<Char>()
        for (row in matrix().indices) {
            for (column in matrix().indices) {
                 list.add(matrix()[column][row])
            }
        }
        for (i in list.chunked(3).indices) {
            if (list.chunked(3)[i].all {it == 'X'} || list.chunked(3)[i].all {it == 'O'}) {
                return true
            }
        }
        return false
    }

    private fun diagonal(): Boolean {
        val list1 = mutableListOf<Char>()
        val list2 = mutableListOf<Char>()
        val diagonaList = listOf(list1, list2)

        for (row in matrix().indices) {
            for (column in matrix().indices) {
                if (row + column == matrix().size - 1) {
                    list1.add(matrix()[row][column])
                }
            }
        }

        for (row in matrix().indices) {
            for (column in matrix().indices) {
                if (row == column) {
                    list2.add(matrix()[row][column])
                }
            }
        }

        for (i in diagonaList.indices) {
            if (diagonaList[i].all { it == 'X' } || diagonaList[i].all { it == 'O' }) {
                return true
            }
        }
        return false
    }

    private fun draw(){}

    private fun impossible() {}

}

fun main() {

    val play  = Tictactoe(readln().uppercase().toList())
    play.gamePrint()
    play.result()


}

