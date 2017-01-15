package C04.E41;

import java.util.HashMap;
import java.util.Map;

import static C04.FindMaxmumSubarray.fms;

/**
 * Created by hd on 2017/1/14.
 * 检查全是负数情况
 */
public class E415 {
    public static Map<String,Integer> MaximumSubarrayLine(int[] A){

        Map<String,Integer> result=new HashMap<>();
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        int max_left=0;
        int max_right=0;
        int left=0;
        for(int j=0;j<A.length;j++){
            sum+=A[j];
            if(maxSum<sum){
                maxSum=sum;
                max_right=j;
                max_left=left;
            }else if(sum<0){
                sum=0;
                left=j+1;
            }

        }
        result.put("max_left",max_left);
        result.put("max_right",max_right);
        result.put("sum",maxSum);
        return result;

    }
    public static void main(String[] args) {

        int[] a={13,-3,-25,-20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,-7};
        // Integer[] a={6,3,2};
        Map<String,Integer> re=MaximumSubarrayLine(a);
        System.out.println(re.get("sum"));
        System.out.println(re.get("max_left"));
        System.out.println(re.get("max_right"));



    }
}
