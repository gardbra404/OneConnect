package com.oneconnect.OneConnect.Grades;

import com.oneconnect.OneConnect.Utility;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GradesService {

    public List<Grade> retrieveGrades(String studentId) {
        Utility utility = new Utility();
        List<Grade> grades = new ArrayList<>();
        JSONArray gradesArray = utility.jsonArrayGenerator("Grades.json");
        JSONArray assignments = utility.jsonArrayGenerator("Assignments.json");
        if(utility.numberChecker(studentId)) {
            for (int i = 0; i < gradesArray.size(); i++) {
                JSONObject gradeInfo = (JSONObject) gradesArray.get(i);
                JSONArray gradeStudents = (JSONArray) gradeInfo.get("students");
                for (int j = 0; j < gradeStudents.size(); j++) {
                    JSONObject gradeStudent = (JSONObject) gradeStudents.get(j);
                    if (studentId.equals(gradeStudent.get("id"))) {
                        Grade grade = new Grade();
                        grade.setScore((String) gradeStudent.get("score"));
                        String assignment = (String) gradeStudent.get("assignment");
                        for (int k = 0; k < assignments.size(); k++) {
                            JSONObject assignObj = (JSONObject) assignments.get(i);
                            if (assignment.equals(assignObj.get("id"))) {
                                grade.setAssignment((String) assignObj.get("title"));
                                break;
                            }
                        }
                        grades.add(grade);
                    }

                }
            }
        }
        return grades;
    }

    //for testing purposes
    public boolean createGrades (String student, String assignment, String classId, String score){
        return createGrades(student, assignment, classId, score, false);
    }

    @SuppressWarnings("unchecked")
    public boolean createGrades (String student, String assignment, String classId, String score, boolean test) {
        Utility utility = new Utility();
        JSONArray copyGrades = new JSONArray();
        boolean gradeCreated = false;
        if (utility.numberChecker(student) && utility.numberChecker(assignment) && utility.numberChecker(classId) && utility.numberChecker(score)) {
            JSONArray gradeInfo = utility.jsonArrayGenerator("Grades.json");
            for (int i = 0; i < gradeInfo.size(); i++) {
                JSONObject grade = (JSONObject) gradeInfo.get(i);
                if (classId.equals(grade.get("class"))) {
                    JSONObject replaceGrades = new JSONObject();
                    replaceGrades.put("class", grade.get("class"));
                    JSONArray students = (JSONArray) grade.get("students");
                    JSONObject newGrade = new JSONObject();
                    newGrade.put("student",student);
                    newGrade.put("assignment", assignment);
                    newGrade.put("score", score);
                    students.add(newGrade);
                    replaceGrades.put("students", students);
                    copyGrades.add(replaceGrades);
                } else {
                    copyGrades.add(grade);
                }
            }
            if(!test) {
                gradeCreated = utility.jsonWriter(copyGrades.toJSONString(), "Grades.json");
            } else {
                gradeCreated = true;
            }
        }
        return gradeCreated;
    }

    public boolean updateGrade(String student, String assignment, String classId, String score) {
        return updateGrade(student, assignment, classId, score, false);
    }

    @SuppressWarnings("unchecked")
    public boolean updateGrade(String student, String assignment, String classId, String score, boolean test) {
        Utility utility = new Utility();
        JSONArray copyGrades = new JSONArray();
        boolean gradeUpdated = false;
        if (utility.numberChecker(student) && utility.numberChecker(assignment) && utility.numberChecker(classId) && utility.numberChecker(score)) {
            JSONArray gradeInfo = utility.jsonArrayGenerator("Grades.json");
            for (int i = 0; i < gradeInfo.size(); i++) {
                JSONObject grade = (JSONObject) gradeInfo.get(i);
                if (classId.equals(grade.get("class"))) {
                    JSONObject replaceGrades = new JSONObject();
                    replaceGrades.put("class", grade.get("class"));
                    JSONArray students = (JSONArray) grade.get("students");
                    JSONArray copyStudents = new JSONArray();
                    for (int j = 0; j < students.size(); j++) {
                        JSONObject studentGrade = (JSONObject) students.get(j);
                        if(student.equals(studentGrade.get("student")) && assignment.equals(studentGrade.get("assignment"))) {
                            JSONObject newGrade = new JSONObject();
                            newGrade.put("student",studentGrade.get("student"));
                            newGrade.put("assignment", studentGrade.get("assignment"));
                            newGrade.put("score", score);
                            copyStudents.add(newGrade);
                        } else {
                            copyStudents.add(studentGrade);
                        }
                    }
                    replaceGrades.put("students", copyStudents);
                    copyGrades.add(replaceGrades);
                } else {
                    copyGrades.add(grade);
                }
            }
        }
        if(!test) {
            gradeUpdated = utility.jsonWriter(copyGrades.toJSONString(), "Grades.json");
        } else {
            gradeUpdated = true;
        }

        return gradeUpdated;
    }

    public boolean doesGradeExist (String student, String assignment, String classId){
        boolean exists = false;
        Utility utility = new Utility();
        if (student != null && assignment != null && classId != null) {
            JSONArray grades = utility.jsonArrayGenerator("Grades.json");
            for (int i = 0; i < grades.size(); i++) {
                JSONObject grade = (JSONObject) grades.get(i);
                if(classId.equals(grade.get("class"))){
                    JSONArray students = (JSONArray)grade.get("students");
                    for(int j = 0; j < students.size(); j++) {
                        JSONObject studentObj = (JSONObject) students.get(j);
                        if(student.equals(studentObj.get("student")) && assignment.equals(studentObj.get("assignment"))) {
                            exists = true;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return exists;
    }

}
