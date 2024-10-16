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
