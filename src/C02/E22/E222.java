package C02.E22;

import C02.Common;

/**
 * Created by hd on 2017/1/4.
 */
public class E222 {
    public static void SelectionSort(Comparable[] a){
        for(int i=0;i<a.length-1;i++){
            int min=i;
            for(int j=i+1;j<a.length;j++){
               if(Common.less(a[j],a[min])){
                   min=j;
               }
            }
            Common.exch(a,i,min);
        }
    }
    public static void main(String[] args) {

        Integer[] a={6,3,2,5,4,7,9,7};
        // Integer[] a={6,3,2};
        SelectionSort(a);
        Common.show(a);
    }
}
