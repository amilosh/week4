package by.milosh.iterator;

import by.milosh.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearchTraversal<T extends Comparable<T>> implements Traversal<T> {

    private static DepthFirstSearchTraversal instance;
    private List<Tree.Node<T>> rootArray;
    private int cursor;

    private DepthFirstSearchTraversal() {
    }

    public static DepthFirstSearchTraversal getInstance() {
        if (instance == null) {
            instance = new DepthFirstSearchTraversal();
        }
        return instance;
    }

    @Override
    public void init(Tree.Node<T> root) {
        rootArray = preOrderSearch(root);
    }

    private List<Tree.Node<T>> preOrderSearch(Tree.Node<T> root) {
        return preOrder(root, new ArrayList<Tree.Node<T>>());
    }

    private List<Tree.Node<T>> preOrder(Tree.Node<T> node, List<Tree.Node<T>> nodeList) {
        if (node == null) {
            return new ArrayList<Tree.Node<T>>();
        } else {
            nodeList.add(node);
            nodeList.addAll(preOrder(node.getLeft(), new ArrayList<Tree.Node<T>>()));
            nodeList.addAll(preOrder(node.getRight(), new ArrayList<Tree.Node<T>>()));
            return nodeList;
        }
    }

    @Override
    public boolean hasNext() {
        return cursor != rootArray.size();
    }

    @Override
    public Tree.Node<T> next() {
        int i = cursor;
        cursor = i + 1;
        return rootArray.get(i);
    }
}
