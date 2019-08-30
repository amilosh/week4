package by.milosh.task1;

import by.milosh.iterator.BreadthFirstSearchTraversal;
import by.milosh.iterator.Traversal;
import by.milosh.iterator.TreeIterator;
import by.milosh.tree.Tree;
import by.milosh.util.TreeUtil;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class CheckBreadthFirstSearchTraversal {

    private Traversal<Integer> traversal = BreadthFirstSearchTraversal.getInstance();

    @Test
    public void checkBreadthFirstSearchTraversal() {
        Integer[] array = new Integer[]{8, 3, 10, 1, 6, 14, 4, 7, 13};
        String expectedTraversal = "831016144713";
        Tree tree = TreeUtil.createIntegerTree(array);
        Iterator<Tree.Node> iterator = new TreeIterator<>(tree.getRoot());
        ((TreeIterator) iterator).setTraversal(traversal);
        StringBuilder str = new StringBuilder();
        while (iterator.hasNext()) {
            Tree.Node node = iterator.next();
            str.append(node.getKey());
        }
        assertEquals(str.toString(), expectedTraversal);
    }
}
