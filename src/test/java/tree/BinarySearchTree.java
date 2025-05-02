package tree;

import org.junit.jupiter.api.Test;
import sort.GsonUtils;

public class BinarySearchTree {

    Node root;

    public class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    BinarySearchTree() {
        root = null;
    }

    Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (key < root.key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }


    Node delete(Node root, int key) {
        // Base case: If the tree is empty
        if (root == null) {
            return null;
        }
        // Traverse the tree to find the node to delete
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            // Node to be deleted found
            // Case 1: Node has no child (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: Node has one child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Node has two children
            else {
                // Find the smallest node in the right subtree (in-order successor)
                Node successor = findMin(root.right);
                root.key = successor.key; // Replace root's key with the successor's key
                root.right = delete(root.right, successor.key); // Delete the successor
            }
        }
        return root;
    }

    Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }


    @Test
    void test() {
        Node root = new Node(50);
        insert(root, 30);
        insert(root, 60);
        insert(root, 70);
        System.out.println(GsonUtils.toString(root));
        System.out.println("search: " + GsonUtils.toString(search(root, 30)));
        System.out.println("search: " + GsonUtils.toString(search(root, 100)));
        Node node = delete(root, 50);
        System.out.println("delete" + GsonUtils.toString(node));
    }

}
