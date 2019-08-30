package by.milosh.visitor;

import by.milosh.entity.Course;
import by.milosh.entity.Estimate;
import by.milosh.entity.Mark;
import by.milosh.entity.Student;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;

public class ListMarksByCourseVisitor implements StudentVisitor {

    private EnumMap<Course, List<Mark>> marksByCourse = new EnumMap<>(Course.class);

    public EnumMap<Course, List<Mark>> getMarksByCourse() {
        return marksByCourse;
    }

    public ListMarksByCourseVisitor() {
        for (int i = 0; i < Course.values().length; i++) {
            marksByCourse.put(Course.values()[i], new ArrayList<>());
        }
    }

    @Override
    public void visit(Student student) {
        Set<Estimate> estimates = student.getEstimates();
        for (Estimate estimate : estimates) {
            Course course = estimate.getCourse();
            List<Mark> marks = marksByCourse.get(course);
            marks.add(estimate.getMark());
            marksByCourse.put(course, marks);
        }
    }
}
