fun myAtoi(s: String): Int {
    if (s.isEmpty()) return 0

    val sb = StringBuilder()
    val atoiCharArray = s.trim().toCharArray()
    var flag = false
    var polarity = true
    var count = 0

    for (i in atoiCharArray) {
        count++
        try {
            i.toString().toInt()
            sb.append(i)
            flag = true
        } catch (e: NumberFormatException) {
            toContinueOrNotToContinue(flag, polarity, sb, count)
                ?.let {
                    return it
                }
            when (i) {
                '-' -> {
                    sb.append(i)
                    polarity = false
                }
                '+' -> {
                    sb.append(i)
                }
                else -> {
                    return 0
                }
            }
        }
    }

    toContinueOrNotToContinue(flag, polarity, sb, count)
        ?.let {
            return it
        }

    return 0
}

fun toContinueOrNotToContinue(flag: Boolean, polarity:Boolean, sb: StringBuilder, count: Int): Int? {
    if (flag) {
        if (polarity && sb.toString().toDouble().coerceAtLeast(Int.MAX_VALUE.toDouble()) == sb.toString().toDouble()) {
            return Int.MAX_VALUE
        }

        if (sb.toString().toDouble().coerceAtMost(Int.MIN_VALUE.toDouble()) == sb.toString().toDouble()) {
            return Int.MIN_VALUE
        }

        return sb.toString().toInt()
    } else if (count >= 2) {
        return 0
    }

    return null
}

fun main() {
    println(myAtoi("   .1"))
}