public class StringRotation {
    public static void main(String[] args) {
        StringBuilder s1=new StringBuilder("abcdeabc");
        StringBuilder s2=new StringBuilder("deabcabc");
        System.out.println(isStrRot(s1,s2));

    }

    public static boolean isSubstring(StringBuilder str,StringBuilder sub){
        return str.toString().contains(sub.toString());
    }

    // public static boolean strRot(StringBuilder s1,StringBuilder s2){
    //     if (s1.length()!=s2.length()) {
    //         return false;
    //     }
    //     StringBuilder str=new StringBuilder();
    //     int j=0;
    //     for(int i=0;i<s2.length();i++){
    //         if (s1.charAt(j)==s2.charAt(i)) {
    //             str.append(s2.charAt(i));
    //             j++;
    //         }else{
    //             j=0;
    //             i--;
    //             str=new StringBuilder();
    //         }
    //     }

    //     int l=str.length();
    //     int sl=s1.length();
    //     StringBuilder x=new StringBuilder(s2.substring(0,sl-l));
    //     return isSubstring(s1, x);
    // }

    public static boolean isStrRot(StringBuilder s1,StringBuilder s2){
        StringBuilder con=s1.append(s1);
        return isSubstring(con, s2);
    }
    
}
