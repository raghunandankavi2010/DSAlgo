package programs.hackerank;

import java.util.Scanner;

/**
 * Input:
 * s =HelloWorld
 * int start = 3
 * int end = 7
 * Output:
 * loWo
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();

        // with substring
        // System.out.println(S.substring(start,end));

        // without substring
        int begin = 0;
        int ending = S.length()-1;
        for(int i=0;i<start;i++){
            begin = begin +1;
        }
        for(int i=S.length()-1;i>=end;i--){
            ending = ending -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=begin;i<=ending;i++){
        sb.append(S.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
