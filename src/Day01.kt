fun main() {
    fun part1(input: List<String>): Int {

        val a = input.map { it.toIntOrNull() }
            .fold(mutableListOf()) { acc: MutableList<ArrayList<Int>>, s: Int? ->
                if (s == null) {
                    acc.add(arrayListOf())
                    acc
                } else {
                    if (acc.lastOrNull() == null) {
                        acc.add(arrayListOf())
                    }
                    acc.last().add(s)
                    acc
                }
            }

        return a.maxOf {
            it.sum()
        }
    }

    fun part2(input: List<String>): Int {
        val a = input.map { it.toIntOrNull() }
            .fold(mutableListOf()) { acc: MutableList<ArrayList<Int>>, s: Int? ->
                if (s == null) {
                    acc.add(arrayListOf())
                    acc
                } else {
                    if (acc.lastOrNull() == null) {
                        acc.add(arrayListOf())
                    }
                    acc.last().add(s)
                    acc
                }
            }

        return a.map {
            it.sum()
        }.sortedDescending()
            .take(3)
            .sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
