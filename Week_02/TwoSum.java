package Week_02;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 20-05-07 first time
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] ints = new int[]{2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(ints, 9)));
        System.out.println(Arrays.toString(twoSum.twoSumWithHash(ints, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
//            int iTemp = nums[i];
            for(int j=i+1; j<nums.length; j++){
//                int jVal = nums[j];
//                if (iTemp + jVal == target) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("wrong target num");
    }

    public int[] twoSumWithHash(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
//            hashMap.put(i, nums[i]);
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            //数组中同一个元素不能使用两遍  -->  该目标元素不能是 nums[i]nums[i] 本身
            if (hashMap.containsKey(val) && i != hashMap.get(val)) {
                return new int[]{i, hashMap.get(val)};
            }
        }
        throw new IllegalArgumentException("wrong target num");
    }
}
