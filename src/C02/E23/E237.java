package C02.E23;

import C02.Common;
import C02.MergeSort;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by hd on 2017/1/6.
 */
public class E237 {
    public static boolean SumSearch(Integer[] S,int x){
        int n=S.length;
        Integer[] S1=new Integer[n];
        for(int i=0;i<n;i++){//////------n
            S1[i]=x-S[i];
        }
        MergeSort.mergesort(S1);//////-----nlgn
        for(int i=0;i<n;i++){///////------n
            int key=S[i];
            int j=E235.BinarySearch(S1,0,7,key);//-------lgn
            if(j!=-1){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        Integer[] a={6,3,2,5,4,7,9,7};
        // Integer[] a={6,3,2};
        boolean j=SumSearch(a,45);
        System.out.print(j);
    }
}
