import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
// import java.lang.String;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        int len=s.length();
        if(s.substring(len-2).equals("AM") && s.substring(0,2).equals("12")){
            return "00"+s.substring(2,len-2);
        }else if(s.substring(len-2).equals("AM")){
            return s.substring(0,len-2);
        }else if(s.substring(len-2).equals("PM") && s.substring(0,2).equals("12")){
            return s.substring(0,len-2);
        }else{
            int hh=Integer.parseInt(s.substring(0,2)) + 12;
            return hh+s.substring(2,len-2);
            
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
