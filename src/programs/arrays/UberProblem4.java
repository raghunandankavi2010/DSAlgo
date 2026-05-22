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

package programs.arrays;

/**
 * Given an api which returns an array of chemical names and an array of chemical symbols,
 * display the chemical names with their symbol surrounded by square brackets:
 */
public class UberProblem4 {

    public static void main(String[] args) {

        String[] array = {"Amazon", "Microsoft", "Google"};
        String[] symbols = {" I", "Am", "cro", "Na", "le", "abc"};

        int i= 0;
       for(String word: array){
            array[i] = replace(word,symbols);
            i++;
        }
       for(String replaced: array){
           System.out.println(replaced);

        }
    }

    private static String replace(String word,String[] symbols) {

        for(String symbol: symbols){
            if(word.contains(symbol)){
                String replace = "["+symbol+"]";
                word = word.replace(symbol,replace);
            }
        }
        return word;
    }
}
