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
