
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static void plusMinus(List<Integer> arr) {
        float pos=0,neg=0,zero=0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)>0){
                pos++;
            }else if(arr.get(i)<0){
                neg++;
            }else{
                zero++;
            }
        }
        System.out.printf("%.6f%n",pos/arr.size());
        System.out.printf("%.6f%n",neg/arr.size());
        System.out.printf("%.6f%n",zero/arr.size());

    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
