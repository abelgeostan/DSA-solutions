import java.util.Scanner;

public class ProjectWeek {
    public static void main(String[] args) {
        System.out.println("--- Testing weekly(int n, int[] proj) ---");

        // Test Cases structured as: {N, [MODULES], EXPECTED_RESULT}
        Object[][] testCases = {
            // 1. Balanced Case: M_max <= M_other (Result should be M_total)
            {"Test 1: Perfectly Balanced", 4, new int[]{2, 2, 2, 2}, 8},
            {"Test 2: Sufficient Buffer", 3, new int[]{5, 3, 2}, 10}, // M_max=5, M_other=5, M_total=10 -> 10

            // 2. Imbalanced Case: M_max > M_other (Result should be 2*M_other + 1)
            {"Test 3: High Imbalance", 3, new int[]{10, 1, 1}, 5},   // M_max=10, M_other=2. Result: 2*2+1 = 5. (ERROR IN MY COMMENT, THE CALC IS: 2*2+1 = 5)
            {"Test 4: Mild Imbalance", 4, new int[]{5, 1, 1, 1}, 7},  // M_max=5, M_other=3. Result: 2*3+1 = 7.
            {"Test 5: Imbalance Example", 3, new int[]{5, 1, 2}, 7},  // M_max=5, M_other=3. Result: 2*3+1 = 7.

            // 3. Edge Cases
            {"Test 6: Single Project", 1, new int[]{5}, 1},         // M_max=5, M_other=0. Result: 2*0+1 = 1.
            {"Test 7: Empty Projects (N=0)", 0, new int[]{}, 0},      // N=0. Result: 0.
            {"Test 8: Projects with Zero Modules", 3, new int[]{0, 5, 0}, 1}, // M_max=5, M_other=0. Result: 2*0+1 = 1.
            {"Test 9: All Zero Modules", 3, new int[]{0, 0, 0}, 0},    // M_total=0. Result: 0.
            {"Test 10: Two Projects, One Module Difference", 2, new int[]{5, 4}, 9}, // M_max=5, M_other=4. Result: 2*4+1 = 9. (Should alternate till all 9 modules are done)
        };

        boolean allPassed = true;

        for (int i = 0; i < testCases.length; i++) {
            String name = (String) testCases[i][0];
            int N = (int) testCases[i][1];
            int[] PROJ = (int[]) testCases[i][2];
            int expected = (int) testCases[i][3];

            // Handle the empty array case explicitly for clarity
            int actual = (N == 0) ? weekly(N, null) : weekly(N, PROJ);

            String result = (actual == expected) ? "PASS" : "FAIL";

            if (!result.equals("PASS")) {
                allPassed = false;
            }

            // Print the result for the user
            System.out.printf("[%s] %s (Modules: %s)\n", result, name, java.util.Arrays.toString(PROJ));
            System.out.printf("   Expected: %d, Actual: %d\n", expected, actual);
        }

        // Final summary
        System.out.println("\n--- Summary ---");
        if (allPassed) {
            System.out.println("✅ All tests passed successfully!");
        } else {
            System.out.println("❌ Some tests failed. Please review your implementation.");
        }
    }

    public static int weekly(int n, int[] proj){
        int max=0;
        int tot=0;
        for(int i=0;i<n;i++){
            max=Math.max(max, proj[i]);
            tot+=proj[i];
        }
        int other=tot-max;
        if(max<=other){
            return tot;
        }else{
            return 2*other+1;
        }
    }
}
