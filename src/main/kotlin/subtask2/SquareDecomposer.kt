package subtask2

import kotlin.math.pow

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 0) {
            return null
        }
        var sum = number.toDouble().pow(2.0)
        val arr = ArrayList<Int>()
        var lastNumber = 0

        fun checkArray(num: Int) {
            for (value in num - 1 downTo 1) {
//                if (sum != 1.0) {
                    when (value.toDouble().pow(2.0).toInt()) {
                        in ((sum.toInt() / 2) + 1)..sum.toInt() -> {
                            arr.add(value)
                            sum -= value.toDouble().pow(2.0)
                        }
                    }
//                }
            }

            if (arr.size <= 1) {
                sum = 0.0
            }

            if(arr.map { it }.toSet().size != arr.size || sum != 0.0) {

                if(arr.last() > 1) {
                    lastNumber = arr.last()
                    arr.subList(arr.size - 1, arr.size).clear()
                    sum = number.toDouble().pow(2.0)
                    for (e in arr) {
                        sum -= (e).toDouble().pow(2.0)
                    }
                    checkArray(lastNumber)
                } else {
                    lastNumber = arr[arr.size - 2]
                    arr.subList(arr.size - 2, arr.size).clear()
                    sum = number.toDouble().pow(2.0)
                    for (e in arr) {
                        sum -= (e).toDouble().pow(2.0)
                    }
                    checkArray(lastNumber)
                }
            }
        }
        checkArray(number)

        return if (arr.size <= 1) null else arr.toTypedArray().reversedArray()
    }
}
