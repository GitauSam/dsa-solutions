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

    var rowIndex = 0
    var colIndex = 0
    var nextColIndex = 0
    val comboMatrix = mutableListOf<CharArray>()
    val columnIndicesArr = Array(digits.length) { 0 }
    val comboList = mutableListOf<String>()

    for (i in digits) {
        comboMatrix.add(digitsLetterMap[i]!!.toCharArray())
    }

    var comboWords = ""

    while (rowIndex <= columnIndicesArr.size) {
        comboWords = "${comboMatrix[rowIndex][colIndex]}"

        if (comboWords.length > 1) comboList.add(comboWords)

        if (rowIndex == columnIndicesArr.size - 1) {
            colIndex++
            nextColIndex++
        } else {
            rowIndex++
        }

        if (rowIndex == columnIndicesArr.size - 1 && colIndex == comboMatrix[rowIndex].size - 1) {
            colIndex = nextColIndex
        }
    }
}

fun main() {
    println(letterCombinationsTwo("23"))
}