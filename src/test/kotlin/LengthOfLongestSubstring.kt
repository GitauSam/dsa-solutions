fun lengthOfLongestSubstring(s: String): Int {
    var index = 0
    var counter = index + 1
    var longestSubstringLength = 0
    var memo: HashMap<Char, Boolean> = hashMapOf()

    if (s.isEmpty()) return longestSubstringLength

    if (s.isBlank()) return 1

    if (s.length == 1) return 1

    memo[s[index]] = true

    while (index <= (s.length - 1)) {
        if (index == (s.length - 1)) break
        if (memo[s[counter]] != null && memo[s[counter]]!!) {
            memo = hashMapOf()
            index++
            memo[s[index]] = true
            counter = index + 1
        } else {
            memo[s[counter]] = true
            if (counter == (s.length - 1)) {
                if (memo.size > longestSubstringLength) longestSubstringLength = memo.size
                break
            }
            counter++
        }

        if (memo.size > longestSubstringLength) longestSubstringLength = memo.size
    }

    return longestSubstringLength
}

fun main() {
    println(lengthOfLongestSubstring("d"))
}