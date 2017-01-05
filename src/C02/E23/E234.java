package C02.E23;

import C02.Common;
import C02.Merge;

/**
 * Created by hd on 2017/1/5.
 */
public class E234 {
    public static void MergeInsetionsort(Comparable[] A,int p,int r){


        if(p<r){

            MergeInsetionsort(A,p,--r);

            Insertion(A, p, r);

        }

    }
    public static void Insertion(Comparable[] A,int p,int r){
            int i=r;
            Comparable key=A[r+1];
            while(i>=p&&Common.less(key,A[i])){
                A[i+1]=A[i];
                i--;
            }
            A[i+1]=key;

    }
    public static void main(String[] args) {

        Integer[] a={6,3,2,5,4,7,9,7};
        // Integer[] a={6,3,2};
        MergeInsetionsort(a,0,7);
        Common.show(a);
    }
}
//T(n)=1   n=1;
//     T(n-1)+n-1 n>1