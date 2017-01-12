package C04.E41;

import java.util.Map;

import static C04.FindMaxmumSubarray.fms;

/**
 * Created by hd on 2017/1/12.
 */
public class E411 {
    public static void main(String[] args) {

        int[] a={-13,-3,-25,-20,-3,-16,-23,-18,-20,-7,-12,-5,-22,-15,-4,-7};
        // Integer[] a={6,3,2};
        Map<String,Integer> re=fms(a,0,a.length-1);
        System.out.println(re.get("sum"));
        System.out.println(re.get("max_right"));
        System.out.println(re.get("max_left"));

    }
}
/**
 *
 * 返回最大值
 */

