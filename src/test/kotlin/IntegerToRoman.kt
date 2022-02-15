fun intToRoman(num: Int): String {

    val intToRomanMap = hashMapOf<Int, String>()
    intToRomanMap[1] = "I"
    intToRomanMap[5] = "V"
    intToRomanMap[10] = "X"
    intToRomanMap[50] = "L"
    intToRomanMap[100] = "C"
    intToRomanMap[500] = "D"
    intToRomanMap[1000] = "M"

    val subtractionMap = hashMapOf<Int, String>()
    subtractionMap[4] = "IV"
    subtractionMap[9] = "IX"
    subtractionMap[40] = "XL"
    subtractionMap[90] = "XC"
    subtractionMap[400] = "CD"
    subtractionMap[900] = "CM"

    val placeNumberMap = hashMapOf<Int, Int>()
    placeNumberMap[1] = 1
    placeNumberMap[2] = 10
    placeNumberMap[3] = 100
    placeNumberMap[4] = 1000

    if (intToRomanMap.containsKey(num)) return intToRomanMap[num]!!

    val romanSb = StringBuilder()
    val numCharArray = num.toString().toCharArray()
    var i = 0

//    3999
//    MMMCMXCIX
    while (i < numCharArray.size) {
        var placeHolderValue = numCharArray[i].digitToInt() * placeNumberMap[numCharArray.size - i]!!

        if (subtractionMap.containsKey(placeHolderValue)) {
            romanSb.append(subtractionMap[placeHolderValue])
        } else {
            while (placeHolderValue >= placeNumberMap[numCharArray.size - i]!!) {
                if (placeHolderValue > 5 && placeNumberMap[numCharArray.size - i]!! == 1) {
                    romanSb.append("V")
                    placeHolderValue -= 5
                } else {
                    romanSb.append(intToRomanMap[placeNumberMap[numCharArray.size - i]!! * numCharArray[i].digitToInt()])
                    placeHolderValue -= placeNumberMap[numCharArray.size - i]!! * numCharArray[i].digitToInt()
                }
            }
        }
        i++
    }

    return romanSb.toString()
}

fun main() {
    println(intToRoman(58))
}