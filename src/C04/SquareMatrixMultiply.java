package C04;

/**
 * Created by hd on 2017/1/16.
 */
public class SquareMatrixMultiply {
    public static int[][] multiply(int[][] A,int[][] B){
        int n=A.length;
        int[][] C=new int[n][n];
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){

                C[i][j]=0;
                for (int k=0;k<n;k++){
                    C[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
        return C;

    }
    public static void main(String[] args) {

        int[][] a={{1,2},{3,4}};
        int[][] b={{1,2},{3,4}};
        int[][] c=multiply(a,b);
        System.out.println(c[0][0]);
        System.out.println(c[0][1]);
        System.out.println(c[1][0]);
        System.out.println(c[1][1]);

    }
}
