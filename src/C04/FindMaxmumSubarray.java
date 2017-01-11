package C04;

import C02.Common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hd on 2017/1/10.
 */
public class FindMaxmumSubarray {
    public static Map<String,Integer> fms(int[] A,int low,int high){
        Map<String,Integer> result=new HashMap<>();

        Map<String,Integer> result_left;
        Map<String,Integer> result_right;
        Map<String,Integer> result_cross;
        if(high==low){
            result.put("max_left",low);
            result.put("max_right",high);
            result.put("sum",A[high]);
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

        int[] a={6,3,-2,5,4,7,9,7};
        // Integer[] a={6,3,2};
        Map<String,Integer> re=fms(a,0,a.length-1);
        System.out.println(re.get("max_right"));

    }
}
