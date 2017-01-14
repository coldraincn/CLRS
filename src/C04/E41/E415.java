package C04.E41;

/**
 * Created by hd on 2017/1/14.
 */
public class E415 {
    public static void MaximumSubarrayLine(int[] A){
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        for(int j=0;j<A.length;j++){
            sum+=A[j];
            if(maxSum<sum){
                maxSum=sum;
            }

        }
    }
}
