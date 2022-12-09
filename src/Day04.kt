fun main() {
    val day = "04"

    fun part1(input: List<String>): Int {

        val ans = input.mapNotNull {
            val s = it.split(",")
                .map {
                    it.split("-")
                        .map { it.toInt() }
                }

            val p1: List<Int> = s[0]
            val p2: List<Int> = s[1]
            if ((p1[0] >= p2[0] && p1[1] <= p2[1]) || (p2[0] >= p1[0] && p2[1] <= p1[1])) {
                s
            } else
                null
        }

        //println(ans)

        return ans.size
    }

    fun part2(input: List<String>): Int {
        
        val ans = input.mapNotNull {
            val s = it.split(",")
                .map {
                    it.split("-")
                        .map { it.toInt() }
                }

            val p1: List<Int> = s[0]
            val p2: List<Int> = s[1]
            if (p1[1] < p2[0] || p2[1] < p1[0] ) {
                null
            } else
                s
        }
        ans.onEach { println(it) }
        return ans.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day${day}_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day$day")
    println(part1(input))
    println(part2(input))

}