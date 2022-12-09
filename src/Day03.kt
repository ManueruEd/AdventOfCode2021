fun main() {

    val lower = ('a'..'z').mapIndexed { index, c -> c to (index + 1) }
    val upper = ('A'..'Z').mapIndexed { index, c -> c to (index + 27) }

    fun part1(input: List<String>): Int {

        val a = input.map {
            StringBuilder(it)
                .insert(it.length / 2, " ")
                .split(" ")
        }

        val uniqueItems = a.map { (a, b) ->
            a.toCharArray().first {
                b.toCharArray().contains(it)
            }
        }

        return uniqueItems.sumOf {
            when (it) {
                in 'a'..'z' -> lower.first { l -> l.first == it }.second
                else -> upper.first { l -> l.first == it }.second
            }
        }
    }

    fun part2(input: List<String>): Int {

        val a = input.windowed(3, step = 3)
        val uniqueItems = a.map {
            it.map {
                it.trim().toCharArray()
            }
        }.map {
            (a, b, c) -> a.first { b.contains(it) && c.contains(it) }
        }
        println(uniqueItems)
        return uniqueItems.sumOf {
            when (it) {
                in 'a'..'z' -> lower.first { l -> l.first == it }.second
                else -> upper.first { l -> l.first == it }.second
            }
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
