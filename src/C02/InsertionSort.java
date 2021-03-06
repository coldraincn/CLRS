package C02;

/**
 * Created by hd on 2017/1/2.
 */
public class InsertionSort {


    public static void sort(Comparable[] a){
        for (int i=1;i<a.length;i++){

            for(int j=i;j>0;j--){
                if(Common.less(a[j],a[j-1])){
                    Common.exch(a,j,j-1);

                }
            }
        }

    }
    //clrs
    public static void sort2(Comparable[] a){
        for (int j=1;j<a.length;j++){
            Comparable key=a[j];
            int i=j-1;
            while (i>=0&&(Common.less(key,a[i]))){
                a[i+1]=a[i];
                i--;
            }
            a[i+1]=key;

        }

    }
    public static void main(String[] args) {
       // String[] a=In.readString();
       // Sort(a);
       // assert isSorted(a);
       // show(a);
        Integer[] a={6,3,2,5,4,7,9,7};
       // Integer[] a={6,3,2};
        sort2(a);
        Common.show(a);
    }

}