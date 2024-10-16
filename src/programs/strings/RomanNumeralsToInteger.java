package programs.strings;

import java.util.TreeMap;

public class RomanNumeralsToInteger {

    public static void main(String[] args) {
        String s = "XIV";
        RomanNumeralsToInteger romanNumeralsToInteger = new RomanNumeralsToInteger();
        int value = romanNumeralsToInteger.getInteger(s);
        System.out.println(value);

        // Number to Roman Numerals
        // credit https://leetcode.com/problems/integer-to-roman/discuss/775440/Java-Neat-and-clean-solution
        // based on https://www.youtube.com/watch?v=Gw-GNey94j8
        int inputValue = 17;
        String roman = romanNumeralsToInteger.intToRoman(inputValue);
        System.out.println(roman);

        // using tree map
        String output = toRoman(17);
        System.out.println(output);

    }

    private int getInteger(String s){
        char[] arr = s.toCharArray();
        int res = 0;
        for(int i = 0;i < arr.length;i++){
            int value1 = getValue(arr[i]);
            if(i+1 < arr.length){
                int value2 = getValue(arr[i+1]);
                // if values are equal add to result
                if( value1 >= value2){
                    res = res + value1;
                }else {
                    res = res + value2 - value1;
                    // in case values are not equal increment index i
                    i++;
                }
            } else {
                // just one value
                res = res + value1;
                i++;
            }
        }
        return res;
    }

    private static int getValue(Character ch){

        if (ch == 'I')
            return 1;
        if (ch == 'V')
            return 5;
        if (ch == 'X')
            return 10;
        if (ch == 'L')
            return 50;
        if (ch == 'C')
            return 100;
        if (ch == 'D')
            return 500;
        if (ch == 'M')
            return 1000;

        return -1;
    }

    //////

    final static String[] ONES = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    final static String[] TENS = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    final static String[] HUNDREDS = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    final static String[] THOUSANDS = {"","M","MM","MMM"};

    public String intToRoman(int num) {
        int place = 1;
        StringBuilder ans= new StringBuilder();
        while(num>0){
            int rem = num % 10;
            rem *= place;
            ans.insert(0, helper(rem));
            place*= 10;
            num = num / 10;
        }
        return ans.toString();
    }

    String helper(int num){
        if(num < 10) return ONES[num];
        else if(num<100) return TENS[num/10];
        else if(num<1000) return HUNDREDS[num/100];
        else return THOUSANDS[num/1000];
    }

    // Another solution using treemap from stackoverflow
    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static String toRoman(int number) {
        int l = map.floorKey(number); // gives the key closest to the number
        if (number == l) { // in case the key matches number get the value from map
            return map.get(number);
        }
        // else ge the value from map and recursive for number - key
        return map.get(l) + toRoman(number - l);
    }
}
