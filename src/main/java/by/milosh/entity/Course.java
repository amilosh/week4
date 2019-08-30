package by.milosh.entity;

public enum Course {
    JAVA("Java"),
    C_SHARP("C#"),
    PYTHON("Python"),
    JAVA_SCRIPT("JavaScript"),
    SQL("SQL"),
    LINUX("Linux");

    private String value;

    Course(String value) {
        this.value = value;
    }
}
