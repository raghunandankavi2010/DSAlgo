package programs.hackerank;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeConversion {

    /**
     * Complete the timeConversion function below.
     */
    private static String timeConversion(String s) {

        DateFormat df = new SimpleDateFormat("hh:mm:ssaa");
        //Desired format: 24 hour format: Change the pattern as per the need
        DateFormat outputformat = new SimpleDateFormat("HH:mm:ss");
        Date date ;
        String output = null;
        try {
            //Converting the input String to Date
            date = df.parse(s);
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            //Displaying the date

        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return output;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String s = scan.nextLine();

        String result = timeConversion(s);
        System.out.println(result);

    }
}
