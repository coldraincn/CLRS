package C02.E23;

import C02.Common;
import C02.MergeSort;

/**
 * Created by hd on 2017/1/5.
 */
public class E235 {
    //12345678
    public static int BinarySearch(Comparable[] A,int p,int r,Comparable key){
        int q=(p+r)/2;

        if(p<=r) {
            if (A[q].compareTo(key) == 0) {
                return q;
            }
            if (A[q].compareTo(key) < 0) {
                return  BinarySearch(A, q + 1, r, key);
            }
            if (A[q].compareTo(key) > 0){
                return BinarySearch(A, p, q - 1, key);
            }
        }
       return -1;
    }
    public static int BinarySearch2(Comparable[] A,Comparable key){
        int p=0;
        int r=A.length-1;

        while(p<=r) {
            int q=p+(r-p)/2;
            if (A[q].compareTo(key) == 0) {
                return q;
            }
            if (A[q].compareTo(key) < 0) {
                p=q+1;
            }else if (A[q].compareTo(key) > 0){
                r=q-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Integer[] a={6,3,2,5,4,7,9,7};
        Integer[] b={1,2,3,4,5,6,7,8};
        // Integer[] a={6,3,2};
       MergeSort.sort(a,0,7);
        int i=BinarySearch(a,0,7,4);
        System.out.println(i);
       Common.show(a);
    }
}
