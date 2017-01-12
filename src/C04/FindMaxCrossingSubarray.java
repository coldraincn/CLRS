package C04;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hd on 2017/1/10.
 */
public class FindMaxCrossingSubarray {
    public static Map<String,Integer> fmcs(int[] A, int low, int mid, int high){
        Map<String,Integer> result=new HashMap<>();

        int left_sum=Integer.MIN_VALUE;
        int sum=0;
        int max_left=mid;
        for(int i=mid;i>=low;i--){
            sum+=A[i];
            if(sum>left_sum){
                left_sum=sum;
                max_left=i;
            }
        }

        int right_sum=Integer.MIN_VALUE;
        int sum2=0;
        int max_right=mid+1;
        for(int j=mid+1;j<=high;j++){
            sum2+=A[j];
            if(sum2>right_sum){
                right_sum=sum2;
                max_right=j;
            }
        }
        result.put("max_left",max_left);
        result.put("max_right",max_right);
        result.put("sum",left_sum+right_sum);
        return result;
    }
    public static void main(String[] args) {

        int[] a={13,-3,-25,-20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,-7};
        // Integer[] a={6,3,2};
        Map<String,Integer> re=fmcs(a,0,7,a.length-1);
        System.out.println(re.get("max_right"));
        System.out.println(re.get("max_left"));
        System.out.println(Integer.MIN_VALUE);
    }

}
