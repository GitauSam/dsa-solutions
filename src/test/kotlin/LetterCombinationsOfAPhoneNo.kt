fun letterCombinationsTwo(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()

    val digitsLetterMap = mutableMapOf<Char, String>()
    digitsLetterMap['2'] = "abc"
    digitsLetterMap['3'] = "def"
    digitsLetterMap['4'] = "ghi"
    digitsLetterMap['5'] = "jkl"
    digitsLetterMap['6'] = "mno"
    digitsLetterMap['7'] = "pqrs"
    digitsLetterMap['8'] = "tuv"
    digitsLetterMap['9'] = "wxyz"

    var index = 0
    var secondaryIndex = 0
    val comboList = mutableListOf<String>()

    while (index < digitsLetterMap[digits[0]]!!.length) {
        comboList.add("${digitsLetterMap[digits[0]]!![index]}${digitsLetterMap[digits[1]]!![secondaryIndex]}")

        if (secondaryIndex == digitsLetterMap[digits[1]]!!.length - 1) {
            index++
            secondaryIndex = 0
        } else {
            secondaryIndex++
        }
    }

    return comboList
}

fun letterCombinationsThree(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()

    val digitsLetterMap = mutableMapOf<Char, String>()
    digitsLetterMap['2'] = "abc"
    digitsLetterMap['3'] = "def"
    digitsLetterMap['4'] = "ghi"
    digitsLetterMap['5'] = "jkl"
    digitsLetterMap['6'] = "mno"
    digitsLetterMap['7'] = "pqrs"
    digitsLetterMap['8'] = "tuv"
    digitsLetterMap['9'] = "wxyz"

    var index = 0
    var primaryIndex = 0
    val comboList = mutableListOf<String>()

    while (index < digits.length - 1) {
        for (i in index + 1..digits.length) {
            comboList.add("${digitsLetterMap[digits[index]]!![primaryIndex]}${digitsLetterMap[digits[i]]}")
            if (index == digits.length) {
                primaryIndex++
            }
        }
        index++
    }

    return comboList
}

fun letterCombinationsFour(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()

    val digitsLetterMap = mutableMapOf<Char, String>()
    digitsLetterMap['2'] = "abc"
    digitsLetterMap['3'] = "def"
    digitsLetterMap['4'] = "ghi"
    digitsLetterMap['5'] = "jkl"
    digitsLetterMap['6'] = "mno"
    digitsLetterMap['7'] = "pqrs"
    digitsLetterMap['8'] = "tuv"
    digitsLetterMap['9'] = "wxyz"

    var x = 0
    var y = 0
    val comboMatrix = mutableListOf<CharArray>()
    val comboList = mutableListOf<String>()

    for (i in digits) {
        comboMatrix.add(digitsLetterMap[i]!!.toCharArray())
    }

    var comboWords = ""
    var nextYTarget = 0
    var nextXTarget = 0

    while (
        (x <= comboMatrix[comboMatrix.size - 1].size - 1) &&
        (y <= comboMatrix[comboMatrix.size - 1].size - 1)
    ) {
        comboWords = "${comboMatrix[x][y]}"

        if ( // (2, 2)
            x == (comboMatrix[comboMatrix.size - 1].size - 1) &&
            y == (comboMatrix[comboMatrix.size - 1].size - 1)
        ) {
            comboList.add(comboWords)
            comboWords = ""
            nextYTarget++
            y = nextYTarget
            x = nextXTarget
        } else if (x == 0 && x < y) { // (0, 2)
            x++
            y = 0
        } else if (x == comboMatrix.size - 1) { // (2, 0)
            comboList.add(comboWords)
            comboWords.substring(0, comboWords.length - 1)
            y++
        } else { // (1, 0)
            x++
        }
    }
}

fun main() {
    println(letterCombinationsTwo("23"))
}