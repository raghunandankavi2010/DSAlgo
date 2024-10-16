package programs.strings;



public class StringReplace {

    public static void main(String[] args) {
        String original = "Raghunandan";
        String replacedString = replaceChar(original);
        System.out.println("Replaced a with * :"+replacedString);
        String source = "Hello World   ".trim();
        source = source.replaceAll("\\s","%20");
        StringBuilder stringBuilder = new StringBuilder();
        char[] sourceChar = source.toCharArray();
        for (char c : sourceChar) {

            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }

        System.out.println(stringBuilder.toString());
        new StringReplace().repalce(sourceChar,source.length());
    }
    // replace every occurrence of a with *
    // if a occurs second time replace with **
    // and so on..
    private static String replaceChar(String original) {
        char[] strChar = original.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char character : strChar) {
            if (character == 'a') {
                count++;
                for (int i = 0; i < count; i++)
                    sb.append("*");
            } else {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    private void repalce(char[] s, int length){
        int spacecount=0,index;

        for(int i=0;i<length;i++){

            if(s[i]== ' '){
                spacecount++;
            }
        }
        index = length+ spacecount *2;

        for(int i = length-1;i>=0;i--){
            if(s[i]== ' '){
                s[index-1]='0';
                s[index-2]='2';
                s[index-3]='%';
                index= index -3;
            }else{
                s[index-1]= s[i];
                index--;
            }
        }

        System.out.println(s);
    }
}
