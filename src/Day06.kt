fun main() {
    val day = "06"

    fun part1(input: List<String>): Int {

        val a = input[0].windowed(4).indexOfFirst { it.toCharArray().distinct().size == 4  } + 4
        //println(a)

        return a
    }

    fun part2(input: List<String>): Int {
        val a = input[0].windowed(14).indexOfFirst { it.toCharArray().distinct().size == 14  } + 14
        println(a)
        return a
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day${day}_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 26)

    val input = readInput("Day$day")
    println(part1(input))
    println(part2(input))
}