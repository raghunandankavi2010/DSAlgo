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

package programs.threads;


 class Singleton {

    // inner static class ensures one instance always
    // when class is loaded inner class is not loaded
   private static class StaticHelper {
        private static final Singleton billPloughSingleton = new Singleton();
    }

    // instance created whe first time call to getInstance
    public static Singleton getInstance(){
        return StaticHelper.billPloughSingleton;
    }
}

public class BillPloughSingleton{
    public static void main(String[] args) {
       Singleton singleton =  Singleton.getInstance();
    }
}