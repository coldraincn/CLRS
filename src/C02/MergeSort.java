package C02;

/**
 * Created by hd on 2017/1/4.
 */
public class MergeSort {
    public static void sort(Comparable[] A,int p,int r){
        if(p<r){
            int q=(p+r)/2;
            sort(A,p,q);
            sort(A,q+1,r);
            Merge.merge(A,p,q,r);
        }

    }
    public static void main(String[] args) {

        Integer[] a={6,3,2,5,4,7,9,7};
        // Integer[] a={6,3,2};
        sort(a,0,7);
        Common.show(a);
    }

}
