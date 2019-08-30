package by.milosh.visitor;

import by.milosh.entity.Estimate;
import by.milosh.entity.Student;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CountCoursesByStudentVisitor implements StudentVisitor {

    private Map<Student, Integer> countCourses = new LinkedHashMap<>();

    public Map<Student, Integer> getCountCourses() {
        return countCourses;
    }

    @Override
    public void visit(Student student) {
        Set<Estimate> estimates = student.getEstimates();
        Integer count = estimates.size();
        countCourses.put(student, count);
    }
}
