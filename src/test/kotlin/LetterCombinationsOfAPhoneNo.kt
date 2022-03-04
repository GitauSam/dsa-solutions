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

fun main() {
    println(letterCombinationsTwo("23"))
}