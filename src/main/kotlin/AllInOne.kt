import java.util.regex.Pattern
import kotlin.math.abs
import kotlin.math.sqrt

fun main() {
    val a = "aabbbcddaa"
    val b = a.groupBy { it }
    print(divisibleSumPairs())
}

fun closestNumber(number: Int): Int {
    val ar = arrayOf(2, 6, 9, 4, 1, 23, 55)
    return ar.minBy { abs(number-it) }!!
}

fun fizzBuzz() {
    for (i in 1..100) {
        if (i%15 == 0) println("FizzBuzz")
        else {
            if (i%3 == 0) println("Fizz")
            if (i%5 == 0) println("Buzz")
            else println("$i")
        }
    }
}

fun reverseArray(): Array<Int> {
    val a = arrayOf(1,3,4,5,6)
    val b = arrayOfNulls<Int>(a.size)
    for(i in 0 until a.size) {
        b[a.size-1-i] = a[i]
    }
    return a.reversedArray()
}

fun camelCase(): Int {
    val s = "camelCaseWords"
    val res = s.split(Pattern.compile("[A-Z]"))
    return res.size
}

fun birdsCount(): Int {
    val array: Array<Int> = arrayOf(1,2,3,4,5,4,3,2,1,5,3)
    val result: MutableMap<Int, Int> = mutableMapOf()
    result[1] = 0
    result[2] = 0
    result[3] = 0
    result[4] = 0
    result[5] = 0

    array.forEach { bird ->
        result[bird] = result[bird]!! + 1
    }

    return result.filterValues { it == result.values.max() }.keys.first()
}

fun birthdayCakeCandles() {
    val arr = arrayOf(1, 3, 5, 2,3, 5, 1)
    arr
        .filter { it == arr.max() }
        .count()
}

fun botAppetit() {
    val bill = arrayOf(3,10,2,9)
    val k = 1
    val b = 12
    val total = bill.sum()
    if(k == 0 && b == total/2)
        print("Bon Appetit")
    else {
        if(k == 0) {
            (total-bill[k])/2
        }
        else {
            if(b == (total-bill[k])/2)
                print("Bon Appetit")
            else {
                print(b - (total-bill[k])/2)
            }
        }
    }
}

fun veryBigSum() {
    val ar = arrayOf(1000000001, 1000000002, 1000000003, 1000000004, 1000000005)
    var summ = 0L
    ar.forEach {
        summ += it
    }
    print(summ)
    abs(summ)
}

fun compareTriplets() {
    val a = arrayOf(17, 28, 30)
    val b = arrayOf(99, 16, 8)
    var aPoints = 0
    var bPoints = 0
    for(i in 0 until 3) {
        if(a[i] > b[i])
            aPoints++
        if(a[i] < b[i])
            bPoints++
    }
    print("$aPoints $bPoints")
}

fun plusMinus() {
    val ar = arrayOf(-100, 40, 0, 23, 44, -2)
    val arCount = 6f
    val pos = (ar.filter { it > 0 }.count()).toFloat()/arCount
    val neg = (ar.filter { it < 0 }.count()).toFloat()/arCount
    val zero = (ar.filter { it == 0 }.count()).toFloat()/arCount
    println("%.6f".format(pos))
    println("%.6f".format(neg))
    println("%.6f".format(zero))
}

fun staircase() {
    val size = 4
    for(i in 1..size) {
        println(" ".repeat(size - i).plus("#".repeat(i)))
    }
}

fun miniMax() {
    val arr = arrayOf(1, 3, 5, 6, 9)
    var sum: Long = 0L
    arr.forEach {
        sum += it
    }
    val min = arr.sortedArray()[0]
    val max = arr.sortedArray()[4]
    println(sum - min)
    println(sum - max)
}

fun diagonalDiff(): Int {
    val arr = arrayOf(arrayOf(11, 2, 4), arrayOf(4,5,6), arrayOf(10, 8, -12))
    val n = arr.size
    var left = 0
    var right = 0
    for(i in 0 until n) {
        left+=arr[i][i]
        for(j in n-1 downTo 0) {
            if(i == n-1-j)
                right+=arr[i][j]
        }
    }
    return abs(left-right)
}

fun gradeStudents(): Array<Int> {
    val arr = arrayOf(73, 84, 67, 33, 38)
    val result = IntArray(arr.size)
    arr.forEachIndexed { index, it ->
        if(it >= 38 && (it%5 in 3..4))
            result[index] = it + 5 - it%5
        else
            result[index] = it
    }
    return result.toTypedArray()
}

