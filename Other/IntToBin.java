

public class IntToBin {
    public static void main(String[] args) {
        String st="";
        
        System.out.println(new StringBuilder(toBin(11, st)).reverse().toString());
    }

    static String toBin(int num, String bin){
        if (num<1) {
            return bin;
        }
        bin=bin+num%2;
        bin=toBin(num/2, bin);
        return bin;


    }
}
