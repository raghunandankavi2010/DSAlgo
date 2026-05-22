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

package programs.test;

import java.util.concurrent.Callable;

interface Bird {
    Egg lay();
}

class Chicken implements Bird {

    public Chicken() {
    }

    public Egg lay() {
        return new Egg(new Callable<Bird>() {
            @Override
            public Chicken call() throws Exception {
                return new Chicken();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        System.out.println(chicken instanceof Bird);
        Egg egg1 = chicken.lay();
        egg1.hatch();
        egg1.hatch();

    }
}

class Egg
{
    Callable<Bird> createBird;
    public Egg(Callable<Bird> createBird) {
        this.createBird = createBird;
    }

    public Bird hatch() throws Exception {
        if (createBird == null)
            throw new IllegalStateException();
        try {
            return createBird.call();
        } finally {
            createBird = null;
        }
    }
}
