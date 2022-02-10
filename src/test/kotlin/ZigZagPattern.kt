fun convert(s: String, numRows: Int): String {

    if (s.length < 2 || numRows < 2) return s

    val sCharArray = s.toCharArray()
    val zigzag = StringBuilder()
    var i = 0
    var j = 0
    var direction = 1

    val zigzagList: MutableList<MutableList<Char>> = mutableListOf()

    for (h in 0 until numRows) {
        zigzagList.add(mutableListOf())
    }

    for (k in sCharArray) {
        zigzagList[i].add(k)

        if (i >= numRows - 1) {
            direction = 0
            j++
        }

        if (direction == 1) {
            i++
        } else {
            i--
        }

        if (i == 0) {
            direction = 1
        }
    }

    for (l in zigzagList) {
        for (m in l) {
            zigzag.append(m)
        }
    }

    return zigzag.toString()
}

fun main() {
    println(convert("AB", 1))
}