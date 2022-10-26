package tictactoe
import kotlin.math.abs

open class Game (var _play: List<Char>) {

    private fun matrix(): List<List<Char>> {
        val list1 = _play.subList(0, 3)
        val list2 = _play.subList(3, 6)
        val list3 = _play.subList(6, 9)
        return listOf(list1, list2, list3)
    }

    fun print() {
        println("---------")
        for (row in matrix().indices) {
            println("| ${matrix()[row].joinToString(" ")} |")
        }
        println("---------")
    }

    fun horizontal(): MutableList<List<Char>> {
        val listH = mutableListOf<List<Char>>()
        for (row in matrix().indices) {
            if (matrix()[row].all { it == 'X' } || matrix()[row].all { it == 'O' }) {
                listH.add(matrix()[row])
            }
        }
        return listH
    }

    fun vertical(): MutableList<List<Char>> {
        val list = mutableListOf<Char>()
        val listV = mutableListOf<List<Char>>()
        for (row in matrix().indices) {
            for(column in matrix().indices) {
                    list.add(matrix()[column][row])
                }
            }
            for (i in list.chunked(3).indices) {
                if (list.chunked(3)[i].all {it == 'X'} || list.chunked(3)[i].all {it == 'O'}) {
                    listV.add(list.chunked(3)[i])
            }
        }
        return listV
    }

    fun diagonal(): MutableList<List<Char>> {
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
        return listD
    }

    fun countPlays(): Boolean {
        val x = _play.count {it == 'X'}
        val o = _play.count {it == 'O'}
        return  (abs(x - o) < 2 || abs(o - x) < 2)
    }
    }