fun kangaroo(): String {
    var x1 = 0
    val v1 = 3
    var x2 = 4
    val v2 = 2
    for(x in x1..10000) {
        if(x1 == x2)
            return "Yes"
        else {
            x1 += v1
            x2 += v2
        }
    }
    return "No"
}

fun hurdleRace() {
    val ar = arrayOf(1, 6, 3, 5, 2)
    ar.max()
}

fun viralAdv(): Int {
    return 5/2
}

fun superReduce(): String {
    var res = "aab"
    var i = 1
    while(i < res.count()) {
        if(res[i] == res[i-1]) {
            res = res.removeRange(i-1, i+1)
            i = 1
        }
        else
            i++
    }
    return if(res == "") "Empty String" else res
}

fun cavityMap(): Array<String> {
    val grid = arrayOf("179443854", "961621369", "164139922", "968633951", "812882578", "257829163", "812438597",
        "176656233",
        "485773814")
    val size = grid.size
    val result = grid
    if(size < 3) return result
    for(i in 1 until size-1) {
        for(j in 1 until size-1) {
            if(grid[i][j].toInt() > grid[i-1][j].toInt()
                && grid[i][j].toInt() > grid[i+1][j].toInt()
                && grid[i][j].toInt() > grid[i][j-1].toInt()
                && grid[i][j].toInt() > grid[i][j+1].toInt()) {
                val d = result[i].toCharArray()
                d[j] = 'X'
                result[i] = String(d)
            }
        }
    }

    return result
}

fun findDigits(n: Int): Int {
    val ns = n.toString().replace("0","")
    var devider = 0
    ns.forEach {
        if(n % (it.toInt()-48) == 0) devider++
    }
    return devider
}

fun equalizeArray(): Int {
    val arr = arrayOf(55, 1, 2, 3, 3, 4, 3)
    val nums = arr.distinct().sorted()
    val count = mutableListOf<Int>()
    count.toTypedArray()
    nums.forEach { num ->
        count.add(arr.filter { it == num }.count())
    }
    return count.sum() - count.max()!!
}

fun taumBday(): Long {
    val b = 3
    val w = 6
    val bc = 9
    val wc = 1
    val z = 1
    if(abs(bc-wc) <= z) {
        return (b*bc + w*wc).toLong()
    }
    else {
        if(bc > wc)
            return ((b+w)*wc + b*z).toLong()
        else
            return ((b+w)*bc + w*z).toLong()
    }
}

fun howManyGames(): Int {
    val p = 20
    val d = 3
    val m = 6
    var s = 80
    var dim = p
    var result = 0
    while(s >= m) {
        s-=dim
        result++
        dim-=d
    }
    return result
}

fun chocolateFeast(n: Int, c: Int, m: Int): Int {
    var total = 0
    var wrappers = 0
    total = n/c
    wrappers = total
    while(wrappers >= m) {
        val x = wrappers/m
        wrappers = wrappers%m
        total+=x
        wrappers+=x
    }

    return total
}

fun squares() {
    val a = 3
    val b = 100
    val sqrta = sqrt(a.toDouble())
    val sqrtb = sqrt(b.toDouble())
    val aStart = if(sqrta % 1.0 == 0.0) sqrta.toInt() else sqrta.toInt() + 1
    val bStart = if(sqrtb % 1.0 == 0.0) sqrtb.toInt() else sqrtb.toInt()
    val res = bStart - aStart
    print(res+1)
}

fun circularArrayRotation(k: Int): Array<Int> {
    val a = arrayOf(1, 2, 3, 4, 5)
    val size = a.size
    val start = a.sliceArray(size - k until size)
    val end = a.sliceArray(0 until size-k)
    a.forEachIndexed { index, i ->

    }
    return start + end
}

fun findLongestString(): Int {
    var longest: Int = 1
    val s: String = "aaabbbbcsdsdsd"
    s.groupingBy {  }
    var current = 1
    for(i in 0 until s.length-1) {
        if(s[i] == s[i+1])
            current++
        else {
            if (current > longest)
                longest = current
            current = 1
        }
    }
    return longest
}

fun cutTheSticks() {
    val a = arrayOf(1, 2, 3, 4, 3, 3, 2, 1)
}

// https://www.hackerrank.com/challenges/divisible-sum-pairs/
fun divisibleSumPairs(): Int {
    val ar = arrayOf(1, 3, 2, 6, 1, 2)
    val k = 3
    var count = 0
    val n = 6
    for(i in 0 until n-1) {
        for(j in i+1 until n) {
            if((ar[i] + ar[j])%k == 0)
                count++
        }
    }
    return count
}


