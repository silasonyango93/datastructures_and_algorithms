package turing;


import binary_search_tree.BinarySearchTree;
import org.junit.Test;

public class BinaryTreeMaximumDepth {

    private class Node {
        int value;
        Node left, right;

        Node(int val) {
            value = val;
            left = right = null;
        }
    }

    Node root;

    int maxDepth(Node root) {
        // Root being null means tree doesn't exist.
        if (root == null) {
            return 0;
        }

        // Get the depth of the left and right subtree
        // using recursion.
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Choose the larger one and add the root to it.
        return java.lang.Math.max(leftDepth, rightDepth) + 1;
    }

    public Node insertNode(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.value) {
            node.left = insertNode(node.left, data);
        } else {
            node.right = insertNode(node.right, data);
        }
        return node;
    }

    @Test
    public void testSolution() {
        Node rootNode = null;
        rootNode = insertNode(rootNode,6);
        rootNode = insertNode(rootNode,4);
        rootNode = insertNode(rootNode,7);
        rootNode = insertNode(rootNode,3);
        rootNode = insertNode(rootNode,2);
        rootNode = insertNode(rootNode,5);
        rootNode = insertNode(rootNode,1);

        int depth = maxDepth(rootNode);
        assert 4 == depth;
    }
}
