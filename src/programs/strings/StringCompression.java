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

package programs.strings;

/**
 *  input = AAAABBCCAAA
 *  output = A4B2C3A3
 */
public class StringCompression {

    public static void main(String[] args) {
        String input = "AAAABBCCCAAA";
        StringCompression stringCompression = new StringCompression();
        String output = stringCompression.compress(input);
        System.out.println(output);
    }

    private String compress(String input) {
        StringBuilder output = new StringBuilder();
        int count = 1;
        int length = input.length();

        for(int i=0;i<length;i++){
            if(i==length-1){
                output.append(input.charAt(i));
                output.append(count);
                break;
            }else if(input.charAt(i)== input.charAt(i+1)){
                count++;
            }else{
                output.append(input.charAt(i));
                output.append(count);
                count = 1;
            }
        }
        return output.toString();
    }

}
