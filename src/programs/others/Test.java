package programs.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String args[]) {

        Test test = new Test();
        int[] nums = {3, 0, -2, 6, -3, 2};
        int[][] queries = {{0, 2}, {2, 5}, {0, 5}};

        System.out.println(test.sumInRange(nums,queries));

  /*      long total = 0l;
        int sum = 0;
        long mod = 1000000007L;
        int size = queries.length;
        int[] resultArray = new int[size];
        for(int i=0;i<queries.length;i++) {

            int firstIndex = queries[i][0];
            int secondIndex = queries[i][1];
            if(firstIndex == secondIndex) {
                sum =  sum + nums[firstIndex] + nums [secondIndex];
            } else {
                for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                    sum = sum + nums[j];

                }
            }
            System.out.println(sum);
            resultArray[i] = sum;
            sum =0;
        }
        for(int j =0 ;j<resultArray.length;j++) {
            total = total + resultArray[j];
        }

        int value = (int)Math.floorMod(total, mod);
        System.out.println(value);*/
    }

    int sumInRange(int[] nums, int[][] queries) {
        Long solu = 0L;
        long mod = 1000000007L;
        List<Long> test = new ArrayList<>();
        long k = 0L;
        for(int i = 0; i<nums.length; i++){
            k += nums[i];
            test.add(k);
        }
        for(int i = 0; i < queries.length; i++){
            if(queries[i][0] == 0){
                solu += test.get(queries[i][1]);
            }
            else{
                solu += test.get(queries[i][1]) - test.get(queries[i][0] - 1);
            }
        }
        return (int)Math.floorMod(solu, mod);
    }
}