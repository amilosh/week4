package by.milosh.task1;

import by.milosh.iterator.DepthFirstSearchTraversal;
import by.milosh.iterator.Traversal;
import by.milosh.iterator.TreeIterator;
import by.milosh.tree.Tree;
import by.milosh.util.TreeUtil;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class CheckDepthFirstSearchTraversal {

    private Traversal<Integer> traversal = DepthFirstSearchTraversal.getInstance();

    @Test
    public void checkDepthFirstSearchTraversal() {
        Integer[] array = new Integer[]{8, 3, 10, 1, 6, 14, 4, 7, 13};
        String expectedTraversal = "831647101413";
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
