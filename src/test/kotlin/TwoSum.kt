fun twoSum(nums: IntArray, target: Int): IntArray {
    val sol = HashMap<Int, IntArray>()
    var cursor = 0
    var counter: Int = cursor + 1

    while (cursor < (nums.size - 1)) {
        sol[nums[cursor] + nums[counter]] = intArrayOf(cursor, counter)

        if (counter == nums.size - 1) {
            cursor++
            counter = cursor + 1
        } else {
            counter++
        }
    }

    return sol[target]!!
}

fun main() {
    
}