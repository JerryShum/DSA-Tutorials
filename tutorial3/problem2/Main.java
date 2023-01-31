package tutorial3.problem2;

public class Main {
    public static void main(String[] args) {
        TreeNode root = null;

        TreeNode node1 = new TreeNode("+");
        TreeNode node2 = new TreeNode("*");
        TreeNode node3 = new TreeNode("5");
        TreeNode node4 = new TreeNode("4");
        TreeNode node5 = new TreeNode("-");
        TreeNode node6 = new TreeNode("100");
        TreeNode node7 = new TreeNode("/");
        TreeNode node8 = new TreeNode("20");
        TreeNode node9 = new TreeNode ("2");

        root = node1;

        node1.left = node2;
        node1.right = node5;

        node2.left = node3;
        node2.right = node4;

        node5.left = node6;
        node5.right = node7;

        node7.left = node8;
        node7.right = node9;

        System.out.println("Post Order");
        System.out.println(postOrderTraversal(root).getData());

        System.out.println();
        System.out.println("Pre order");
        preOrderTraversal(root);

        System.out.println();
        System.out.println("In order");
        inOrderTraversal(root);

    }

    // post order traversal print
    public static TreeNode postOrderTraversal(TreeNode root) {        
        TreeNode next = root;
        if(root.left != null) {
            next = postOrderTraversal(root.left);
        }
        if(root.right != null) {
            next = postOrderTraversal(root.right);
        }
        System.out.println(root.getData());
        return next;
    }

    // pre order traversal print
    public static TreeNode preOrderTraversal(TreeNode root) {
        TreeNode next = root;
        System.out.println(root.getData());
        if(root.left != null) {
            next = preOrderTraversal(root.left);
        }
        if(root.right != null) {
            next = preOrderTraversal(root.right);
        }
        return next;
    }

    // in order traversal print
    public static TreeNode inOrderTraversal(TreeNode root) {
        TreeNode next = root;
        if(root.left != null) {
            next = inOrderTraversal(root.left);
        }
        System.out.println(root.getData());
        if(root.right != null) {
            next = inOrderTraversal(root.right);
        }
        return next;
    }

}