package by.milosh.task2;

import by.milosh.decorator.StudentDecorator;
import by.milosh.entity.Course;
import by.milosh.entity.Estimate;
import by.milosh.entity.Mark;
import by.milosh.entity.Student;
import by.milosh.iterator.DepthFirstSearchTraversal;
import by.milosh.iterator.Traversal;
import by.milosh.iterator.TreeIterator;
import by.milosh.tree.Tree;
import by.milosh.util.TreeUtil;
import by.milosh.visitor.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckVisitors {

    private ArrayList<Student> students = new ArrayList<>();
    private Traversal<Student> traversal = DepthFirstSearchTraversal.getInstance();

    @Before
    public void initStudents() {
        Student s1 = new Student("Harry");
        s1.addEstimate(new Estimate(Course.JAVA, Mark.NINE));
        s1.addEstimate(new Estimate(Course.JAVA_SCRIPT, Mark.EIGHT));
        s1.addEstimate(new Estimate(Course.SQL, Mark.SIX));
        Student s2 = new Student("Clint");
        s2.addEstimate(new Estimate(Course.JAVA, Mark.FIVE));
        s2.addEstimate(new Estimate(Course.JAVA_SCRIPT, Mark.FIVE));
        Student s3 = new Student("John");
        s3.addEstimate(new Estimate(Course.PYTHON, Mark.TEN));
        s3.addEstimate(new Estimate(Course.JAVA, Mark.THREE));
        Student s4 = new Student("Adam");
        s4.addEstimate(new Estimate(Course.PYTHON, Mark.TEN));
        s4.addEstimate(new Estimate(Course.SQL, Mark.SEVEN));
        s4.addEstimate(new Estimate(Course.JAVA, Mark.TWO));
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
    }

    @Test
    public void checkCountCourses() {
        Tree tree = TreeUtil.createStudentTree(students);
        Iterator<Tree.Node> iterator = new TreeIterator<>(tree.getRoot());
        ((TreeIterator) iterator).setTraversal(traversal);
        StudentVisitor visitor = new CountCoursesByStudentVisitor();
        while (iterator.hasNext()) {
            Tree.Node node = iterator.next();
            Student student = (Student) node.getKey();
            StudentDecorator studentDecorator = new StudentDecorator(student);
            studentDecorator.accept(visitor);
        }
        Integer count = ((CountCoursesByStudentVisitor) visitor).getCountCourses().get(students.get(1));
        Integer expectedCount = 2;
        assertEquals(count, expectedCount);
    }

    @Test
    public void checkCountStudents() {
        Tree tree = TreeUtil.createStudentTree(students);
        Iterator<Tree.Node> iterator = new TreeIterator<>(tree.getRoot());
        ((TreeIterator) iterator).setTraversal(traversal);
        StudentVisitor visitor = new CountStudentByCourseVisitor();
        while (iterator.hasNext()) {
            Tree.Node node = iterator.next();
            Student student = (Student) node.getKey();
            StudentDecorator studentDecorator = new StudentDecorator(student);
            studentDecorator.accept(visitor);
        }
        Integer count = ((CountStudentByCourseVisitor) visitor).getCountStudents().get(Course.JAVA);
        Integer expectedCount = 4;
        assertEquals(count, expectedCount);
    }

    @Test
    public void checkListMarksByCourseVisitor() {
        Tree tree = TreeUtil.createStudentTree(students);
        Iterator<Tree.Node> iterator = new TreeIterator<>(tree.getRoot());
        ((TreeIterator) iterator).setTraversal(traversal);
        StudentVisitor visitor = new ListMarksByCourseVisitor();
        while (iterator.hasNext()) {
            Tree.Node node = iterator.next();
            Student student = (Student) node.getKey();
            StudentDecorator studentDecorator = new StudentDecorator(student);
            studentDecorator.accept(visitor);
        }
        List<Mark> marks = ((ListMarksByCourseVisitor) visitor).getMarksByCourse().get(Course.JAVA);
        List<Mark> expectedMarks = new ArrayList<>(Arrays.asList(Mark.NINE, Mark.FIVE, Mark.TWO, Mark.THREE));
        assertEquals(marks, expectedMarks);
    }

    @Test
    public void checkListMarksByStudentVisitor() {
        Tree tree = TreeUtil.createStudentTree(students);
        Iterator<Tree.Node> iterator = new TreeIterator<>(tree.getRoot());
        ((TreeIterator) iterator).setTraversal(traversal);
        StudentVisitor visitor = new ListMarksByStudentVisitor();
        while (iterator.hasNext()) {
            Tree.Node node = iterator.next();
            Student student = (Student) node.getKey();
            StudentDecorator studentDecorator = new StudentDecorator(student);
            studentDecorator.accept(visitor);
        }
        List<Mark> marks = ((ListMarksByStudentVisitor) visitor).getMarksByStudent().get(students.get(0));
        List<Mark> expectedMarks = new ArrayList<>(Arrays.asList(Mark.NINE, Mark.EIGHT, Mark.SIX));
        assertEquals(marks, expectedMarks);
    }
}
