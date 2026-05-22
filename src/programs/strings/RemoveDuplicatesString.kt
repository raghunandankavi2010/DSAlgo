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

package programs.strings


fun main() {
    val input1 = "characters"
    val input2 = "alphabets"
    uncommonChars(input1,input2)
    println()
    uncommonUsingSet(input1,input2)
    println()
    uncommonChars2(input1,input2)
    println()
    val input = "aabbc"
    removeDuplicates(input)
}

fun removeDuplicates(input: String){
    val mod = IntArray(256)
    val sb = StringBuilder()
    input.forEachIndexed { index, c ->
        mod[input[index] - 'a'] = mod[input[index] - 'a'] + 1
        if(mod[input[index] - 'a'] == 1) {
            sb.append(c)
        }
    }

    println(sb.toString())
}

fun uncommonUsingSet(input1: String, input2: String) {
    val set1 = HashSet<Char>()

    val set2 = HashSet<Char>()

    input1.forEach {
        set1.add(it)
    }

    input2.forEach {
        set2.add(it)
    }

   set1.forEach { char ->
       if(set2.contains(char)){
           set2.remove(char)
       } else{
           set2.add(char)
       }
   }

    println(set2)
}

fun uncommonChars(input1: String, input2: String){
    val mod = IntArray(26)
    for (element in input1) {
        mod[element - 'a'] = 1
    }
    for (i in input2.indices) {
        var value = mod[input2[i] - 'a']
        value = if (value == 1 || value == -1) {
            -1
        } else {
            1
        }
        mod[input2[i] - 'a'] = value
    }
    for (i in mod.indices) {
        if (mod[i] == 1) {
            print((i + 'a'.toInt()).toChar() + " ")
        }
    }
}

fun uncommonChars2(input1: String, input2: String){
    val mod = IntArray(26)
    for (element in input1) {
        mod[element - 'a'] = 1
    }
    for (element in input2) {
        mod[element - 'a'] += 1
    }
    for (i in mod.indices) {
        if (mod[i] == 1) {
            print((i + 'a'.toInt()).toChar() + " ")
        }
    }
}
