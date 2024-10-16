package programs.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TestListContains {

    public static void main(String[] args) {

        //new TestListContains().test();

        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        System.out.println(new TestListContains().closest(29,list));
    }


    public int closest(int of, List<Integer> in) {
        int min = of;
        int closest = 0;

        for (int v : in) {
            final int diff = Math.abs(v - of);

            if (v < of) {
                closest = Math.max(closest,v);
            }
        }
        return closest;
    }


    private void test() {

        List<StudentA> listA = new ArrayList<StudentA>();
        for (int i = 0; i < 5; i++) {
            StudentA studentA = new StudentA();
            studentA.setAge(i);
            studentA.setName("i" + i);
            listA.add(studentA);
        }

        List<StudentB> listB = new ArrayList<StudentB>();
        StudentB studentB = new StudentB();
        studentB.setAge(0);
        studentB.setName("i" + 0);
        listB.add(studentB);

        StudentB studentB2 = new StudentB();
        studentB2.setAge(4);
        studentB2.setName("i" + 4);
        listB.add(studentB2);

        for(int i=0;i<listA.size();i++) {

            System.out.println("Element in list a "+listA.get(i).age);

        }

        System.out.println("..............................");
        for(int i=0;i<listB.size();i++) {

            System.out.println("Element in list b "+listB.get(i).age);

        }

        System.out.println("..............................");

        for(int i=0;i<listA.size();i++) {
            int age = listA.get(i).getAge();
            if(find(age,listB)) {
                continue;
            } else {
                System.out.println("Missing in listb "+listA.get(i).age);
            }
        }
    }

    private boolean find(int age, List<StudentB> listB) {
        boolean check = false;
        for (int j = 0; j < listB.size(); j++) {
            int ageb = listB.get(j).getAge();
            if (age == ageb) {
                check = true;
                break;
            } else {
                check = false;
            }
        }
        return check;
    }

    
    class StudentA {

    private int age;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class StudentB {

    private int age;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;

        if (object instanceof StudentB) {
            isEqual = (this.age == ((StudentB) object).age);
        }

        return isEqual;
    }


    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}
}
