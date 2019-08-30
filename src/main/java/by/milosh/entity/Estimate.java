package by.milosh.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Estimate {

    private Course course;
    private Mark mark;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Estimate estimate = (Estimate) o;
        return course == estimate.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }
}
