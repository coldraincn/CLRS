package C02.P02;

import C02.Common;

/**
 * Created by hd on 2017/1/7.
 */
public class P22 {
    public static void BubbleSort(Comparable[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = A.length - 1; j > i ; j--) {
                if (Common.less(A[j],A[j-1])) {
                    Common.exch(A,j,j-1);

                }
            }
        }
    }
    public static void main(String[] args) {

        Integer[] a={6,3,2,5,4,7,9,7};
        // Integer[] a={6,3,2};
        BubbleSort(a);
        Common.show(a);
    }
}
/**
 * a,A'[x]=A[y]
 * b,i:j=n,只有一个，是排序好的；m：A[J]-A[N]排好，A[j-1]进行比较，放入到合适位置；t:a[i]为最小，停止
 * c,
 * d，n^2
 */
