package programs.strings


fun main() {
    val input = "This is my String"

    val map = LinkedHashMap<Char, Int>()

    for (i in input.indices) {
        val ch = Character.toLowerCase(input[i])
        if (ch != ' ') {
            if (!map.containsKey(ch)) {
                map[ch] = 1
            } else {
                val count = map.getOrDefault(ch, 0)
                map[ch] = count+1
            }
        }
    }

    map.forEach { (k, v) ->
        println("$k = $v")
    }
}
