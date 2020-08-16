package Week_08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MH03_Merge {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if (intervals.length == 0) {
            return list.toArray(new int[list.size()][]);
        }
        Arrays.sort(intervals, (nums1, nums2) -> nums1[0] - nums2[0]);
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                int[] nums = {left, right};
                list.add(nums);
                left = intervals[i][0];
                right = intervals[i][1];
            } else if (intervals[i][1]>right){
                right = intervals[i][1];
            }
        }
        int[] nums = {left, right};
        list.add(nums);
        return list.toArray(new int[list.size()][]);
    }
}
