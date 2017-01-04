package C02.E23;

import C02.Common;

/**
 * Created by hd on 2017/1/4.
 */
public class E232 {
    public static void merge(Comparable[] A,int p,int q,int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        Comparable[] L = new Comparable[n1];
        Comparable[] R = new Comparable[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + 1 + j];
        }

        int i = 0;
        int j = 0;

          int k=p;

        while (i < n1 && j < n2) {

            if (Common.less(L[i],R[j])) {

                A[k++]=L[i++];

            } else {
                A[k++]=R[j++];
            }
        }

        if (j >=n2 && i < n1) {
            A[k++]=L[i++];
        }

        if (i>=n1&&j < n2) {
            A[k++]=R[j++];
        }

    }
    public static void merge2(Comparable[] A,int p,int q,int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        Comparable[] L = new Comparable[n1];
        Comparable[] R = new Comparable[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + 1 + j];
        }

        for (int i=0, j=0, k = p; k < r + 1; k++) {
            if (i < n1 && j < n2) {
                if (Common.less(L[i], R[j])) {
                    A[k] = L[i];
                    i++;
                    continue;

                } else {
                    A[k] = R[j];
                    j++;
                    continue;

                }
            }

            if (j<n2) {
                A[k] = R[j];
                j++;


            }
            if (i<n1) {
                A[k] = L[i];
                i++;


            }

         }
    }




    public static void sort(Comparable[] A,int p,int r){
        if(p<r){
            int q=(p+r)/2;
            sort(A,p,q);
            sort(A,q+1,r);
            merge2(A,p,q,r);
        }

    }
    public static void main(String[] args) {

        Integer[] a={6,3,2,5,4,7,9,7};
        // Integer[] a={6,3,2};
        sort(a,0,7);
        Common.show(a);
    }

}
