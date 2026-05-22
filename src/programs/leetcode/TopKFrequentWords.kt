/*
 * Copyright 2026 Raghunandan Kavi
 *
 * Created by Raghunandan Kavi on 22 May 2026.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package programs.leetcode

import java.util.PriorityQueue

/**
 * Step	Current Word	  Freq	     pq.offer()/pq.poll() actions	pq (conceptual elements, highest priority at top)	           result
 * 1	"i"	3	        offer("i")	                                               [ "i" (3) ]	                                    []
 * 2	"love"	2	    offer("love")	                                         [ "love" (2), "i" (3) ]	                        []
 * 3	"leetcode"	1	offer("leetcode"), poll()	                  [ "love" (2), "i" (3) ]   (removed "leetcode" (1))            []
 * 4	"coding"	2	offer("coding"), poll()	                   [ "love" (2), "i" (3) ] (removed "coding" (2) - larger lex)	    []
 * 5	(Finish)		poll()	                                            [ "i" (3) ] (removed "love" (2))	                   ["love"]
 * 6	(Finish)		poll()	                                             [ ] (removed "i" (3))	                            ["love", "i"]
 * 7	(Reverse)		["i", "love"]
 */
private fun topKFrequent(words: Array<String>, k: Int): List<String> {

    val map = HashMap<String, Int>()

    words.forEach { word ->

        if(map.containsKey(word)) {
            val currVal = map.getOrDefault(word,0)
            map[word] = currVal + 1
        } else {
            map[word] = 1
        }
    }

    val pq = PriorityQueue<String> { a, b ->
        val freqA = map.getValue(a)
        val freqB = map.getValue(b)

        if (freqA != freqB) {
            freqA - freqB
        } else {
            b.compareTo(a)
        }
    }

    map.forEach { (word,value) ->
        pq.add(word)
        if(pq.size > k) {
            pq.poll()
        }
    }

    val result = ArrayList<String>()
    while (pq.isNotEmpty()) {
        result.add(pq.poll())
    }
    return result.reversed()
}


fun main() {
    val array= arrayOf("i","love","leetcode","i","love","coding")
    val k = 2
    val output = topKFrequent(array,k)
    println("Top k frequent elements are $output")

}