package by.milosh.iterator;

import by.milosh.tree.Tree;

import java.util.Iterator;

public interface Traversal<T extends Comparable<T>> extends Iterator<Tree.Node<T>> {

    public void init(Tree.Node<T> root);

    public boolean hasNext();

    public Tree.Node<T> next();
}
