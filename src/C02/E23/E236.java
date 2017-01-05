package C02.E23;

import C02.Common;

/**
 * Created by hd on 2017/1/5.
 */
public class E236 {
    public static void InsertionSort(Comparable[] a){
        for (int j=1;j<a.length;j++){
            Comparable key=a[j];
            int i=j-1;
            int k=BinarySearch(a,0,i,key);

            if (k != -1)
            {
                for (int s = i; s>=k ; s--)
                    a[s+1]=a[s];
                a[k]=key;
            }
//            while (i>k){
//                a[i+1]=a[i];
//                i--;
//            }


        }

    }
    public static int BinarySearch(Comparable[] A,int p,int r,Comparable key){
        int q=(p+r)/2;

        if(p<=r) {
            if (A[q].compareTo(key)<=0&&A[q+1].compareTo(key)>=0) {
                return q+1;
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
    public static void main(String[] args) {
        // String[] a=In.readString();
        // Sort(a);
        // assert isSorted(a);
        // show(a);
        Integer[] a={6,3,2,5,4,7,9,7};
        // Integer[] a={6,3,2};
        InsertionSort(a);
        Common.show(a);
    }

}
