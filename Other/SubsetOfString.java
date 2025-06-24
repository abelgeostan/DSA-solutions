

import java.util.ArrayList;
import java.util.List;

public class SubsetOfString {
    public static void main(String[] args) {
        String str="ABCDE";
        findSubset(str,"");
    }



    static void findSubset(String string, String str){
        if (string.equals("")) {
            System.out.println(str);
            return;
        }else{
            for(int i=0;i<string.length();i++){
                if (string.length()==1) {
                    findSubset("", str+string.charAt(i));
                }else{
                    findSubset(string.substring(i+1), str+string.charAt(i));
                }
                
            }
            System.out.println(str);
        }
    }

}

