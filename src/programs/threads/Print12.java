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
