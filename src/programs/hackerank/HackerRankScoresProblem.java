package programs.hackerank;

import java.util.ArrayList;
import java.util.List;

public class HackerRankScoresProblem {

    public static void main(String[] args){
        int[] arr = {3 ,4 ,21, 36, 10, 28, 35, 5, 24, 42};
        int n = arr.length;
        int lowestScore = arr[0];
        int highestScore = arr[0];
        List<Integer> minRecord = new ArrayList<Integer>();
        List<Integer> maxRecord = new ArrayList<Integer>();
        for(int i=1;i<n;i++){
            if(arr[i]<lowestScore){
                lowestScore = Math.min(lowestScore,arr[i]);
                minRecord.add(i);
            }  if(arr[i]>highestScore){
                highestScore = Math.max(lowestScore,arr[i]);
                maxRecord.add(i);
            }
        }
        System.out.println(minRecord.size()+" "+maxRecord.size());
    }
}
