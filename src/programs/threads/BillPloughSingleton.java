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