package day21_09;

public class IsSymmetric_101 {
    public static void main(String[] args) {
        /**
         * 给定一个二叉树，检查它是否是镜像对称的。
         * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
         */

        TreeNode root = new TreeNode();
        System.out.println(root == null);
        boolean result = isSymmetric(root);
    }

    /**
     * 当成镜子比较，传入的时候为 root， root，镜面对称条件：
     * 左右父节点值相同，且左父节点的左子树 与 右父节点的右子树相同，并且左父节点的右子树 与 右父节点的左子树相同
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
