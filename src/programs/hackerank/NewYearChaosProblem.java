package programs.hackerank;

/**
 * https://www.hackerrank.com/challenges/new-year-chaos/problem
 */
public class NewYearChaosProblem {

    // Complete the minimumBribes function below.
    // Solution got from discussion board on the
    // hackerank question page.
    private static void minimumBribes(int[] q) {
        int ans = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) { // 4- (7+1)
                System.out.println("Too Chaotic");
                return;
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i]) ans++;
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
        int[] q = {2, 1, 5, 3, 4};
        minimumBribes(q);
        minimumBribes2(q);
    }

    private static void minimumBribes2(int[] arr) {
        int swapCount =0;
        for(int i= arr.length-1;i>=0;i--){
            if(arr[i]!=(i+1)){
                if((i-1)>=0 && arr[i-1]==(i+1)){
                    swapCount++;
                    swap(arr,i,i-1);
                } else if((i-2)>=0 && arr[i-2]==(i+1)){
                    swapCount += 2;
                    swap(arr,i-2,i-1);
                    swap(arr,i,i-1);
                }else{
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        if(swapCount!=0){
            System.out.println(swapCount);
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i1];
        arr[i1] = arr[i];
        arr[i] = temp;
    }
}