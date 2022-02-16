fun romanToInt(s: String): Int {
    var index = 0
    var romanInt = 0

    val romanToIntMap = hashMapOf<String, Int>()
    romanToIntMap["M"] = 1000
    romanToIntMap["CM"] = 900
    romanToIntMap["D"] = 500
    romanToIntMap["CD"] = 400
    romanToIntMap["C"] = 100
    romanToIntMap["XC"] = 90
    romanToIntMap["L"] = 50
    romanToIntMap["XL"] = 40
    romanToIntMap["X"] = 10
    romanToIntMap["IX"] = 9
    romanToIntMap["V"] = 5
    romanToIntMap["IV"] = 4
    romanToIntMap["I"] = 1

    while (index < s.length) {
        val indexStr = StringBuilder()
        indexStr.append(s[index])

        if (index < s.length - 1) {
            if (
                (indexStr.toString() == "C" && s[index + 1].toString() == "M") ||
                (indexStr.toString() == "C" && s[index + 1].toString() == "D") ||
                (indexStr.toString() == "X" && s[index + 1].toString() == "C") ||
                (indexStr.toString() == "X" && s[index + 1].toString() == "L") ||
                (indexStr.toString() == "I" && s[index + 1].toString() == "X") ||
                (indexStr.toString() == "I" && s[index + 1].toString() == "V")
            ) {
                index++
                indexStr.append(s[index])
            }
        }

        romanInt += romanToIntMap[indexStr.toString()]!!
        index++
    }

    return romanInt
}

fun main() {
    println(romanToInt("CMIX"))
}