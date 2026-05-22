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
 * Queue implementation using array
 */

public class ImplementQueueUsingArray {
    private static int front, rear, capacity;
    private static int queue[];

    public static void main(String[] args) {
        capacity = 10;
        queue = new int[capacity];
        ImplementQueueUsingArray implementQueueUsingArray = new ImplementQueueUsingArray();
        for(int i=1;i<11;i++)
        implementQueueUsingArray.addtoQueue(i);
        System.out.println("Elements after adding");
        implementQueueUsingArray.printElements();
        implementQueueUsingArray.removeFromQueue();
        System.out.println("Elements after removing one element");
        implementQueueUsingArray.printElements();
    }

    private void addtoQueue(int data) {
        if(rear == capacity) {
            System.out.println("Queue is full");
        }else {
            queue[rear] = data;
            rear++;
        }
    }

    private void removeFromQueue() {
        if(front == rear) {
            System.out.println("Queue is Empty");
            return;
        }else {
            if (rear - 1 >= 0) System.arraycopy(queue, 1, queue, 0, rear - 1);
            if (rear < capacity)
                queue[rear] = 0;
            rear--;
        }
    }

    private void printElements() {
        for(int i=front;i<rear;i++){
            System.out.println(queue[i]);
        }
    }
}
