package C02.E21;

import C02.Common;

/**
 * Created by hd on 2017/1/3.
 */
public class E213 {
    public static int LinearSearch(Comparable[] A,int v){
        for(int i=0;i<A.length;i++){
            if(A[i].compareTo(v)==0){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {


        Integer[] a={6,3,2,5,4,7,9,7};

        int v=LinearSearch(a,2);
        System.out.println(v);
    }
}
