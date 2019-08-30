package by.milosh.iterator;

import by.milosh.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchTraversal<T extends Comparable<T>> implements Traversal<T> {

    private static BreadthFirstSearchTraversal instance;
    private Queue<Tree.Node<T>> queue = new LinkedList<>();

    private BreadthFirstSearchTraversal() {
    }

    public static BreadthFirstSearchTraversal getInstance() {
        if (instance == null) {
            instance = new BreadthFirstSearchTraversal();
        }
        return instance;
    }

    @Override
    public void init(Tree.Node<T> root) {
        queue.add(root);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Tree.Node<T> next() {
        Tree.Node<T> node = queue.poll();
        if (node.getLeft() != null) {
            queue.add(node.getLeft());
        }
        if (node.getRight() != null) {
            queue.add(node.getRight());
        }
        return node;
    }
}
