fun minimalOperations(words: List<String>): List<Int> {
    val substitutions: MutableList<Int> = mutableListOf()

    for (word in words) {
        var index = 0
        var pointer = 1
        var changes = 0
        val wordCharArr = word.toCharArray()
        while (word.length > 2 && index <= word.length - 2) {
            if (wordCharArr[index] == wordCharArr[pointer]) {
                index = pointer + 1
                pointer = index + 1
                changes++
            } else {
                index++
                pointer++
            }
        }
        substitutions.add(changes)
    }
    return substitutions
}

fun main () {
    println(minimalOperations(listOf("add", "boook", "break")))
}