package programs.generics;



public class Generic implements A,B{

    public static void main(String[] args) {

        System.out.println(add(3.2,4.5));
        System.out.println(add(3234L,2L));
    }

    public static <T extends Number> Number add(T t1, T t2){
        return t1.doubleValue()+t2.doubleValue();
    }

    @Override
    public void test() {

    }


}
