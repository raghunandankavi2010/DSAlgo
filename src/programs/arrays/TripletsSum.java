package programs.arrays;

import java.util.*;

public class TripletsSum {
    public static void main(String[] args) {

        int[] array =  {12, 3, 4, 1, 6, 9};
        int sum = 24;
        ArrayList<Integer> list = new ArrayList<>();

        for (int j : array) {
            list.add(j);
        }

        Collections.sort(list);
        boolean check = false;
        for(int i = 0;i<list.size();i++) {
            int value = list.get(i);
            int toFind = sum - value; // 7
            check = findTwoSum(list,toFind,value,i+1); //list ,7, start
            if(check){
                break;
            }
        }

        if(!check) {
            System.out.println("Triplets not found");
        }
    }

    private static boolean findTwoSum(ArrayList<Integer> list, int toFind, int value,int start) {

        int end = list.size()-1;

        boolean found = false;
        while(start < end) {
            int mysum = list.get(start)+list.get(end);
            if(mysum == toFind) {
                System.out.println(list.get(start) +" "+list.get(end)+ " "+value);
                found = true;
                break;
            } else if(mysum < toFind){
                start++;
            } else {
                end --;
            }
        }
        return found;
    }
}


