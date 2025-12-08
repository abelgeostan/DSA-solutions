import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EvenOddEvenOdd {
     /**
     * Helper function to check if a number is "even odd special".
     *
     * @param num The number to check.
     * @return true if the number is special, false otherwise.
     */
    private static boolean isSpecial(int num) {
        String s = Integer.toString(num);
        // Single-digit numbers are always special.
        if (s.length() <= 1) {
            return true;
        }
        // Iterate through adjacent digits.
        for (int i = 0; i < s.length() - 1; i++) {
            // Get the parity (0 for even, 1 for odd) of the current and next digit.
            int parity1 = (s.charAt(i) - '0') % 2;
            int parity2 = (s.charAt(i + 1) - '0') % 2;
            // If parities are the same, it's not a special number.
            if (parity1 == parity2) {
                return false;
            }
        }
        return true;
    }

    /**
     * The main function serves as a test harness for the evenOdd logic.
     * It runs a predefined set of test cases and reports the results.
     */
    public static void main(String[] args) {
        // A map to hold our test cases: Input N -> Expected Answer.
        // Using LinkedHashMap to maintain insertion order for clean output.
        Map<Integer, Integer> testCases = new LinkedHashMap<>();
        testCases.put(1, 1);
        testCases.put(9, 9);
        testCases.put(10, 10);
        testCases.put(30, 20);      // Sample case
        testCases.put(87, 48);
        testCases.put(100, 54);
        testCases.put(200, 79);

        System.out.println("🚀 Starting tests for the evenOdd logic...");
        int passed = 0;
        int failed = 0;

        for (Map.Entry<Integer, Integer> testCase : testCases.entrySet()) {
            int n = testCase.getKey();
            int expected = testCase.getValue();
            int actual = evenOdd(n); // Calling the logic to be tested

            System.out.println("----------------------------------------");
            System.out.printf("🧪 Testing for N = %d\n", n);
            System.out.printf("   -> Expected: %d\n", expected);
            System.out.printf("   -> Got: %d\n", actual);

            if (actual == expected) {
                System.out.println("   ✅ Result: PASS");
                passed++;
            } else {
                System.out.println("   ❌ Result: FAIL");
                failed++;
            }
        }
        
        System.out.println("----------------------------------------");
        System.out.println("\n📊 Test Summary:");
        System.out.printf("Total tests: %d | Passed: %d | Failed: %d\n", testCases.size(), passed, failed);
        System.out.println("----------------------------------------");

        // Note: The test case for N = 10^8 is too slow for this brute-force method.
        // It is included here for context and would require an optimized solution to run quickly.
        // Expected answer for N = 100,000,000 is 878,904.
    }



    public static int evenOdd(int n){
        if(n<10)return n;
        int c=9;
        String str=""+n;
        str=str.charAt(0)+"";
        n=n-9;
        if(Integer.parseInt(str)%2==0)c+=(n/2);
        else c+=(n/2)+1;
        return c;
        
    }
    
    
}
