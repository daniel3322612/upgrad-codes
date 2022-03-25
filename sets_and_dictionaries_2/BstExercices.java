package cm.wise.sky.integration.payments.upgrad;

public class BstExercices {

    //https://leetcode.com/problems/trim-a-binary-search-tree/
    public static BinarySearchTree.Node trimBST(BinarySearchTree.Node root, int low, int high) {
        if (root == null) return root;
        if (root.value > high) return trimBST(root.left, low, high);
        if (root.value < low) return trimBST(root.right, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    //https://leetcode.com/problems/path-sum/
    public static boolean hasPathSum(BinarySearchTree.Node root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.value == targetSum
            && root.left == null
            && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.value)
            || hasPathSum(root.right, targetSum - root.value);
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(70);
        bst.insert(10);

        System.out.println(hasPathSum(bst.root, 50));

    }
}
