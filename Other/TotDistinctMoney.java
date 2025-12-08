import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class TotDistinctMoney {

    HashSet<Integer> set=new HashSet<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] mat=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=sc.nextInt();
            }
        }
        TotDistinctMoney obj=new TotDistinctMoney();
        obj.helper(mat,0,0,0);
        obj.display();


    }
    void display(){
        int sum=0;
        for(int val:set){
            sum+=val;
        }
        System.out.println(set.size());
        System.out.println(sum);
    }

    void helper(int mat[][],int i, int j,int sum){
        if(i==mat.length-1 && j==mat[0].length-1){
            set.add(sum+mat[i][j]);
        }
        else if(i>=mat.length || j>=mat[0].length)return;
        else{
            sum+=mat[i][j];
            helper(mat,i+1,j,sum);
            helper(mat,i,j+1,sum);
        }

    }

}
