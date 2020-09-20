package day20_09;

public class IsSameTree_100 {
    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
//        TreeNode pRoot = new TreeNode(1, null, n2);
        TreeNode pRoot = null;

//        TreeNode qRoot = new TreeNode(1, null, n3);
        TreeNode qRoot = null;

        boolean sameTree = isSameTree(pRoot, qRoot);
        System.out.println(sameTree);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
