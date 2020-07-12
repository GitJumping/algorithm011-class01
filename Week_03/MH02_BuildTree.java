package Week_03;

import java.util.HashMap;
import java.util.Map;

public class MH02_BuildTree {
    public static void main(String[] args) {
        /*
        前序 [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
        中序 [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
        同一颗子树的前序遍历和中序遍历的长度显然是相同的，只是顺序不同而已
         */

        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        MH02_TreeNode node = new MH02_BuildTree().buildTree(preOrder, inOrder);
    }

    public MH02_TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        for(int num = 0; num< inorder.length; num++){
//            integerMap.put(num, inorder[num]);
            integerMap.put(inorder[num], num);
        }

        /*
        //前序的第一个值就是整棵树的根节点
        MH02_TreeNode root = new MH02_TreeNode(preorder[0]);
        //根节点在中序遍历的位置
        int index4Inorder = integerMap.get(preorder[0]);
        //获取中序遍历里左子树节点数
        int leftChildNum4Inorder = inorder.length - index4Inorder;
        //前序遍历第二个节点一定是根节点的左儿子
        MH02_TreeNode rootLeft = new MH02_TreeNode(preorder[1]);
        root.left = rootLeft;

        //左子树根节点在中序遍历的位置
        int index4InorderLeftRoot = integerMap.get(preorder[1]);
        //获取左子树子树在中序遍历的节点数
        int leftChildNumSubSubTree4Inorder = leftChildNum4Inorder - index4InorderLeftRoot;
        MH02_TreeNode subTreeLeft = new MH02_TreeNode(preorder[2]);
        rootLeft.left = subTreeLeft;

         */

        return myTree(preorder, inorder,
                0, preorder.length - 1,
                0, inorder.length - 1,
                integerMap);
    }

    /**
     *
     * @param preorder
     *  前序遍历数组，获取根节点的位置
     * @param inorder
     *  中序遍历数组，貌似是没啥用处
     * @param preStart
     *  定位根节点，preStart + 1 和 preStart + leftChildNum4Inorder + 1
     * @param preEnd
     *  前序遍历结束，临界条件判断时使用
     * @param inStart
     *  构建左子树时。不变
     *  构建右子树时，递归定位右子树的根节点 rootIndex4Inorder 和 rootIndex4Inorder + 1
     * @param inEnd
     *  貌似没啥用处
     * @param integerMap
     *  减少遍历前序数组，快速获取根节点下标
     * @return
     */
    private MH02_TreeNode myTree(int[] preorder, int[] inorder,
                                 int preStart, int preEnd,
                                 int inStart, int inEnd,
                                 Map<Integer, Integer> integerMap) {
        //递归到最后起始位置不能超过终止位置
        if (preStart > preEnd) {
            return null;
        }

        MH02_TreeNode root = new MH02_TreeNode(preorder[preStart]);
        int rootIndex4Inorder = integerMap.get(preorder[preStart]);
        //获取中序遍历里左子树节点数
        //rootIndex4Inorder -> 构建左右子树递归中发生变化，层级越深，越小
        //inStart -> 右子树时不停变化
        int leftChildNum4Inorder = rootIndex4Inorder - inStart;
        //左子树就是前序遍历的第二元素，到第二元素+中序遍历获取的左子树节点数
        root.left = myTree(preorder, inorder, preStart + 1, preStart + leftChildNum4Inorder,
                inStart, rootIndex4Inorder - 1, integerMap);
        //右子树是前序遍历第二元素+中序遍历获取的左子树节点数的下一元素
        root.right = myTree(preorder, inorder, preStart + leftChildNum4Inorder + 1, preEnd,
                rootIndex4Inorder + 1, inEnd, integerMap);
        return root;
    }

}

class MH02_TreeNode {
    int val;
    MH02_TreeNode left;
    MH02_TreeNode right;
    MH02_TreeNode(int x) { val = x; }
}