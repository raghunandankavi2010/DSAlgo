package programs.recurssion


fun main() {
    val n = 5
    val output = calculateSum(n)
    println("Sum of n numbers is $output")
}

private fun calculateSum(n: Int): Int {
    return calculateSumRecursive(n,0)
}

private fun calculateSumRecursive(n: Int, sum: Int): Int {
    if(n == 0) return sum // base case
    val currSum = sum + n // do calculation
    return calculateSumRecursive(n-1,currSum) //r ecursion
}
