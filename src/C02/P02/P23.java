package C02.P02;

import C02.Common;

/**
 * Created by hd on 2017/1/7.
 */
public class P23 {
    public static double Horner(double[] a,double x){
        double y=0;
        for(int i=a.length-1;i>=0;i--){

            y=a[i]+x*y;
        }
        return y;
    }
    public static double NativePolynomialEvaluation(double[] a,double x){
        double y=0;
        for(int i=0;i<a.length;i++){
            double k=1;
            for(int j=1;j<=i;j++){
                k=k*x;
            }
            y=a[i]*k+y;
        }
        return y;
    }
    public static void main(String[] args) {

        double[] a={2,2,2};
        // Integer[] a={6,3,2};
        double y=Horner(a,2);
        System.out.print(y);
    }
}

/**
 * a,O(n)
 * b,O(n^2)
 */
