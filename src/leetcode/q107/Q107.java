package leetcode.q107;

import java.util.*;


/**
 * @author qin
 * @date 2020-09-06
 */
public class Q107 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        Q107 test = new Q107();
        List<List<Integer>> lists = test.levelOrderBottom(root);
        for (List<Integer> list :
                lists) {
            for (int i :
                    list) {
                System.out.println(i);
            }
        }
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (true) {
            int tempLen = nodeQueue.size();
            if (tempLen == 0) {
                break;
            }

            ArrayList<Integer> tempRes = new ArrayList<>();
            for (int i = 0; i < tempLen; i++) {
                TreeNode curNode = nodeQueue.poll();
                tempRes.add(curNode.val);
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            res.add(tempRes);
        }
        Collections.reverse(res);
        return res;
    }

}
