public class StringCompression {
    

    public static void main(String[] args) {
        String s="aaabbbbbbbbbbbbbbbcccc";
        System.out.println(compress(s));;
    }

    public static String compress(String org){
        if (org.isEmpty()) {
            return "";
        }
        StringBuilder com=new StringBuilder();
        int c=1;
        for(int i=1;i<org.length();i++){
            if(org.charAt(i)==org.charAt(i-1)) c++;
            else{
                com.append(org.charAt(i-1));
                com.append(c);
                c=1;
            }
        }
        com.append(org.charAt(org.length()-1));
        com.append(c);
        if (org.length()>=com.length()) {
            return com.toString();
        }else return org;
    }
}
