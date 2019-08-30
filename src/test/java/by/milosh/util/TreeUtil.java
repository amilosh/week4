package by.milosh.util;

import by.milosh.entity.Student;
import by.milosh.tree.Tree;

import java.util.List;

public final class TreeUtil {

    public static Tree<Integer> createIntegerTree(Integer[] array) {
        Tree<Integer> tree = new Tree();
        for (Integer i : array) {
            tree.insert(i);
        }
        return tree;
    }

    public static Tree<Student> createStudentTree(List<Student> students) {
        Tree<Student> tree = new Tree();
        for (Student student : students) {
            tree.insert(student);
        }
        return tree;
    }
}
