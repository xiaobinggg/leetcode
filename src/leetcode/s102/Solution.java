package leetcode.s102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (59.97%)
 * Likes:    332
 * Dislikes: 0
 * Total Accepted:    64.7K
 * Total Submissions: 107.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
 * 分析：
 * 借助一个队列来层次遍历二叉树，代码如下：
 * LinkedList<Node> queue = new LinkedList<Node>();
 * queue.add(root);
 * while (!queue.isEmpty()) {
 *   Node currentNode = queue.poll();
 *   System.out.print(currentNode.getValue() + " ");
 *   if (currentNode.getLeft() != null) {
 *      queue.add(currentNode.getLeft());
 *   }
 *   if (currentNode.getRight() != null) {
 *     queue.add(currentNode.getRight());
 *   }
 * }
 * 要求中每层数据都要存在单独的数组中，可以在上述思路基础上发展一下，添加一个“当前层队列”存储当前层的节点。
 * 遍历队列用于遍历，但遍历的步骤改为先输出队列的值到“当前层队列”，再往更深层走。
 */

// @lc code=start

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public static void main(String[] args) {
        System.out.println("aaaaa");
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> levelQueue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelQueue.offer(node);
            if(queue.isEmpty()) {
                List<Integer> list = new ArrayList<Integer>(levelQueue.size());
                while(!levelQueue.isEmpty()){
                    TreeNode tnode = levelQueue.poll();
                    list.add(tnode.val);
                    if (null != tnode.left) {
                        queue.offer(tnode.left);
                    }
                    if (null != tnode.right) {
                        queue.offer(tnode.right);
                    }
                }
                result.add(list);
            }
        }
        return result;
    }
}
// @lc code=end
