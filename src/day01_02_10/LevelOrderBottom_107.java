package day01_02_10;

import java.util.*;

public class LevelOrderBottom_107 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);

        n2.left = n3;
        n2.right = n4;

        root.left = n1;
        root.left = n2;

        levelOrderBottom(root);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            levelOrder.add(0, level);
        }
        return levelOrder;
    }

    //中序遍历树
//    public static void preOrder(TreeNode root, Stack<Integer> result) {
//        if (root.right != null) {
//            result.push(root.right.val);
//            preOrder(root.right, result);
//        }
//        result.add(root.val);
//        if (root.left != null) {
//            result.push(root.left.val);
//            preOrder(root.left, result);
//        }
//
//    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
