import java.math.BigDecimal

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
fun getAddOns(node: ListNode?): BigDecimal {
    var cursor: ListNode? = node
    var figure = ""

    while (cursor != null) {
        figure = "${cursor.`val`}$figure"
        cursor = cursor.next
    }

    return BigDecimal(figure)
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val sum = getAddOns(l1) + getAddOns(l2)
    val sumArr = sum.toString().toCharArray()

    val start: ListNode? = ListNode(sumArr[sumArr.size - 1].toString().toInt())

    if (sumArr.size == 1) {
        return start
    } else {
        start?.next = ListNode(sumArr[sumArr.size - 2].toString().toInt())
        var current = start?.next

        var counter = sumArr.size - 3

        while (counter >= 0) {
            var next: ListNode? = ListNode(sumArr[counter].toString().toInt())
            current?.next = next
            current = null
            current = next
            next = null
            counter--
        }

        return start
    }
}

fun main() {
}