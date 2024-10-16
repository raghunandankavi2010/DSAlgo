package programs.hackerank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
       int sumDiagonal =0;
        for(int i=0;i<=arr.size()-1;i++){
            for(int j=0;j<=arr.get(0).size()-1;j++){
                if(i==j)
                    sumDiagonal = sumDiagonal+arr.get(i).get(j);
            }
        }

        System.out.println("Sum Diagonal "+sumDiagonal);
        int sumDiagonalReverse= 0;
        int count = arr.get(0).size()-1;
        for(int i=0;i<=arr.size()-1;i++){
            for(int j=arr.get(0).size()-1;j>=0;j--){
                if(j==count){
                    sumDiagonalReverse = sumDiagonalReverse+arr.get(i).get(j);

                }
            }
            count --;
        }
        System.out.println("Sum Diagonal Reverse "+sumDiagonalReverse);
        return Math.abs(sumDiagonal-sumDiagonalReverse);

    }

}

public class MatrixDiagonalDiff {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/raghu/Desktop/Input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("/home/raghu/Desktop/Output.txt")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
