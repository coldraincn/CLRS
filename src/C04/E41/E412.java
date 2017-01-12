package C04.E41;

import java.util.HashMap;
import java.util.Map;
import static C04.FindMaxmumSubarray.fms;

/**
 * Created by hd on 2017/1/12.
 */
public class E412 {
    public static Map<String,Integer> MaximumSubarrayBruceForce(int[] A){
        Map<String,Integer> result=new HashMap<>();
        int maxSum=Integer.MIN_VALUE;
        int max_left=0;
        int max_right=0;

        for(int i=0;i<A.length;i++){
            int sum=0;
            for(int j=i;j<A.length;j++){

                sum+=A[j];
                if(sum>maxSum){
                    maxSum=sum;
                    max_right=j;
                    max_left=i;
                }
            }
        }
        result.put("max_left",max_left);
        result.put("max_right",max_right);
        result.put("sum",maxSum);
        return result;
    }
    public static void main(String[] args) {
        int[] a={13,-3,-25,-20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,-7};
        //7,10,43

        Map<String,Integer> re2=MaximumSubarrayBruceForce(a);
        System.out.println(re2.get("sum"));
        System.out.println(re2.get("max_right"));
        System.out.println(re2.get("max_left"));
    }


}
