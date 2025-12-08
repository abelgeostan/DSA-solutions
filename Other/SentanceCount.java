public class SentanceCount {
    public static void main(String[] args) {
        String text = "Hello world! This is a test. How many, sentences.. are here? Let's find out.";
        String text2="Hello! How are you? Last time I saw you… you were nervous.";
        int sentenceCount = countSentences(text2);
        System.out.println("Number of sentences: " + sentenceCount);    
    }

    private static int countSentences(String text) {
        int count=0;
        boolean prevdot=false;
        for(char c:text.toCharArray()){
            if (c=='.') {
                if(prevdot)count--;
                else count++;
                prevdot=true;
            }else if(c=='!'||c=='?'){
                count++;
                prevdot=false;
            }else{
                prevdot=false;
            }
        }
        return count;
    }

}
