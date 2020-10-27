package leetcode.q144;

import java.util.*;

/**
 * @author qin
 * @date 2020-10-27
 */
public class Q144 {

    private List<Integer> ans = new ArrayList<>();

    private void recursionPre(TreeNode root){
        if(root!=null){
            ans.add(root.val);
        }
        if(root.left!=null){
            recursionPre(root.left);
        }
        if(root.right!=null){
            recursionPre(root.right);
        }
    }

    private Stack<TreeNode> treeNodeStack = new Stack<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        //recursion
        //recursionPre(root);

        TreeNode curNode = root;
        //iteration
        while (true) {
            while (curNode != null) {
                ans.add(curNode.val);
                if (curNode.right != null) {
                    treeNodeStack.add(curNode.right);
                }
                curNode = curNode.left;
            }
            if (!treeNodeStack.empty()) {
                curNode = treeNodeStack.pop();
            }else{
                break;
            }
        }
        return ans;
    }
}
