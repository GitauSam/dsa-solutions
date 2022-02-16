fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.size == 1) return strs[0]

    var index = 1
    var prefixIndex = 0
    var longestCommonPrefix = ""

    while (index < strs.size) {
        if (
            (prefixIndex >= strs[index].length) ||
            (strs[0][prefixIndex] != strs[index][prefixIndex])
        ) {
            index++
            prefixIndex = 0
        } else {
            if (longestCommonPrefix.length >= prefixIndex) {
                if (longestCommonPrefix[prefixIndex] != strs[index][prefixIndex]) {
                    longestCommonPrefix = longestCommonPrefix.substring(0, prefixIndex)
                }
            } else {
                longestCommonPrefix = strs[index][prefixIndex].toString()
            }
//            longestCommonPrefix = "$longestCommonPrefix${strs[index][prefixIndex]}"
            prefixIndex++
        }
    }

    return longestCommonPrefix
}

fun main() {
    println(longestCommonPrefix(arrayOf("flower","flow","flight")))
}