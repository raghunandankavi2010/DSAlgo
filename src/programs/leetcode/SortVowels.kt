package programs.leetcode

private fun sortVowels(s: String): String {
    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

    // Step 1: Identify Vowels and Consonants, and store vowels
    val sChars = s.toCharArray()
    val foundVowels = mutableListOf<Char>()
    val vowelIndices = mutableListOf<Int>()

    for (i in sChars.indices) {
        if (sChars[i] in vowels) {
            foundVowels.add(sChars[i])
            vowelIndices.add(i)
        }
    }

    // Step 2: Sort Vowels
    foundVowels.sort() // Sorts in-place based on ASCII values

    // Step 3: Construct the Result String
    val resultChars = s.toCharArray() // Start with a copy of the original string

    // Place sorted vowels back into their original vowel positions
    for (i in foundVowels.indices) {
        resultChars[vowelIndices[i]] = foundVowels[i]
    }

    return String(resultChars)
}

fun main() {
    val s1 = "lEetcOde"
    val output1 = sortVowels(s1)
    println("Input: $s1")
    println("Output: $output1") // Expected: lEOtcede

    val s2 = "PytHOn"
    val output2 = sortVowels(s2)
    println("Input: $s2")
    println("Output: $output2") // Expected: PythON

    val s3 = "aEiOu"
    val output3 = sortVowels(s3)
    println("Input: $s3")
    println("Output: $output3") // Expected: AEiou
}