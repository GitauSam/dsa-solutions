fun isValid(s: String): Boolean {

    val memo = hashMapOf<Char, Char>()
    memo[')'] = '('
    memo[']'] = '['
    memo['}'] = '{'

    val parens = mutableListOf<Char>()

    for (i in s.indices) {
        if (s[i] == ')' || s[i] == '}' || s[i] == ']') {
            if (memo[s[i]]!! == parens[parens.size - 1]) {
                parens.removeAt(parens.size - 1)
            } else {
                return false
            }
        } else {
            parens.add(s[i])
        }
    }

    if (parens.size > 0) return false

    return true
}