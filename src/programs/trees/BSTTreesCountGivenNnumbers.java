package programs.trees;

/**
 * https://www.youtube.com/watch?v=GgP75HAvrlY
 *
 */
public class BSTTreesCountGivenNnumbers {

    public static void main(String[] args){
        int n=3;
        int count = findCount(n);
        System.out.println(count);
    }

    private static int findCount(int n) {
        int[] G = new int[n + 1]; // n+1 to accommodate 0 sub problem
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <=n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

}
