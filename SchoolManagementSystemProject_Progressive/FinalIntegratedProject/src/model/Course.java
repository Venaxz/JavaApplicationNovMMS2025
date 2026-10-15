package model;
public class Course {
    private final String courseId;
    private String courseName;
    public Course(String courseId, String courseName) {
        if (courseId == null || courseId.isBlank() || courseName == null || courseName.isBlank()) throw new IllegalArgumentException("Course ID and name are required.");
        this.courseId = courseId.trim(); this.courseName = courseName.trim();
    }
    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String name) { if (name == null || name.isBlank()) throw new IllegalArgumentException("Course name is required."); courseName = name.trim(); }
}
