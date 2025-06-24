

import java.util.ArrayList;
import java.util.List;

public class SubsetOfString {
    public static void main(String[] args) {
        String str="ABCD";
        findSubset(str,"");
    }

    static void subset(String str){
        List<String> list=new ArrayList<>();
        
        for(int i=0;i<str.length();i++){
            list.add(str.charAt(i)+"");
            String ms=""+str.charAt(i);
            for(int j=i+1;j<str.length();j++){
                String s=""+str.charAt(i)+str.charAt(j);
                ms=ms+str.charAt(j);
                if (ms.endsWith(s)) {
                    list.add(s);
                }else{
                    list.add(s);
                    list.add(ms);
                }

            }
        }
        for(String item:list){
            System.out.println(item);
        }

        
        
        

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

