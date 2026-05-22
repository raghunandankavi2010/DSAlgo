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

package programs.generics;



public class Generic implements A,B{

    public static void main(String[] args) {

        System.out.println(add(3.2,4.5));
        System.out.println(add(3234L,2L));
    }

    public static <T extends Number> Number add(T t1, T t2){
        return t1.doubleValue()+t2.doubleValue();
    }

    @Override
    public void test() {

    }


}
