package by.milosh.decorator;

import by.milosh.entity.Student;
import by.milosh.visitor.StudentVisitor;

public class StudentDecorator {

    private Student student;

    public StudentDecorator(Student student) {
        this.student = student;
    }

    public void accept(StudentVisitor visitor) {
        visitor.visit(this.student);
    }
}
