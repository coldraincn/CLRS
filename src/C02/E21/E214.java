package C02.E21;

/**
 * Created by hd on 2017/1/3.
 */
public class E214 {
    //a.length==b.length==n
    public static int[] BinaryAdd(int[] a,int[] b){
        int n=a.length;
        int[] c=new int[n+1];
        int next=0;

        while (n>0){
            int sum=a[n-1]+b[n-1]+next;
            c[n]=sum%2;
            next=sum/2;

            n--;
        }
        c[n]=next;
        return c;
    }
    public static void main(String[] args) {


        int[] a={1,1};
        int[] b={1,1};

        int[] v=BinaryAdd(a,b);
        for (int v1:v){
            System.out.println(v1);
        }

    }
}
