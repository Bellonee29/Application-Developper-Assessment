package org.waysTech;

import java.util.function.Consumer;

class BinarySearchTree {
    private TreeNode root;

    // Constructor to initialize the root of the BST
    public BinarySearchTree() {
        this.root = null;
    }

    // Method to insert a new value in the BST
    public void insert(int value) {
        root = insertNode(root, value);
    }

    // A recursive function to insert a new value in the BST
    private TreeNode insertNode(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.value) {
            node.leftChild = insertNode(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = insertNode(node.rightChild, value);
        }
        return node;
    }
    // Method to search for a value in the BST
    public boolean search(int value) {
        return searchNode(root, value);
    }
    // A recursive function to search for a value in the BST
    private boolean searchNode(TreeNode node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.value) {
            return true;
        }
        if (value < node.value) {
            return searchNode(node.leftChild, value);
        } else {
            return searchNode(node.rightChild, value);
        }
    }
    // Method to perform in-order traversal of the BST
    public void inorderTraversal() {
        inorder(root, node -> System.out.print(node.value + " "));
        System.out.println(); // Newline after traversal
    }
    // A recursive function to perform in-order traversal of the BST
    private void inorder(TreeNode node, Consumer<TreeNode> action) {
        if (node != null) {
            inorder(node.leftChild, action);
            action.accept(node);
            inorder(node.rightChild, action);
        }
    }
    // Method to delete a value from the BST
    public void delete(int value) {
        root = deleteNode(root, value);
    }
    // A recursive function to delete a value from the BST
    private TreeNode deleteNode(TreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.leftChild = deleteNode(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = deleteNode(node.rightChild, value);
        } else {
            if (node.leftChild == null) {
                return node.rightChild;
            } else if (node.rightChild == null) {
                return node.leftChild;
            }
            node.value = findMinValue(node.rightChild);
            node.rightChild = deleteNode(node.rightChild, node.value);
        }
        return node;
    }
    // Method to find the minimum value in a given subtree
    private int findMinValue(TreeNode node) {
        int minValue = node.value;
        while (node.leftChild != null) {
            minValue = node.leftChild.value;
            node = node.leftChild;
        }
        return minValue;
    }
    // Main method to test the above implementation
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // Insert elements into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
            // Print in-order traversal of the BST
        System.out.print("In-order traversal: ");
        bst.inorderTraversal();
            // Search for elements in the BST
        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 25: " + bst.search(25));
        // Delete an element from the BST
        bst.delete(20);
        System.out.print("In-order traversal after deleting 20: ");
        bst.inorderTraversal();
    }
}