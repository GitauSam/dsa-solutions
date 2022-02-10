fun reverse(x: Int): Int {
    val xCharArray: CharArray
    val xReversedSB = StringBuilder()
    val xReversedInt: Int
    var isNegative = false

    if (x < 0) {
        isNegative = true
        xCharArray = x.toString().substring(1).toCharArray()
    } else {
        xCharArray = x.toString().toCharArray()
    }

    for (i in (xCharArray.size - 1) downTo 0) {
        xReversedSB.append(xCharArray[i])
    }

    xReversedInt = if (isNegative) {
        try {
            "-${xReversedSB}".toInt()
        } catch (e: NumberFormatException) {
            return 0
        }
    } else {
        try {
            xReversedSB.toString().toInt()
        } catch (e: NumberFormatException) {
            return 0
        }
    }

    return xReversedInt
}

fun main() {
    println(reverse(-123))
}