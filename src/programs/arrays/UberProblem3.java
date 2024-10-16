package programs.arrays;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence. Your algorithm should run in O(n) complexity.
 */
public class UberProblem3 {
    private static int longCount = 0;
    public static void main(String[] args) {
        int[] arr = {5,3,20,1,2,3,4};
        int count = 0;
        for(int i=0; i<arr.length-1; i++){
                int j = i + 1;
                int first = arr[i];
                int second = arr[j];
                if(first+1 == second){
                    count++;
                }else{
                    count = 0;
                }
                longCount =  Math.max(longCount,count);

        }
        if(longCount!=0) {
            longCount = longCount + 1;
        }
        System.out.println(longCount);
    }
}
