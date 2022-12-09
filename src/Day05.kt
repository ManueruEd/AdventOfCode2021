fun main() {
    val day = "05"

    fun part1(input: List<String>): String {

        val lengthStack = 9

        val stacks = List(lengthStack) { mutableListOf<Char?>() }

        val a = input.takeWhile { !it.startsWith("1") }.reversed()

        for (i in 0 until a[0].length) {
            for (j in a){
                j.getOrNull(i)?.takeIf { it.isLetter() }?.let {
                    stacks[i].add(it)
                }
            }
        }

        input.filter { it.startsWith("move") }
            .forEach {
            val x = Regex("move (\\d+) from (\\d) to (\\d)").matchEntire(it)!!
            val q = x.groupValues[1].toInt()
            val f = x.groupValues[2].toInt()
            val t = x.groupValues[3].toInt()

            for (m in 0 until q) {
                val b = stacks[f - 1].removeLast()
                stacks[t - 1].add(b)
            }
        }

        val result = stacks.map { it.last{
            it?.isLetter() == true
        }}.joinToString("")

        return result
    }

    fun part2(input: List<String>): String {

        val lengthStack = 9

        val stacks = List(lengthStack) { mutableListOf<Char?>() }

        val a = input.takeWhile { !it.startsWith("1") }.reversed()

        for (i in 0 until a[0].length) {
            for (j in a){
                j.getOrNull(i)?.takeIf { it.isLetter() }?.let {
                    stacks[i].add(it)
                }
            }
        }

        input.filter { it.startsWith("move") }
            .forEach {
                val x = Regex("move (\\d+) from (\\d) to (\\d)").matchEntire(it)!!
                val q = x.groupValues[1].toInt()
                val f = x.groupValues[2].toInt()
                val t = x.groupValues[3].toInt()

                val temp = mutableListOf<Char>()
                for (m in 0 until q) {
                    val b = stacks[f - 1].removeLast()!!
                    temp.add(b)
                }
                stacks[t - 1].addAll(temp.reversed())

            }

        val result = stacks.map { it.last{
            it?.isLetter() == true
        }}.joinToString("")

        return result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day${day}_test")
    check(part1(testInput) == "CMZ")

    val input = readInput("Day$day")
    println(part1(input))
    println(part2(input))
}
