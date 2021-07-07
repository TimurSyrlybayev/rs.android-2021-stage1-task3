package subtask1

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        fun factorial(num: Long): Long {
            return if(num == 1.toLong()) 1 else num * factorial(num - 1.toLong())
        }

        val a = array[0].toLong()
        val b = array[1].toLong()
        val arr = Array(b.toInt()) { 0 }

        for(i in 1 until b.toInt()) {
            arr[i - 1] = (factorial(b) / (factorial(i.toLong()) * factorial(b - i.toLong()))).toInt()
        }

        return if (arr.indexOf(a.toInt()) == -1) null else arr.indexOf(a.toInt()) + 1
    }
}
