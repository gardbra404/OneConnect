package com.oneconnect.OneConnect.Grades;

import java.util.Objects;

public class Grade {

    private String studentName;
    private String assignment;
    private String score;
    private String className;
    private String classId;
    private String assignmentTotal;

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getAssignmentTotal() {
        return assignmentTotal;
    }

    public void setAssignmentTotal(String assignmentTotal) {
        this.assignmentTotal = assignmentTotal;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grade)) return false;
        Grade grade = (Grade) o;
        return Objects.equals(studentName, grade.studentName) &&
                Objects.equals(assignment, grade.assignment) &&
                Objects.equals(score, grade.score) &&
                Objects.equals(className, grade.className) &&
                Objects.equals(classId, grade.classId) &&
                Objects.equals(assignmentTotal, grade.assignmentTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, assignment, score, className, classId, assignmentTotal);
    }
}
