package by.milosh.visitor;

import by.milosh.entity.Course;
import by.milosh.entity.Estimate;
import by.milosh.entity.Student;

import java.util.EnumMap;
import java.util.Set;

public class CountStudentByCourseVisitor implements StudentVisitor {

    private EnumMap<Course, Integer> countStudents = new EnumMap<>(Course.class);

    public EnumMap<Course, Integer> getCountStudents() {
        return countStudents;
    }

    public CountStudentByCourseVisitor() {
        for (int i = 0; i < Course.values().length; i++) {
            countStudents.put(Course.values()[i], 0);
        }
    }

    @Override
    public void visit(Student student) {
        Set<Estimate> estimates = student.getEstimates();
        for (Estimate estimate : estimates) {
            Integer value = countStudents.get(estimate.getCourse());
            countStudents.put(estimate.getCourse(), value + 1);
        }
    }
}
