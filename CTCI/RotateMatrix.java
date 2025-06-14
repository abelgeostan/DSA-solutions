public class RotateMatrix {
    public static void main(String[] args) {
        
        int n=5;
        int value = 1;
        // int mat[][]=new int[n][n];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         mat[i][j] = value++;
        //     }
        // }

        int[][] mat = {
            { 1,  2,  3,  4,  5},
            { 6,  7,  8,  9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        int rotated[][]=rotate(mat, n);
        System.out.println("Rotated matrix");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(rotated[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] rotate(int mat[][],int n){
        int rot[][]=new int[n][n];
        int k=0,l=0;
        for(int i=0;i<n;i++){

            for(int j=n-1;j>=0;j--){
                rot[k][l]=mat[j][i];
                l++;
            }
            k++;
            l=0;

        }
        

        return rot;
    }
}
