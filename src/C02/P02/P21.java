package C02.P02;

import C02.Common;
import C02.Merge;

/**
 * Created by hd on 2017/1/7.
 */
public class P21 {
    //clrs{6,3,2,5,4,7,9,7};
    public static void Insertionsort(Comparable[] a,int p,int r){
        for (int j=p+1;j<=r;j++){
            Comparable key=a[j];
            int i=j-1;
            while (i>=p&&(Common.less(key,a[i]))){
                a[i+1]=a[i];
                i--;
            }
            a[i+1]=key;

        }

    }
    public static void sort(Comparable[] A, Comparable[] aux,int p,int r,int k){
        if(r-p<=k){
            Insertionsort(A,p,r);

        }
        if(p<r){
            int q=(p+r)/2;
            sort(A,aux,p,q,k);
            sort(A,aux,q+1,r,k);
            Merge.merge(A,aux,p,q,r);
        }

    }
    public static void mergesort(Comparable[] A,int k){
        Comparable[] aux = new Comparable[A.length];
        int p=0;
        int r=A.length-1;
        sort(A,aux,p,r,k);
    }
    public static void main(String[] args) {

        Integer[] a={6,3,2,5,4,7,9,7};
        // Integer[] a={6,3,2};
        int k=3;
       //Insertionsort(a,2,7);
      mergesort(a,2);
        Common.show(a);
    }
    /**
     * a,O(k^2)*(n/k)=O(nk)
     * b,n/k O(nlog(n/k)=Onlog(n/k)
     * c,nk+nlg(n/k)=nlgn->k=lgn-lg(n/k)
     * d,插入快于并归的最大序列长度
     */
}
