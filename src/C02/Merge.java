package C02;

import static C02.Common.less;

/**
 * Created by hd on 2017/1/4.
 */
public class Merge {
    public static void merge(Comparable[] A,int p,int q,int r){
        int n1=q-p+1;
        int n2=r-q;
        Comparable[] L=new Comparable[n1+1];
        Comparable[] R=new Comparable[n2+1];
        for(int i=0;i<n1;i++){
            L[i]=A[p+i];
        }
        for(int j=0;j<n2;j++){
            R[j]=A[q+1+j];
        }
        L[n1]=Integer.MAX_VALUE;
        R[n2]=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        for(int k=p;k<r+1;k++){
            if(less(L[i],R[j])){
                A[k]=L[i];
                i++;
            }else{
                A[k]=R[j];
                j++;
            }
        }
    }
    private static void merge(Comparable[] A, Comparable[] aux, int p, int q, int r) {


        // copy to aux[]
        for (int k = p; k <= r; k++) {
            aux[k] = A[k];
        }

        // merge back to a[]
        int i = p, j = q+1;
        for (int k = p; k <= r; k++) {
            if      (i > q)              A[k] = aux[j++];
            else if (j > r)               A[k] = aux[i++];
            else if (less(aux[j], aux[i])) A[k] = aux[j++];
            else                           A[k] = aux[i++];
        }

    }

}
