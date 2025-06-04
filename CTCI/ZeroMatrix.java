import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZeroMatrix {
    public static void main(String[] args) {
        int [][] mat=new int[3][4];
        mat[0][0] = 1;
        mat[0][1] = 5;
        mat[0][2] = 8; 
        mat[0][3] = 8;

        // Row 1
        mat[1][0] = 0; 
        mat[1][1] = 12;
        mat[1][2] = 7;
        mat[1][3] = 0; 

        // Row 2
        mat[2][0] = 9;
        mat[2][1] = 9; 
        mat[2][2] = 3;
        mat[2][3] = 11;
        zero(mat, 3, 4);

    }

    public static void zero(int [][] mat,int m,int n){
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<m;i++){
            
            for(int j=0;j<n;j++){
                if (mat[i][j]==0) {
                    if(!map.containsKey(i)){
                        map.put(i, new ArrayList<>());
                    }
                    map.get(i).add(j);
                }
            }
        }
        System.out.println(map);

        for(int r:map.keySet()){
            for(int c:map.get(r)){
                for(int i=0;i<m;i++){
                    mat[i][c]=0;
                }
                for(int i=0;i<n;i++){
                    mat[r][i]=0;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

}




