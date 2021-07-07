package subtask3

class TelephoneFinder {

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.toInt() < 0) {
            return null
        }

        val arr = ArrayList<String>(0)
        val mapOfNeighbors = HashMap<Char, List<Char>>()
        mapOfNeighbors['0'] = listOf('8')
        mapOfNeighbors['1'] = listOf('2', '4')
        mapOfNeighbors['2'] = listOf('1', '3', '5')
        mapOfNeighbors['3'] = listOf('2', '6')
        mapOfNeighbors['4'] = listOf('1', '5', '7')
        mapOfNeighbors['5'] = listOf('2', '4', '6', '8')
        mapOfNeighbors['6'] = listOf('3', '5', '9')
        mapOfNeighbors['7'] = listOf('4', '8')
        mapOfNeighbors['8'] = listOf('0', '5', '7', '9')
        mapOfNeighbors['9'] = listOf('6', '8')

        for(i in number.indices) {
            val number2 = number.toCharArray()
            for (j in mapOfNeighbors[number2[i]]!!) {
                number2[i] = j
                arr.add(String(number2))
            }
        }
        return arr.toTypedArray()
    }
}
