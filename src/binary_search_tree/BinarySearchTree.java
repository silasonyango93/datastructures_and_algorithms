package binary_search_tree;

import org.junit.Test;

public class BinarySearchTree {

    private static class Node {
        int data;
        Node leftChild;
        Node rightChild;

        public Node(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }


    private Node insertNode(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.leftChild = insertNode(node.leftChild, data);
        } else {
            node.rightChild = insertNode(node.rightChild, data);
        }
        return node;
    }


    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.leftChild);
        System.out.println(node.data);
        inOrderTraversal(node.rightChild);

    }


    private void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }


    private void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.println(node.data);

    }

    @Test
    public void insertNode_works_as_expected() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node rootNode = null;

        rootNode = binarySearchTree.insertNode(rootNode,8);
        rootNode = binarySearchTree.insertNode(rootNode,3);
        rootNode = binarySearchTree.insertNode(rootNode,10);
        rootNode = binarySearchTree.insertNode(rootNode,1);
        rootNode = binarySearchTree.insertNode(rootNode,6);
        rootNode = binarySearchTree.insertNode(rootNode,14);
        rootNode = binarySearchTree.insertNode(rootNode,4);
        rootNode = binarySearchTree.insertNode(rootNode,7);
        rootNode = binarySearchTree.insertNode(rootNode,13);

        assert 8 == rootNode.data;
        assert 3 == rootNode.leftChild.data;
        assert 10 == rootNode.rightChild.data;
        assert 1 == rootNode.leftChild.leftChild.data;
        assert 6 == rootNode.leftChild.rightChild.data;

        postOrderTraversal(rootNode);
    }

}
