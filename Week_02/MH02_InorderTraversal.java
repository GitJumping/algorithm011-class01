package Week_02;

import java.util.ArrayList;
import java.util.List;

public class MH02_InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootRight = new TreeNode(2);
        root.right = rootRight;
        TreeNode secondLeft = new TreeNode(3);
        rootRight.left = secondLeft;


        MH02_InorderTraversal inorderTraversal = new MH02_InorderTraversal();
        List<Integer> list = inorderTraversal.inorderTraversal(root);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        scanNode(root, res);
        return res;
    }

    public void scanNode (TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                scanNode(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                scanNode(root.right, res);
            }
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}