package C04;

/**
 * Created by hd on 2017/1/30.
 */
public class Common {
    public static int[][] SquareMatrixCopy(int[][] A,int row1,int row2,int column1,int column2){
        int n=row2-row1+1;
        int m=column2-column1+1;
        int[][] C=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                C[i][j]=A[row1+i][column1+j];
            }
        }
        return C;
    }
}
