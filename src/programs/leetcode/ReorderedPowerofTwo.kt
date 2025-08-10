package programs.leetcode


fun main() {
    val n = 23

    val permutations = generatePermutations(n.toString())

    var foundPowerOfTwo = false
    for (pStr in permutations) {
        if (pStr.length > 1 && pStr.startsWith('0')) {
            continue
        }

        val num = pStr.toInt()
        println("Checking $num...")

        if (isPowerOfTwo(num)) {
            foundPowerOfTwo = true
            break
        }
    }

    println(foundPowerOfTwo)

    println(reorderedPowerOf2(n))
}

private fun isPowerOfTwo(num: Int): Boolean {
    return num > 0 && (num and (num - 1)) == 0
}


private fun generatePermutations(s: String): MutableList<String> {
    val results = mutableListOf<String>()
    permuteHelper("", s, results)
    return results
}

private fun permuteHelper(permute: String, n: String, resultString: MutableList<String>) {

    if (n.isEmpty()) {
        resultString.add(permute)
        return
    }
    for (i in 0..n.length - 1) {
        permuteHelper(permute + n[i], n.substring(0, i) + n.substring(i + 1), resultString)
    }

    return
}


private fun reorderedPowerOf2(n: Int): Boolean {
    val nSignature = String(n.toString().toCharArray().apply { sort() })

    for (i in 0..30) {
        val powerOfTwo = 1 shl i

        val powerSignature = String(powerOfTwo.toString().toCharArray().apply { sort() })

        if (nSignature == powerSignature) {
            return true
        }
    }

    return false
}