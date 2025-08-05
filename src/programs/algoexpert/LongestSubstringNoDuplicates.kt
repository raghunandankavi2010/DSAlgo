package programs.algoexpert


fun main() {
    val input = "dabcef"
    val output = longestSubstringWithoutDuplication(input)
    println("Longest substring without duplicates for $input is  $output")
}

private fun longestSubstringWithoutDuplication(string: String): String {
    // Write your code here.
    val hashMap = HashMap<Char, Int>()
    var start = 0
    var end = 0
    var longestStart = 0
    var longestEnd = 0

    while (end < string.length ) {
         val currChar = string[end]
         if (hashMap.contains(currChar)) {
            start = maxOf(start, hashMap.getOrDefault(currChar,0) + 1)
         }

        if( end - start > longestEnd - longestStart) {
            longestStart = start
            longestEnd = end
        }

        hashMap.put(string[end], end)
        end++
    }

    return string.substring(longestStart  , longestEnd + 1 )
}
