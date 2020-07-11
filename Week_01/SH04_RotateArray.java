package Week_01;

public class SH04_RotateArray {
    public static void main(String[] args) {
//        int[] nums = new int[] {1,1,2,3,4,2,3,1,1,2,4,5,6,1,2,-3,3,-4,-4,-8,-8};
        int[] nums = new int[] {5,6,1,2,4,6};
        SH04_RotateArray rotateArray = new SH04_RotateArray();
        rotateArray.rotate(nums, 10);
    }

    public void rotate(int[] nums, int k) {
        int tempNum,lastone;
        //要循环k次
        for(int t=0; t<k;t++){
            //记录数组的最后一个元素
            lastone = nums[nums.length - 1];
            for(int i=0; i<nums.length;i++){
                //记录当前数组元素
                tempNum = nums[i];
                //把前一个数组元素的值赋值给当前
                nums[i] = lastone;
                //把当前数组元素保存，下一次循环赋值给下一个元素
                lastone = tempNum;
//        System.out.println(Arrays.toString(nums));
            }
//        System.out.println("t -> "+t);
        }
    }
}
