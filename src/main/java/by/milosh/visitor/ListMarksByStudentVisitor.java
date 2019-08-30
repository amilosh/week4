package by.milosh.visitor;

import by.milosh.entity.Estimate;
import by.milosh.entity.Mark;
import by.milosh.entity.Student;

import java.util.*;

public class ListMarksByStudentVisitor implements StudentVisitor {

    private Map<Student, List<Mark>> marksByStudent = new LinkedHashMap<>();

    public Map<Student, List<Mark>> getMarksByStudent() {
        return marksByStudent;
    }

    @Override
    public void visit(Student student) {
        Set<Estimate> estimates = student.getEstimates();
        List<Mark> marks = new ArrayList<>();
        for (Estimate estimate : estimates) {
            marks.add(estimate.getMark());
        }
        marksByStudent.put(student, marks);
    }
}
