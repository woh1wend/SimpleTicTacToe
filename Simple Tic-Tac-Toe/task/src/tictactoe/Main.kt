package tictactoe
import kotlin.math.abs

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

        result()
    }

    private fun result () {
        when {
            !countPlays() -> impossible()
            ((horizontal() || diagonal() || vertical())
                    && countPlays() && (_play.contains('_') || '_' !in _play)) -> check()
            notFinished() -> println("Game not finished")

            (!notFinished() && '_' !in _play) -> println("Draw")
        }
    }
    private fun check() {
        when (true) {
            horizontal() -> checkH()
            vertical() -> checkV()
            diagonal() -> checkD()
        }
    }

    private fun checkH() {
        val listH = mutableListOf<List<Char>>()
        for (row in matrix().indices) {
            if (matrix()[row].all { it == 'X' } || matrix()[row].all { it == 'O' }) {
                listH.add(matrix()[row])
            }
        }
        if (listH.size < 2) {
            println("${listH[0][0]} wins")
        }
    }

    private fun checkV() {
        val list = mutableListOf<Char>()
        val listV = mutableListOf<List<Char>>()
        for (row in matrix().indices) {
            for (column in matrix().indices) {
                list.add(matrix()[column][row])
            }
        }
        for (i in list.chunked(3).indices) {
            if (list.chunked(3)[i].all {it == 'X'} || list.chunked(3)[i].all {it == 'O'}) {
                listV.add(list.chunked(3)[i])
            }
        }
        if (listV.size < 2) {
            println("${listV[0][0]} wins")
        }
    }

    private fun checkD() {
        val list1 = mutableListOf<Char>()
        val list2 = mutableListOf<Char>()
        val diagonal = listOf(list1, list2)
        val listD: MutableList <List<Char>> = mutableListOf()

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

        for (i in diagonal.indices) {
            if (diagonal[i].all { it == 'X' } || diagonal[i].all { it == 'O' }) {
                listD.add(diagonal[i])
            }
        }

        if (listD.size < 2) {
            println("${listD[0][0]} wins")
        }

    }

    private fun horizontal(): Boolean {
        val listH = mutableListOf<List<Char>>()
        for (row in matrix().indices) {
            if (matrix()[row].all {it == 'X'} || matrix()[row].all {it == 'O'}) {
                listH.add(matrix()[row])
            }
        }
        return (listH.size < 2)
    }

    private fun vertical(): Boolean {
        val list = mutableListOf<Char>()
        val listV = mutableListOf<List<Char>>()
        for (row in matrix().indices) {
            for (column in matrix().indices) {
                 list.add(matrix()[column][row])
            }
        }
        for (i in list.chunked(3).indices) {
            if (list.chunked(3)[i].all {it == 'X'} || list.chunked(3)[i].all {it == 'O'}) {
                listV.add(list.chunked(3)[i])
            }
        }
        return (listV.size < 2)

    }

    private fun diagonal(): Boolean {
        val list1 = mutableListOf<Char>()
        val list2 = mutableListOf<Char>()
        val diagonal = listOf(list1, list2)
        val listD: MutableList <List<Char>> = mutableListOf()

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

        for (i in diagonal.indices) {
            if (diagonal[i].all { it == 'X' } || diagonal[i].all { it == 'O' }) {
                listD.add(diagonal[i])
            }
        }

        return (listD.size < 2)

    }

    private fun notFinished(): Boolean {
        return  (_play.contains('_') && !horizontal() && !vertical() && !diagonal())
    }

    private fun countPlays(): Boolean {
        val x = _play.count {it == 'X'}
        val o = _play.count {it == 'O'}
        return  (abs(x - o) < 2 || abs(o - x) < 2)
    }

    private fun impossible() {
        println("Impossible")
    }

}

fun main() {

    val play  = Tictactoe(readln().uppercase().toList())
    play.gamePrint()


}

