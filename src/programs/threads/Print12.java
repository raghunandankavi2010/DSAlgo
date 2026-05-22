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

/**  Program to print 12 alternatively
 *   from two different threads
 *   using wait and notify
 */

public class Print12 {

    private final Object lock = new Object();

    public static void main(String[] args) {

        Print12 print12 = new Print12();
        print12.print();

    }

    public void print(){

        Thread1 t1 = new Thread1(lock);
        Thread2 t2 = new Thread2(lock);

        t1.start();
        t2.start();
    }
}

class Thread1 extends Thread {

    private final Object lock;

    public Thread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i < 51; i = i + 2) {
            synchronized (lock) {
                System.out.println("t1 " + i);
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Thread2 extends Thread {

    private final Object lock;

    public Thread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 2; i < 51; i = i + 2) {
            synchronized (lock) {
                System.out.println("t2 " + i);
                lock.notify();
                try {
                    if(i==50)
                        break;
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
