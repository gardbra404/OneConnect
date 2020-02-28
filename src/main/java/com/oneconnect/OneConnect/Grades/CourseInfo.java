package com.oneconnect.OneConnect.Grades;

import java.util.List;

public class CourseInfo {
    List<Student> students;
    List<Assignment> assignments;

    public CourseInfo(List<Student> students, List<Assignment> assignments) {
        this.students = students;
        this.assignments = assignments;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}
