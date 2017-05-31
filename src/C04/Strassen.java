package C04;

/**
 * Created by hd on 2017/5/31.
 */
public class Strassen {

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

    public static int[][] strassenMatrixMultiplyRecursive(int A[][], int B[][]) {
        int n = A.length;
        int C[][] = new int[n][n];
        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            int A11[][], A12[][], A21[][], A22[][];
            int B11[][], B12[][], B21[][], B22[][];
            int C11[][], C12[][], C21[][], C22[][];
            int S1[][], S2[][], S3[][], S4[][], S5[][], S6[][], S7[][], S8[][], S9[][], S10[][];
            int P1[][], P2[][], P3[][], P4[][], P5[][], P6[][], P7[][];

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

            S1 = new int[n/2][n/2];S2 = new int[n/2][n/2];S3 = new int[n/2][n/2];S4 = new int[n/2][n/2];
            S5 = new int[n/2][n/2];S6 = new int[n/2][n/2];S7 = new int[n/2][n/2];S8 = new int[n/2][n/2];
            S9 = new int[n/2][n/2];S10 = new int[n/2][n/2];
            squareMatrixSub(B12, B22, S1);squareMatrixAdd(A11, A12, S2);squareMatrixAdd(A21, A22, S3);
            squareMatrixSub(B21, B11, S4);squareMatrixAdd(A11, A22, S5);squareMatrixAdd(B11, B22, S6);
            squareMatrixSub(A12, A22, S7);squareMatrixAdd(B21, B22, S8);squareMatrixSub(A11, A21, S9);
            squareMatrixAdd(B11, B12, S10);

            P1 = new int[n/2][n/2];P2 = new int[n/2][n/2];P3 = new int[n/2][n/2];P4 = new int[n/2][n/2];
            P5 = new int[n/2][n/2];P6 = new int[n/2][n/2];P7 = new int[n/2][n/2];
            P1 = strassenMatrixMultiplyRecursive(A11, S1);
            P2 = strassenMatrixMultiplyRecursive(S2, B22);
            P3 = strassenMatrixMultiplyRecursive(S3, B11);
            P4 = strassenMatrixMultiplyRecursive(A22, S4);
            P5 = strassenMatrixMultiplyRecursive(S5, S6);
            P6 = strassenMatrixMultiplyRecursive(S7, S8);
            P7 = strassenMatrixMultiplyRecursive(S9, S10);

            C11 = new int[n/2][n/2];C12 = new int[n/2][n/2];C21 = new int[n/2][n/2];C22 = new int[n/2][n/2];
            int temp[][] = new int[n/2][n/2];
            squareMatrixAdd(P5, P4, temp);
            squareMatrixSub(temp, P2, temp);
            squareMatrixAdd(temp, P6, C11);

            squareMatrixAdd(P1, P2, C12);
            squareMatrixAdd(P3, P4, C21);

            squareMatrixAdd(P5, P1, temp);
            squareMatrixSub(temp, P3, temp);
            squareMatrixSub(temp, P7, C22);

            copyFromMatrixArray(C, 0, 0, n/2, n/2, C11);
            copyFromMatrixArray(C, 0, n/2, n/2, n/2, C12);
            copyFromMatrixArray(C, n/2, 0, n/2, n/2, C21);
            copyFromMatrixArray(C, n/2, n/2, n/2, n/2, C22);
        }

        return C;
    }
    public static int sMatrixA[][] = new int[][] {
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8},
    };

    public static int sMatrixB[][] = new int[][] {
            {5, 6, 7, 8, 1, 2, 3, 4},
            {5, 6, 7, 8, 1, 2, 3, 4},
            {5, 6, 7, 8, 1, 2, 3, 4},
            {5, 6, 7, 8, 1, 2, 3, 4},
            {5, 6, 7, 8, 1, 2, 3, 4},
            {5, 6, 7, 8, 1, 2, 3, 4},
            {5, 6, 7, 8, 1, 2, 3, 4},
            {5, 6, 7, 8, 1, 2, 3, 4},
    };

    public static void main(String[] args) {

        System.out.println("\n Strassen 递归矩阵乘法");
        int C[][] = strassenMatrixMultiplyRecursive(sMatrixA, sMatrixB);
        displaySquare(C);
    }
}
