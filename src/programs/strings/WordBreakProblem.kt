package programs.strings

/**
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
]
 */

val map = HashMap<String,List<String>>()

fun main() {
    val inputString = "catsanddog"
    val wordDict = listOf<String>("cat", "cats", "and", "sand", "dog")
    wordBreak(inputString, wordDict)?.forEach {
        println(it)
    }
}

fun wordBreak(s: String, wordDict: List<String>): List<String>? {
    if(map.containsKey(s))
        return map[s]

    val result = ArrayList<String>()

    if(wordDict.contains(s)){
        result.add(s)
    }

    for(i in 1 until s.length) {
        val left = s.substring(0,i)
        if(wordDict.contains(left)) {
            val list = wordBreak(s.substring(i),wordDict)
            list?.forEach {
                result.add("$left $it")
            }
        }
    }
    map[s] = result
    return result

}
