package cm.wise.sky.integration.payments;

public class BinarySearchTree {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                "value=" + value +
                '}';
        }
    }

    private Node root;

    // O(h)
    public void insert(int value) {
        root = insert(root, value);
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    //O(h)
    public Node search(int value) {
        return search(root, value);
    }

    public int height() {
        return height(root);
    }

    //O(h)
    public void delete(int value) {
        root = delete(root, value);
    }

    // https://www.interviewbit.com/problems/min-depth-of-binary-tree/
    public int minimumDepth() {
        return minimumDepth(root);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (node.value > value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        return node;
    }

    private Node search(Node node, int value) {
        if (node == null || node.value == value)
            return node;
        if (node.value > value)
            return search(node.left, value);
        return search(node.right, value);
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(node.left);
            int rheight = height(node.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    private void preOrder(Node node) {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private Node delete(Node node, int key) {
        /* Base Case: If the tree is empty */
        if (node == null)
            return node;

        /* Otherwise, recur down the tree */
        if (key < node.value) {
            node.left = delete(node.left, key);
        } else if (key > node.value) {
            node.right = delete(node.right, key);
        }
        // if key is same as node's
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            node.value = minValue(node.right);

            // Delete the inorder successor
            node.right = delete(node.right, node.value);
        }

        return node;
    }

    int minValue(Node node) {
        int minv = node.value;
        while (node.left != null) {
            minv = node.left.value;
            node = node.left;
        }
        return minv;
    }

    private int minimumDepth(Node root) {
        // Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (root == null)
            return 0;

        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null)
            return 1;

        // If left subtree is NULL, recur for right subtree
        if (root.left == null)
            return minimumDepth(root.right) + 1;

        // If right subtree is NULL, recur for left subtree
        if (root.right == null)
            return minimumDepth(root.left) + 1;

        return Math.min(minimumDepth(root.left),
            minimumDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(30);
        bst.insert(20);
        bst.postOrder();
        bst.preOrder();
        bst.inOrder();

        bst.insert(40);

        System.out.println(bst.search(3));

        System.out.println(bst.search(30));
        System.out.println(bst.height());

        bst.delete(30);

        bst.inOrder();
    }
}
