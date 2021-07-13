package ds.program.string

import java.util.*

class MinStepsToCovertAllCharToSame {
    private fun minChanges(s: String): Int {
        val arr = s.toCharArray()
        var maxFreq = 0
        val map = HashMap<Char, Int>()
        for (c in arr) {
            val freq = map.getOrDefault(c, 0) + 1
            maxFreq = Math.max(maxFreq, freq)
            map[c] = freq
        }
        return arr.size - maxFreq
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MinStepsToCovertAllCharToSame().minChanges("^vv>"))
            println(MinStepsToCovertAllCharToSame().minChanges("v>>>vv"))
            println(MinStepsToCovertAllCharToSame().minChanges("<<<"))
            println(MinStepsToCovertAllCharToSame().minChanges("^v<><>>"))
            println(MinStepsToCovertAllCharToSame().aestheticArrangement(intArrayOf(2, 3, 4, 5, 3, 7)))
//            println(MinStepsToCovertAllCharToSame().aestheticArrangement(arrayOf(2,3, 4, 5, 3, 7)))
            if(4 in 1..4){
                println("y")
            } else {
                print ("n")
            }
        }

    }

    fun aestheticArrangement(arr: IntArray): Int {
        var isAlreadyAesthetic = false
        val list = LinkedList<Int>()
        for (i in arr) {
            list.add(i)
        }
        for (i in 0 until list.size - 2) {
            if (isAestheticallyIncreasing(list, i)) {
                isAlreadyAesthetic = true
            } else if (isAestheticallyDecreasing(list, i)) {
                isAlreadyAesthetic = true
            } else {
                isAlreadyAesthetic = false
                break
            }
        }
        if (isAlreadyAesthetic) return 0
        var count = 0
        val ab = LinkedList<Int>()
        for (i in arr.indices) {
            ab.clear()
            ab.addAll(list)
            ab.removeAt(i)
            var f = 0
            var okay = false
            while (f < arr.size - 3) {
                if (!okay && f != 0) {
                    break
                }
                okay = if (isAestheticallyIncreasing(ab, f)) {
                    true
                } else isAestheticallyDecreasing(ab, f)
                f++
            }
            if (okay) {
                count++
            }
        }
        if (count == 0) count = -1
        return count
    }

    private fun isAestheticallyIncreasing(list: LinkedList<Int>, pos: Int): Boolean {
        return list[pos] > list[pos + 1] && list[pos + 1] < list[pos + 2]
    }

    private fun isAestheticallyDecreasing(list: LinkedList<Int>, pos: Int): Boolean {
        return list[pos] < list[pos + 1] && list[pos + 1] > list[pos + 2]
    }

}