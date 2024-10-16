package programs.designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 *  Subscribe Observe design pattern
 */
public class ObserverPattern {

    public static void main(String[] args) {

        MyTopicSubscriber subscriber = new MyTopicSubscriber();

        Observer observer1 = new MyObserver("Observer1");
        subscriber.register(observer1);

        Observer observer2 = new MyObserver("Observer2");
        subscriber.register(observer2);

        observer1.setSubscriber(subscriber);
        observer2.setSubscriber(subscriber);

        observer1.print();

        subscriber.postMessage("First Message to all observers");

        subscriber.unregister(observer2);

        subscriber.postMessage("Second Message to all observers");


    }
}

interface Subscriber {

    void register(Observer obj);

    void unregister(Observer obj);

    void notifyObservers();

    Object getUpdate(Observer obj);
}

interface Observer {

    void print();

    void setSubscriber(Subscriber sub);
}

class MyTopicSubscriber implements Subscriber {

    private List<Observer> observerList;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    public MyTopicSubscriber() {
        observerList = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        if (observer == null)
            throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if (!observerList.contains(observer))
                observerList.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        synchronized (MUTEX) {
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> local;
        synchronized (MUTEX) {
            if (!changed)
                return;
            local = new ArrayList<>(this.observerList);
            this.changed = false;
        }
        for (Observer observer : local) {
            observer.print();
        }
        
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    public void postMessage(String msg){
        System.out.println("Message Posted :"+msg);
        this.message=msg;
        this.changed=true;
        notifyObservers();
    }
}

class MyObserver implements Observer {

    private Subscriber subscriber;
    private String myObserver;

    public MyObserver(String myObserver){
        this.myObserver = myObserver;
    }
    @Override
    public void print() {
        String msg = (String) subscriber.getUpdate(this);
        if(msg==null){
            System.out.println("No new message to print");
        }else{
            System.out.println(myObserver +" Received new message "+msg);
        }

    }

    @Override
    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }
}

