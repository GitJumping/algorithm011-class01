package Week_07;

import java.util.ArrayList;

/**
 * 爬楼梯，回溯法求解
 */
public class SH01_ClimbStairs {

    public static void main(String[] args) {
        SH01_ClimbStairs sh01_climbStairs=new SH01_ClimbStairs();
        sh01_climbStairs.climbStairs(0);
    }

    //楼梯总数为N阶
    int starisNum = 5;
    //总共有1步，2步，3步这几种跨法
    int[] ways = {1, 2};
    //统计总共有多少种跨法
    int count = 0;

    //记录每次的具体步数
    ArrayList<Integer> list = new ArrayList<Integer>();

    public void climbStairs(int tempSteps) {
        if (tempSteps > starisNum)
            return;
        //达到要求了，计数加一，并输出具体的步数
        if (tempSteps == starisNum) {
            count++;
            System.out.println(count + " 具体步法为：" + list);
            return;
        }

        //到达一个状态时，都先尝试走下所有的分支可能，然后再依次回退，这样就可以回溯遍历所有的可能了
        for (int i = 0; i < ways.length; i++) {
            list.add(ways[i]);
            tempSteps += ways[i];
            climbStairs(tempSteps);
            tempSteps -= ways[i];
            list.remove(list.size() - 1);
        }
    }
}
