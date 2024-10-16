package programs.others;

import java.util.*;

/**
 * Hacker rank leader board problem
 */
public class RankMarks {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        // read from command line.
        /*Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int size =  Integer.parseInt(s);
        for(int i=0;i<size;i++){
            String[] input = new String[2];
            String a, b;
            input = sc.nextLine().split(" ");
            a= input[0];
            b= input[1];
            Student student = new Student();
            student.setMarks(Integer.parseInt(b));
            student.setName(a);
            list.add(student);
        }*/
        //1
        Student student1 = new Student();
        student1.setMarks(45);
        student1.setName("rancho");
        list.add(student1);
        // 2
        Student student2 = new Student();
        student2.setMarks(32);
        student2.setName("chatur");
        list.add(student2);
        //3
        Student student3 = new Student();
        student3.setMarks(30);
        student3.setName("raju");
        list.add(student3);
        //5
        Student student4 = new Student();
        student4.setMarks(28);
        student4.setName("farhan");
        list.add(student4);
        // 5
        Student student5 = new Student();
        student5.setMarks(32);
        student5.setName("virus");
        list.add(student5);
        //6
        Student student6 = new Student();
        student6.setMarks(45);
        student6.setName("joy");
        list.add(student6);

        RankMarks rankMarks = new RankMarks();
        rankMarks.sort_print(list);
    }

    private void sort_print(List<Student> list) {
        list.sort((s1, s2) -> {
            if (s1.getMarks() == s2.getMarks())
                return s1.getName().compareTo(s2.getName()); // sort based on name if marks are equal
            else if (s1.getMarks() > s2.getMarks())
                return -1;
            else
                return 0;

        });

        // add rank.
        int rank = 1;
        boolean consecutiveEqual = false;
        list.get(0).setRank(rank);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getMarks() == list.get(i - 1).getMarks()) {
                list.get(i).setRank(rank);
                consecutiveEqual = true;
            } else {
                // if two consecutive ranks are same skip by 2
                if (consecutiveEqual) {
                    rank += 2;
                    list.get(i).setRank(rank);
                    consecutiveEqual = false;
                } else {
                    rank++; // skip rank by one
                    list.get(i).setRank(rank);
                }
            }
        }

        for (Student value : list) {
            System.out.println(value.getRank() + " " + value.getMarks() + " " + value.getName());
        }
    }
}

class Student {

    private int marks;
    private String name;
    private int rank;

    public int getMarks() {
        return marks;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
