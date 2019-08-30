package by.milosh.entity;

import java.util.LinkedHashSet;
import java.util.Set;

public class Student implements Comparable<Student> {

    private String name;
    private Set<Estimate> estimates;

    public Student(String name) {
        this.name = name;
        this.estimates = new LinkedHashSet<>();
    }

    public void addEstimate(Estimate estimate) {
        estimates.add(estimate);
    }

    public Set<Estimate> getEstimates() {
        return estimates;
    }

    @Override
    public int compareTo(Student student) {
        return name.compareTo(student.name);
    }
}
