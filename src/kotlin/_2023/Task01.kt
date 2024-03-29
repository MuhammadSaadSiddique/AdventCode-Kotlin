package _2022

import Task
import readInput

object Task01: Task {

    override fun partA() = part1(parseInput())

    override fun partB() = part2(parseInput())

    private fun parseInput() = readInput("_2022/01")
        .split("\n\n")
        .map { it.split("\n").sumOf { it.toInt() } }



    fun part1(input: List<String>): Int {
        return input.sumOf {
            (it.find { it.isDigit() }.toString() + it.findLast { it.isDigit() }).toInt()
        }
    }
    
    fun part2(input: List<String>): Int {
        val map = mapOf(
            "one" to 1, "two" to 2, "three" to 3, "four" to 4,
            "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9,
            "1" to 1, "2" to 2, "3" to 3, "4" to 4, "5" to 5, "6" to 6,
            "7" to 7, "8" to 8, "9" to 9
        )
        return input.sumOf {
            val first = map[it.findAnyOf(map.keys)!!.second].toString()
            val second = map[it.findLastAnyOf(map.keys)!!.second].toString()
            (first + second).toInt()
        }
    }
}
