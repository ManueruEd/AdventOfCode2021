fun main() {

    val shapeScores = mapOf("X" to 1, "Y" to 2, "Z" to 3)

    fun testMatch(a: String, b: String): Int {

        when {
            (a == "A" && b == "X") ||
                    (a == "B" && b == "Y") ||
                    (a == "C" && b == "Z") -> {
                println("$a $b draw")
                val shapeScore = shapeScores[b]
                return 3 + shapeScore!!
            }

            (a == "A" && b == "Z") ||
                    (a == "B" && b == "X") ||
                    (a == "C" && b == "Y")
            -> {
                println("$a $b you lost")
                val shapeScore = shapeScores[b]
                return shapeScore!!
            }

            else -> {
                println("$a $b you win")
                return 6 + shapeScores[b]!!
            }
        }

    }

    fun part1(input: List<String>): Int {

        val a = input
            .map {
                it.split(" ")
            }
            .map { (a, b) ->
                testMatch(a, b)
            }

        return a.sum()
    }

    fun getShapeToLossFor(input: String): String {
        return when (input) {
            "A" -> "Z"
            "B" -> "X"
            else -> "Y"
        }
    }

    fun getShapeToWinFor(input: String): String {
        return when (input) {
            "A" -> "Y"
            "B" -> "Z"
            else -> "X"
        }
    }

    fun getShapeToDrawFor(input: String): String {
        return when (input) {
            "A" -> "X"
            "B" -> "Y"
            else -> "Z"
        }
    }

    fun part2(input: List<String>): Int {
        val a = input
            .map {
                it.split(" ")
            }
            .map { (a, b) ->
                val changeShape = when (b) {
                    "X" -> {
                        //loss
                        getShapeToLossFor(a)
                    }

                    "Y" -> {
                        //draw
                        getShapeToDrawFor(a)
                    }

                    else -> {
                        //win
                        getShapeToWinFor(a)
                    }
                }
                testMatch(a, changeShape)
            }

        return a.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

