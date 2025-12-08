import java.util.Scanner;

public class PalPermutation {
    public static void main(String[] args) {

        String[] testCases = {
                "Tact Coa",          // typical valid case
                "hello",             // not a palindrome permutation
                "race car",          // valid with space
                "aabbcc",            // all even
                "aabbccd",           // one odd
                "aabbccdde",         // one odd with more chars
                "abcdef",            // all unique
                "Was it a rat I saw",// sentence case
                "",                  // empty string (edge case)
                "a",                 // single character (edge case)
                "aa",                // two same characters
                "ab",                // two different characters
                "   ",               // only spaces (edge case)
                "A man a plan a canal Panama" // long sentence
        };

        System.out.println("Testing Palindrome Permutation:\n");

        for (String test : testCases) {
            boolean result = isPal(test);
            System.out.println("Input: \"" + test + "\"  --> Output: " + result);
        }
    }
    static boolean isPal(String str){
        str = str.toLowerCase();
        int[] map=new int[26];
        for(char c:str.toCharArray()){
            if(c==' ')continue;
            map[c-'a']++;
        }
        boolean oneEven=false;
        for(int i=0;i<26;i++){
            if(map[i]%2!=0){
                if(oneEven)return false;
                else oneEven=true;
            }
        }
        return true;
    }
}
