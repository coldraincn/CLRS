package C02.P02;

import C02.Common;
import C02.Merge;

import static C02.Common.less;

/**
 * Created by hd on 2017/1/8.
 * a,(1，5)  (2,5) (3,5) (4,5),(3,4)
 * b,降序，n(n-1)/2
 * c,没有逆序对，时间为n，最大逆序对，时间为n^2
 */
public class P24 {
    public static int Inversions(Comparable[] A,int p,int q,int r){
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
        int count=0;
        for(int k=p;k<r+1;k++){
            if(less(L[i],R[j])){
                A[k]=L[i];
                i++;
            }else{
                count+=n1-i;
                A[k]=R[j];
                j++;
            }
        }
        return count;
    }
    public static int sort(Comparable[] A,int p,int r){
        int count=0;
        if(p<r){
            int q=(p+r)/2;
            count+=sort(A,p,q);
            count+=sort(A,q+1,r);
            count+= Inversions(A,p,q,r);
        }
        return count;

    }
    public static int mergesort2(Comparable[] A){
        Comparable[] aux = new Comparable[A.length];
        int p=0;
        int r=A.length-1;
        return sort(A,p,r);
    }
    public static void main(String[] args) {
        // String[] a=In.readString();
        // Sort(a);
        // assert isSorted(a);
        // show(a);
        //Integer[] a={6,3,2,5,4,7,9,7};
        Integer[] a={2,3,8,6,1};
        int i=mergesort2(a);
      System.out.print(i);
    }
}
