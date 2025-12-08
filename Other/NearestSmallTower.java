import java.util.Arrays;

public class NearestSmallTower {
    public static void main(String[] args) {
        // Create an instance of the class to call the non-static method
        // TODO: Change 'TowerFinder' to your class name if it's different
        NearestSmallTower finder = new NearestSmallTower();

        // --- Define Test Cases ---
        // We store all test inputs in one array
        int[][] testCases = {
            {1, 3, 2},             // Example 1
            {4, 8, 3, 5, 3},       // Example 2
            {},                    // Test 3: Empty array
            {5},                   // Test 4: Single element
            {5, 5, 5},             // Test 5: All same height
            {1, 2, 3, 4, 5},       // Test 6: Ascending order
            {5, 4, 3, 2, 1},       // Test 7: Descending order
            {6, 2, 5, 4, 5, 1, 6}  // Test 8: Complex case
        };

        // --- Define Expected Results ---
        // These strings must match the output of Arrays.toString(result)
        String[] expectedResults = {
            "[-1, 0, 0]",
            "[2, 2, -1, 2, -1]",
            "[]",
            "[-1]",
            "[-1, -1, -1]",
            "[-1, 0, 1, 2, 3]",
            "[1, 2, 3, 4, -1]",
            "[1, 5, 1, 5, 5, -1, 5]"
        };

        System.out.println("Running Nearest Smaller Tower Tests...");
        System.out.println("=====================================");

        int passedCount = 0;
        
        // --- Loop Through and Run All Tests ---
        for (int i = 0; i < testCases.length; i++) {
            int[] input = testCases[i];
            String expected = expectedResults[i];
            
            // Call your method
            int[] output = finder.nearestSmall(input);
            
            // Format for comparison
            String outputStr = Arrays.toString(output);
            String inputStr = Arrays.toString(input);

            System.out.println("--- Test Case " + (i + 1) + " ---");
            System.out.println("Input:    " + inputStr);
            System.out.println("Expected: " + expected);
            System.out.println("Output:   " + outputStr);
            
            // Check if test passed
            if (outputStr.equals(expected)) {
                System.out.println("Result:   PASS ✅");
                passedCount++;
            } else {
                System.out.println("Result:   FAIL ❌");
            }
            System.out.println(); // Add a newline for readability
        }

        System.out.println("=====================================");
        System.out.println("Tests Finished. " + passedCount + " / " + testCases.length + " passed.");
    }

    public int[] nearestSmall(int arr[]){
        int[] res=new int[arr.length];

        for(int i=0;i<arr.length;i++){
            int a=helperLeft(arr,i,i-1);
            int b=helperRight(arr,i,i+1);
            int r=-1;
            if(a==-1 && b==-1)r= -1;
            else if(a==-1)r=b;
            else if(b==-1)r=a;
            else{
            if(i-a<b-i)r= a;
            else if(i-a>b-i)r= b;
            else{
            if(arr[a]<arr[b])r= a;
            else if(arr[a]>arr[b])r= b;
            else r= Math.min(a,b);
            }
            
            
            }
            res[i]=r;
        }
        return res;
    }

    int helperLeft(int[] arr,int i,int c){
        if(c<0 || c>=arr.length){
            return -1;
        }
        if(arr[i]>arr[c]){
            return c;
        }
        return helperLeft(arr, i, c-1);

    }
    int helperRight(int[] arr,int i,int c){
        if(c<0 || c>=arr.length){
            return -1;
        }
        if(arr[i]>arr[c]){
            return c;
        }
        return helperRight(arr, i, c+1);
        
        
    }
}
