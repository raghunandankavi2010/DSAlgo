package programs.strings;

public class StringRotation {

    public static void main(String[] args){
        String test = "abcdefg";
        String rotated = "defgabc";
        checkRotated(test,rotated);
    }

    private static void checkRotated(String test, String rotated) {
        if(test.length()!= rotated.length())
            return;
        char first = test.charAt(0);
        int index = rotated.indexOf(first);
        if(index!=-1) {
            String s1 = rotated.substring(index, rotated.length());
            String s2 = rotated.substring(0, index);
            StringBuilder sb = new StringBuilder(s1.length() + s2.length());
            sb.append(s1);
            sb.append(s2);
            if (test.equals(sb.toString())) {
                System.out.println("Given String is a rotation of original String");
            } else{
                System.out.println("Given String is not a rotation og=f original String");
            }
        }

    }
}
