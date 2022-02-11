fun maxArea(height: IntArray): Int {

    if (height.size < 2) return 0

    var i = 0
    var j = height.size - 1
    var maxArea = 0
    var bestHeight = 0
    
    while (i < j) {
        if (height[i].coerceAtMost(height[j]) > bestHeight && height[i] > 0 && height[j] > 0) {
            if (height[i] == 1 && maxArea < (j - i)) {
                maxArea = j - i
                bestHeight = 1
                i++
                j = height.size - 1
            } else if (height[i] == height[j] && maxArea < (height[i] * (j - i))) {
                maxArea = height[i] * (j - i)
                bestHeight = height[i]
                i++
                j = height.size - 1
            } else {
                if ((height[i].coerceAtMost(height[j]) * (j - i)) > maxArea) {
                    maxArea = (height[i].coerceAtMost(height[j]) * (j - i))
                    bestHeight = height[i].coerceAtMost(height[j])
                }

                if (j == (i + 1)) {
                    i++
                    j = height.size - 1
                } else {
                    j--
                }
            }
        } else {
            if (j == (i + 1)) {
                i++
                j = height.size - 1
            } else {
                j--
            }
        }
    }
    
    return maxArea
}

fun maxAreaBeta(height: IntArray): Int {
    var l = 0
    var r = height.size - 1
    var area = 0

    while (l < r) {
        area = area.coerceAtLeast(Math.min(height[l], height[r]) * (r - l))

        if (height[l] < height[r]) {
            l++
        } else {
            r--
        }
    }

    return area
}

fun main() {
    println(maxArea(intArrayOf(1,0,0,0,0,0,0,2,2)))
}