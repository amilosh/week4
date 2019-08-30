package by.milosh.tree;

import lombok.Getter;

public class Tree<T extends Comparable<T>> {

    private Node<T> root;

    public Tree() {
    }

    @Getter
    public static class Node<T extends Comparable<T>> {
        private T key;
        private Node<T> left;
        private Node<T> right;

        public Node(T key) {
            this.key = key;
        }
    }

    public Node<T> getRoot() {
        return root;
    }

    public void insert(T key) {
        root = insertNode(root, key);
    }

    private Node insertNode(Node<T> root, T key) {
        if (root == null) {
            return new Node(key);
        }
        if (key.compareTo(root.getKey()) < 0) {
            root.left = insertNode(root.left, key);
        } else if (key.compareTo(root.getKey()) > 0) {
            root.right = insertNode(root.right, key);
        }
        return root;
    }
}
