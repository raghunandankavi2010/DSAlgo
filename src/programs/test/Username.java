package programs.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Username {
    public static boolean validate(String username) {
        String regex = "^(?!\\d)(?!.*-.*-)(?!.*-$)(?!-)[a-zA-Z0-9-]{6,16}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(validate("Mike-Standish")); // Valid username
        System.out.println(validate("Mike Standish")); // Invalid username
    }
}