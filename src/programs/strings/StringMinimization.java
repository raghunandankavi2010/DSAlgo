package programs.strings;

import java.util.Scanner;

/**
 *  Test Programs for coding round in mtap
 */
public class StringMinimization {

    public static void main(String[] args) {
        findCount();
        minimization();
        validateString();
    }

    private static void minimization() {
        String s = "aabcccabba";

        int mid = s.length() / 2; //get the middle of the String

        String[] parts = {s.substring(0, mid), s.substring(mid)};
        String part1 = parts[0];
        String part2 = parts[1];

        while (part1.length() > 0 && part2.length() > 0 && part2.charAt(part2.length() - 1) == part1.charAt(0)) {
            char toRemove = part2.charAt(part2.length() - 1);
            while (part2.length() > 0 && part2.charAt(part2.length() - 1) == toRemove) {
                part2 = part2.substring(0, (part2.length() - 1));
            }
            while (part1.length() > 0 && part1.charAt(0) == toRemove) {
                part1 = part1.substring(1);
            }
        }

        System.out.println(part2 + part1);
    }

    private static void findCount() {
        String input = "aZ$6";
        findLength(input);
    }

    public static void findLength(String input) {
        char[] arr = input.toCharArray();
        int numbersCount = 0;
        int alphabetsCount = 0;
        for (Character ch : arr) {
            if (Character.isAlphabetic(ch)) {
                alphabetsCount++;
            } else if (Character.isDigit(ch)) {
                numbersCount++;
            }
        }
        System.out.println(alphabetsCount + " " + numbersCount);
    }

    static class AlphaNumbericException extends Exception {
        public AlphaNumbericException(String s) {
            super(s);
        }
    }

    static class StringException extends Exception {
        public StringException(String s) {
            super(s);
        }
    }

    static class Validator {

        public boolean isValid(String inputValidate) throws AlphaNumbericException, StringException {

            boolean isInteger = false;
            boolean isString = false;
            char[] arr = inputValidate.toCharArray();
            for (Character ch : arr) {
                if (Character.isAlphabetic(ch)) {
                    isString = true;
                } else if (Character.isDigit(ch)) {
                    isInteger = true;
                }
            }

            if (isInteger && !isString) {
                return true;
            } else if (isString && !isInteger) {
                throw new StringException("Its a String");
            } else if (isString) {
                throw new AlphaNumbericException("Its an Alphanumeric");
            }
            return false;
        }
    }

    public static void validateString() {
        Scanner s = new Scanner(System.in);
        int numberOfWords = Integer.parseInt(s.nextLine());// Reading input from STDIN
        Validator validator = new StringMinimization.Validator();
        for (int i = 0; i < numberOfWords; i++) {
            String input = s.nextLine();
            try {
                if (validator.isValid(input)) {
                    System.out.println("Valid Format");
                }
            } catch (StringException | AlphaNumbericException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
