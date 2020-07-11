package Week_01;

import java.util.Arrays;

public class H03_RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,2,3,4,2,3,1,1,2,4,5,6,1,2,-3,3,-4,-4,-8,-8};
        H03_RemoveDuplicates r = new H03_RemoveDuplicates();
        Arrays.sort(nums);
        System.out.println(r.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        //初始化一个慢指针
        int j = 0;
        for(int i=1; i < nums.length; i++){
            if (nums[j] == nums[i]) {
                /*
                [1,1,1,1,1,2]
                假定数组如上，当j-0与i-4都相等时
                i自增
                 */
            } else if (nums[j] != nums[i]) {
                /*
                当碰到不相等的数，j自加1
                把i下标的数赋值给j，以上面的数组为例，就是2赋值给第二个1
                j对应的数组值为2，从1开始对比i下标对应的值
                 */
                j++;
                nums[j] = nums[i];
            }
        }
        //j是从0开始的
        System.out.println(Arrays.toString(nums));
        return j+1;
    }
}
