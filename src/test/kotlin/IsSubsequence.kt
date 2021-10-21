fun isSubsequence(s: String, t: String): Boolean {
    var i = 0
    var c = 0

    if (s.isEmpty() && t.isEmpty()) return true
    if (s.isEmpty()) return true
    if (t.isEmpty()) return false

    while(i <= (t.toCharArray().size - 1)) {
        if (c == (s.toCharArray().size - 1) && s[c] == t[i]) {
            return true
        }

        if (s[c] == t[i]) {
            c++
        }

        i++
    }

    return false
}
fun main() {
    println(isSubsequence("bb", "ahbgdc"))
}