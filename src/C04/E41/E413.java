package C04.E41;

import C04.FindMaxCrossingSubarray;

import java.util.HashMap;
import java.util.Map;

import static C04.E41.E412.MaximumSubarrayBruceForce;
import static C04.FindMaxmumSubarray.fms;

/**
 * Created by hd on 2017/1/13.
 */
public class E413 {
    public static  Map<String,Integer> FindMaximumSubarray(int[] A,int low,int high,int n0) {
        Map<String,Integer> result=new HashMap<>();

        Map<String,Integer> result_left;
        Map<String,Integer> result_right;
        Map<String,Integer> result_cross;
        if(high-low<=n0){
            result=MaximumSubarrayBruceForce(A);
//            result.put("max_left",low);
//            result.put("max_right",high);
//            result.put("sum",A[high]);
            return result;
        }else{
            int mid=(low+high)/2;
            result_left=fms(A,low,mid);
            result_right=fms(A,mid+1,high);
            result_cross=FindMaxCrossingSubarray.fmcs(A,low,mid,high);
            if(result_left.get("sum")>=result_right.get("sum")&&result_left.get("sum")>=result_cross.get("sum")){
                result=result_left;
            }else
            if(result_right.get("sum")>=result_left.get("sum")&&result_right.get("sum")>=result_cross.get("sum")){
                result=result_right;
            }else{
                result=result_cross;
            }
        }
        return  result;

    }
    public static void main(String[] args) {

        int[] a={13,-3,-25,-20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,-7};
        // Integer[] a={6,3,2};
        Map<String,Integer> re=fms(a,0,a.length-1);
        System.out.println(re.get("sum"));
        System.out.println(re.get("max_right"));
        System.out.println(re.get("max_left"));

        Map<String,Integer> re2=FindMaximumSubarray(a,0,a.length-1,3);
        System.out.println(re2.get("sum"));
        System.out.println(re2.get("max_right"));
        System.out.println(re2.get("max_left"));

    }

}
/**
 * 不能改编crossover point；
 */
