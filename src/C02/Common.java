package C02;

/**
 * Created by hd on 2017/1/3.
 */
public class Common {
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    public static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i]=a[j];
        a[j]=t;
    }
    public static void show(Comparable[] a){
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
}
