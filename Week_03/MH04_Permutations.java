package Week_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2020-07-11 first time
 */
public class MH04_Permutations {
    public static void main(String[] args) {
        /*
        分治思想
        1、固定第一位，递归后两位可能的排列
        2、固定前两位，递归后一位的排列
         */
        int[] seq = {1, 2, 3};
        List<ArrayList<Integer>> arrayLists = new MH04_Permutations().permute(seq);
        for (int i = 0; i < arrayLists.size(); i++) {
            System.out.println(arrayLists.get(i));
        }
    }

    public List<ArrayList<Integer>> permute(int[] nums) {
        List<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int length = nums.length;
        _outputDFSArrays(length, list, arrayLists, 0);
        return arrayLists;
    }

    private void _outputDFSArrays(int n, ArrayList<Integer> list,
                                  List<ArrayList<Integer>> arrayLists,
                                  int first) {

        if (first == n) {
//            System.out.println("=="+first);
            //当前层最后一次递归调用结束后，list是动态排序更新后的数组，需要靠背椅一份放到result里面
            //避免被上一级的list覆盖（污染）
//            System.out.println("=="+list);
            arrayLists.add(new ArrayList<>(list));
        }

        /**
         * 迭代数组
         * i=0 0-1
         *     0-2
         */
        for (int i = first; i < n; i++) {
            Collections.swap(list, first, i);
//            System.out.println(i+" "+first +" "+"s p="+list);
            _outputDFSArrays(n, list, arrayLists, first + 1);
            //从深层结点回到浅层结点的时候，需要撤销之前的选择
            Collections.swap(list, first, i);
//            System.out.println(i+" "+first +" "+"s a="+list);
        }
    }
}
