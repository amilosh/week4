package by.milosh.iterator;

import by.milosh.tree.Tree;

import java.util.Iterator;

public class TreeIterator<T extends Comparable<T>> implements Iterator<Tree.Node<T>> {

    private Traversal<T> traversal;
    private Tree.Node<T> root;

    public TreeIterator(Tree.Node<T> root) {
        this.root = root;
    }

    public void setTraversal(Traversal<T> traversal) {
        this.traversal = traversal;
        this.traversal.init(root);
    }

    public boolean hasNext() {
        return traversal.hasNext();
    }

    public Tree.Node<T> next() {
        return traversal.next();
    }
}
