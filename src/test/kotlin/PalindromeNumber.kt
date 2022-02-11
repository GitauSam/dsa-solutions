fun isPalindrome(x: Int): Boolean {
    val xCharArr = x.toString().toCharArray()

    if (xCharArr.isEmpty()) return false

    var i = 0
    var j = x.toString().length - 1

    while (i < j) {
        if (xCharArr[i] != xCharArr[j]) {
            return false
        }

        i++
        j--
    }

    return true
}

fun main() {
    println(isPalindrome(123))
}