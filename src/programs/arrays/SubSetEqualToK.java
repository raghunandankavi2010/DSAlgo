package programs.arrays;

import java.util.Stack;

public class SubSetEqualToK{
    private static final int[] DATA = { 1,2,3,4,5 };
    /** Set a value for target sum */
    public static final int TARGET_SUM = 5;

    private final Stack<Integer> stack = new Stack<>();

    /** Store the sum of current elements stored in stack */
    private int sumInStack = 0;

    public void populateSubset(int[] data, int fromIndex, int endIndex) {
        if (sumInStack == TARGET_SUM) {
            print(stack);
        }
        for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++) {

            if (sumInStack + data[currentIndex] <= TARGET_SUM) {
                stack.push(data[currentIndex]);
                sumInStack += data[currentIndex];

                populateSubset(data, currentIndex + 1, endIndex);
                sumInStack -=  stack.pop();
            }
        }
    }


    private void print(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        sb.append(TARGET_SUM).append(" = ");
        for (Integer i : stack) {
            sb.append(i).append("+");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }

    public static void main(String[] args) {
        SubSetEqualToK get = new SubSetEqualToK();
        get.populateSubset(DATA, 0, DATA.length);
    }
}