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


public class SingletonClass{

    // volatile ensures the instance is visible to the other thread
    private static volatile SingletonClass instance;

    // prevent breaking singleton with serialization
    protected Object readResolve() {
        return instance;
    }

    // throw error if you try to create instance with reflection
    private SingletonClass() {
        if(instance!=null){
            throw new InstantiationError( "Creating of this object is not allowed." );
        }
    }

    // prevent breaking singleton with cloning.
    @Override
    protected Object clone() throws CloneNotSupportedException  {
        throw new CloneNotSupportedException();
    }

    // make singleton thread safe but has little overhead cost for synchronization
    private static SingletonClass getInstance(){
        if(instance==null){
            synchronized(SingletonClass.class){
                if(instance == null){
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }

}
