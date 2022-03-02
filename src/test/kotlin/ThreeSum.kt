fun threeSum(nums: IntArray): List<List<Int>> {
    if (nums.size < 3) return emptyList()

    nums.sort()
    val threeSumList = mutableListOf<List<Int>>()
    var i = 0

    while (i <= (nums.size - 2)) {
        if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
            var low = i + 1
            var high = nums.size - 1
            val diff = 0 - nums[i]

            if ((nums[low] + nums[high]) == diff) {
                threeSumList.add(listOf(nums[i], nums[low], nums[high]))

                while (low < high && nums[low] == nums[low+1]) low++
                while (low < high && nums[high] == nums[high-1]) high--

                low++
                high--
            } else if (nums[low] + nums[high] > diff) {
                high--
            } else {
                low--
            }
        }

        i++
    }

    return threeSumList
}

fun threeSumBeta(nums: IntArray): List<List<Int>>? {
    nums.sort()
    val output_arr: MutableList<List<Int>> = mutableListOf()
    for (i in 0 until nums.size - 2) {
        if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
            var low = i + 1
            var high = nums.size - 1
            val sum = 0 - nums[i]
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    output_arr.add(listOf(nums[i], nums[low], nums[high]))
                    while (low < high && nums[low] == nums[low + 1]) low++
                    while (low < high && nums[high] == nums[high - 1]) high--
                    low++
                    high--
                } else if (nums[low] + nums[high] > sum) {
                    high--
                } else {
                    low++
                }
            }
        }
    }
    return output_arr
}

fun main() {
    println(threeSumBeta(intArrayOf(-1,0,1,2,-1,-4)))
}