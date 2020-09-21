package day21_09;

public class MaxDepth_104 {
    public static void main(String[] args) {
        /**
         * 给定一个二叉树，找出其最大深度。
         *
         * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
         *
         * 说明: 叶子节点是指没有子节点的节点。
         */
        //[3,9,20,null,null,15,7]

        TreeNode r2 = new TreeNode(9);
        TreeNode r4 = new TreeNode(15);
        TreeNode r5 = new TreeNode(7);
        TreeNode r3 = new TreeNode(20, r4, r5);
        TreeNode root = new TreeNode(3, r2, r3);

        int result = maxDepth(root);
        System.out.println(result);

    }

    /**
     * 找出终止条件：当前节点为空
     * 找出返回值：节点为空时说明高度为 0，所以返回 0；节点不为空时则分别求左右子树的高度的最大值，同时加1表示当前节点的高度，返回该数值
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }


}
