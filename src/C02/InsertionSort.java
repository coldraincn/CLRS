package C02;

/**
 * Created by hd on 2017/1/2.
 */
public class InsertionSort {
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i]=a[j];
        a[j]=t;
    }
    private static void show(Comparable[] a){
        for (int i = 0;i<a.length;i++){
            System.out.println(a[i]+" ");

        }

    }
    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }

        }
        return true;
    }

    public static void sort(Comparable[] a){
        for (int i=1;i<a.length;i++){

            for(int j=i;j>0;j--){
                if(less(a[j],a[j-1])){
                    exch(a,j,j-1);

                }
            }
        }

    }
    //clrs
    public static void sort2(Comparable[] a){
        for (int j=1;j<a.length;j++){
            Comparable key=a[j];
            int i=j-1;
            while (i>=0&&(less(key,a[i]))){
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
        show(a);
    }

}