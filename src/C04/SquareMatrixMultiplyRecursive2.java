package C04;

/**
 * Created by hd on 2017/5/31.
 */
public class SquareMatrixMultiplyRecursive2 {
    public static void displaySquare(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j : matrix[i]) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void copyToMatrixArray(int srcMatrix[][], int startI, int startJ, int iLen, int jLen,
                                         int destMatrix[][]) {
        for (int i = startI; i < startI + iLen; i++) {
            for (int j = startJ; j < startJ + jLen; j++) {
                destMatrix[i - startI][j - startJ] = srcMatrix[i][j];
            }
        }
    }

    public static void copyFromMatrixArray(int destMatrix[][], int startI, int startJ, int iLen, int jLen,
                                           int srcMatrix[][]) {
        for (int i = 0; i < iLen; i++) {
            for (int j = 0; j < jLen; j++) {
                destMatrix[startI + i][startJ + j] = srcMatrix[i][j];
            }
        }
    }

    public static void squareMatrixAdd(int A[][], int B[][], int C[][]) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
    }

    public static void squareMatrixSub(int A[][], int B[][], int C[][]) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
    }

    public static int[][] squareMatrixMultiplyRecursive(int A[][], int B[][]) {
        int n = A.length;
        int C[][] = new int[n][n];
        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            int A11[][], A12[][], A21[][], A22[][];
            int B11[][], B12[][], B21[][], B22[][];
            int C11[][], C12[][], C21[][], C22[][];

            A11 = new int[n/2][n/2];A12 = new int[n/2][n/2];A21 = new int[n/2][n/2];A22 = new int[n/2][n/2];
            copyToMatrixArray(A, 0, 0, n/2, n/2, A11);
            copyToMatrixArray(A, 0, n/2, n/2, n/2, A12);
            copyToMatrixArray(A, n/2, 0, n/2, n/2, A21);
            copyToMatrixArray(A, n/2, n/2, n/2, n/2, A22);

            B11 = new int[n/2][n/2];B12 = new int[n/2][n/2];B21 = new int[n/2][n/2];B22 = new int[n/2][n/2];
            copyToMatrixArray(B, 0, 0, n/2, n/2, B11);
            copyToMatrixArray(B, 0, n/2, n/2, n/2, B12);
            copyToMatrixArray(B, n/2, 0, n/2, n/2, B21);
            copyToMatrixArray(B, n/2, n/2, n/2, n/2, B22);

            C11 = new int[n/2][n/2];C12 = new int[n/2][n/2];C21 = new int[n/2][n/2];C22 = new int[n/2][n/2];
            squareMatrixAdd(squareMatrixMultiplyRecursive(A11, B11), squareMatrixMultiplyRecursive(A12, B21),
                    C11);
            squareMatrixAdd(squareMatrixMultiplyRecursive(A11, B12), squareMatrixMultiplyRecursive(A12, B22),
                    C12);
            squareMatrixAdd(squareMatrixMultiplyRecursive(A21, B11), squareMatrixMultiplyRecursive(A22, B21),
                    C21);
            squareMatrixAdd(squareMatrixMultiplyRecursive(A21, B12), squareMatrixMultiplyRecursive(A22, B22),
                    C22);
            copyFromMatrixArray(C, 0, 0, n/2, n/2, C11);
            copyFromMatrixArray(C, 0, n/2, n/2, n/2, C12);
            copyFromMatrixArray(C, n/2, 0, n/2, n/2, C21);
            copyFromMatrixArray(C, n/2, n/2, n/2, n/2, C22);
        }

        return C;
    }

}
