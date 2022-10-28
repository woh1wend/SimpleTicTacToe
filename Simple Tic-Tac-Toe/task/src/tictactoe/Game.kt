package tictactoe
import kotlin.math.abs

open class Game (_play: List<Char>) {
    private var newPlay = _play.toMutableList()
    private fun matrix(): List<List<Char>> {
        val list1 = newPlay.subList(0, 3)
        val list2 = newPlay.subList(3, 6)
        val list3 = newPlay.subList(6, 9)
        return mutableListOf(list1, list2, list3)
    }

    fun print() {
        println("---------")
        for (row in matrix().indices) {
            println("| ${matrix()[row].joinToString(" ")} |")
        }
        println("---------")

    }

    fun userInput(move: String): Boolean {
        val r = move[0]
        val c = move[2]

        while (!r.isDigit() || !c.isDigit()) {
            println("You should enter numbers!")
            return false
        }

        if (r.isDigit() && c.isDigit()) {
            val row = r.digitToInt() - 1
            val column = c.digitToInt() - 1

            if (r.digitToInt() < 1 || r.digitToInt() > 3 || c.digitToInt() < 1 || c.digitToInt() > 3) {
                println("Coordinates should be from 1 to 3!")
                return false
            } else if (matrix()[row][column] != ' ') {
                println("This cell is occupied! Choose another one!")
                return false
            }
        }
        return true
    }

    fun setX(move: String): List<Char> {
        val r = move[0]
        val c = move[2]
        val row = r.digitToInt() - 1
        val column = c.digitToInt() - 1

        when {
            matrix()[row][column] == ' ' -> when (row) {
                0 -> when (column) {
                    0 -> newPlay[0] = 'X'
                    1 -> newPlay[1] = 'X'
                    2 -> newPlay[2] = 'X'
                }

                1 -> when (column) {
                    0 -> newPlay[3] = 'X'
                    1 -> newPlay[4] = 'X'
                    2 -> newPlay[5] = 'X'
                }

                2 -> when (column) {
                    0 -> newPlay[6] = 'X'
                    1 -> newPlay[7] = 'X'
                    2 -> newPlay[8] = 'X'
                }
            }
        }

        return newPlay

    }

    fun setO(move: String): List<Char> {
        val r = move[0]
        val c = move[2]
        val row = r.digitToInt() - 1
        val column = c.digitToInt() - 1

        when {
            matrix()[row][column] == ' ' -> when (row) {
                0 -> when (column) {
                    0 -> newPlay[0] = 'O'
                    1 -> newPlay[1] = 'O'
                    2 -> newPlay[2] = 'O'
                }

                1 -> when (column) {
                    0 -> newPlay[3] = 'O'
                    1 -> newPlay[4] = 'O'
                    2 -> newPlay[5] = 'O'
                }

                2 -> when (column) {
                    0 -> newPlay[6] = 'O'
                    1 -> newPlay[7] = 'O'
                    2 -> newPlay[8] = 'O'
                }
            }
        }

        return newPlay

    }

    private fun horizontal(): MutableList<List<Char>> {
        val listH = mutableListOf<List<Char>>()
        for (row in matrix().indices) {
            if (matrix()[row].all { it == 'X' } || matrix()[row].all { it == 'O' }) {
                listH.add(matrix()[row])
            }
        }
        return listH
    }

    private fun vertical(): MutableList<List<Char>> {
        val list = mutableListOf<Char>()
        val listV = mutableListOf<List<Char>>()
        for (row in matrix().indices) {
            for (column in matrix().indices) {
                list.add(matrix()[column][row])
            }
        }
        for (i in list.chunked(3).indices) {
            if (list.chunked(3)[i].all { it == 'X' } || list.chunked(3)[i].all { it == 'O' }) {
                listV.add(list.chunked(3)[i])
            }
        }
        return listV
    }

    private fun diagonal(): MutableList<List<Char>> {
        val list1 = mutableListOf<Char>()
        val list2 = mutableListOf<Char>()
        val diagonal = listOf(list1, list2)
        val listD: MutableList<List<Char>> = mutableListOf()

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
        return listD
    }

    /*private fun countPlays(): Boolean {
        val x = newPlay.count { it == 'X' }
        val o = newPlay.count { it == 'O' }
        return (abs(x - o) < 2 || abs(o - x) < 2)
    }*/

    fun result(): Boolean {

        if (horizontal().size == 1 && vertical().size == 0 && diagonal().size == 0) {
            println("${horizontal()[0][0]} wins")
            return true
        } else if (vertical().size == 1 && horizontal().size == 0 && diagonal().size == 0) {
            println("${vertical()[0][0]} wins")
            return true
        } else if (diagonal().size == 1 && horizontal().size == 0 && vertical().size == 0) {
            println("${diagonal()[0][0]} wins")
            return true
        } else if (diagonal().size == 0 && vertical().size == 0 && horizontal().size == 0 && ' ' !in newPlay) {
            println("Draw")
            return true
        } /*else if (countPlays() && diagonal().size == 0 && vertical().size == 0 && horizontal().size == 0 && '_' in newPlay) {
            println("Game not finished")
        } else {
            println("Impossible")
        }*/
        return false

    }
}

