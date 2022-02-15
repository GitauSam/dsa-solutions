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
    subtractionMap[60] = "LX"
    subtractionMap[70] = "LXX"
    subtractionMap[80] = "LXXX"
    subtractionMap[90] = "XC"
    subtractionMap[400] = "CD"
    subtractionMap[600] = "DC"
    subtractionMap[700] = "DCC"
    subtractionMap[800] = "DCCC"
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

    while (i < numCharArray.size) {
        var placeHolderValue = numCharArray[i].toString().toInt() * placeNumberMap[numCharArray.size - i]!!

        if (intToRomanMap.containsKey(placeHolderValue)) {
            romanSb.append(intToRomanMap[placeHolderValue])
            placeHolderValue -= numCharArray[i].toString().toInt() * placeNumberMap[numCharArray.size - i]!!
        } else if (subtractionMap.containsKey(placeHolderValue)) {
            romanSb.append(subtractionMap[placeHolderValue])
        } else {
            while (placeHolderValue >= placeNumberMap[numCharArray.size - i]!!) {
                if (placeHolderValue > 5 && placeNumberMap[numCharArray.size - i]!! == 1) {
                    romanSb.append("V")
                    placeHolderValue -= 5
                } else {
                    romanSb.append(intToRomanMap[placeNumberMap[numCharArray.size - i]!!])
                    placeHolderValue -= placeNumberMap[numCharArray.size - i]!!
                }
            }
        }
        i++
    }

    return romanSb.toString()
}

fun main() {
    println(intToRoman(60))
}