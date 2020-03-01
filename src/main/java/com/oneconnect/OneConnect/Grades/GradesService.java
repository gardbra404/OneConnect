package com.oneconnect.OneConnect.Grades;

import com.oneconnect.OneConnect.Utility;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.List;

public class GradesService {

    public boolean roleCheck (String role) {
        return role.equals("teacher");
    }

    public List<List<Grade>> parentGrades(String id) {
        List<List<Grade>> grades = new ArrayList<>();
        Utility utility = new Utility();
        if(utility.numberChecker(id)) {
            JSONArray jsonArray = utility.jsonArrayGenerator("Users.json");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject user = (JSONObject) jsonArray.get(i);
                if (id.equals(user.get("id"))) {
                    JSONArray kids = (JSONArray) user.get("children");
                    for(int j = 0; j < kids.size(); j++) {
                        JSONObject kid = (JSONObject) kids.get(j);
                        if((kid.get("allowed")).equals("true")){
                            List<Grade> childGrades = retrieveGrades((String)kid.get("id"));
                            String name = findName((String)kid.get("id"));
                            for (Grade grade: childGrades) {
                                grade.setStudentName(name);
                            }
                            grades.add(childGrades);
                        }
                    }
                }
            }
        }
        return grades;
    }

    public List<Grade> studentGrades(String id) {
        return retrieveGrades(id);
    }

    public List<Grade> retrieveGrades(String studentId) {
        Utility utility = new Utility();
        List<Grade> grades = new ArrayList<>();
        JSONArray gradesArray = utility.jsonArrayGenerator("Grades.json");
        JSONArray assignments = utility.jsonArrayGenerator("Assignments.json");
        System.out.println(assignments);
        if(utility.numberChecker(studentId)) {
            for (int i = 0; i < gradesArray.size(); i++) {
                JSONObject gradeInfo = (JSONObject) gradesArray.get(i);
                JSONArray gradeStudents = (JSONArray) gradeInfo.get("students");
                for (int j = 0; j < gradeStudents.size(); j++) {
                    JSONObject gradeStudent = (JSONObject) gradeStudents.get(j);
                    if (studentId.equals(gradeStudent.get("student"))) {

                        Grade grade = new Grade();
                        grade.setScore((String) gradeStudent.get("score"));
                        grade.setClassName((String) gradeInfo.get("className"));
                        String assignment = (String) gradeStudent.get("assignment");

                        for (int k = 0; k < assignments.size(); k++) {

                            JSONObject assignObj = (JSONObject) assignments.get(k);
                            if (assignment.equals(assignObj.get("id"))) {

                                grade.setAssignment((String) assignObj.get("title"));
                                grade.setClassId((String) assignObj.get("class"));
                                grade.setAssignmentTotal((String) assignObj.get("maxScore"));

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
                    replaceGrades.put("className", grade.get("className"));
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
                    replaceGrades.put("className", grade.get("className"));
                    JSONArray students = (JSONArray) grade.get("students");
                    JSONArray copyStudents = new JSONArray();
                    for (int j = 0; j < students.size(); j++) {
                        JSONObject studentGrade = (JSONObject) students.get(j);
                        if (student.equals(studentGrade.get("student")) && assignment.equals(studentGrade.get("assignment"))) {
                            JSONObject newGrade = new JSONObject();
                            newGrade.put("student", studentGrade.get("student"));
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
            if (!test) {
                gradeUpdated = utility.jsonWriter(copyGrades.toJSONString(), "Grades.json");
            } else {
                gradeUpdated = true;
            }
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

    public String findName (String id) {
        Utility utility = new Utility();
        JSONArray users = utility.jsonArrayGenerator("Users.json");
        String name = "Not Found";
        for (int i = 0; i < users.size(); i++) {
            JSONObject jsonObject = (JSONObject) users.get(i);
            if (id.equals(jsonObject.get("id"))) {
                name = (String)jsonObject.get("name");
                break;
            }
        }
        return name;
    }

    public List<Course> getCourses(String id){
        Utility utility = new Utility();
        List<Course> courseList = new ArrayList<>();
        JSONArray courses = utility.jsonArrayGenerator("Class.json");
        for (int i = 0; i < courses.size(); i++) {
            JSONObject course = (JSONObject) courses.get(i);
            if (id.equals(course.get("teacher"))){
                courseList.add(new Course( (String)course.get("name"),(String) course.get("id")));
            }
        }
        return courseList;
    }

    public CourseInfo getCourseInfo(String courseId) {
        Utility utility = new Utility();
        JSONArray classes = utility.jsonArrayGenerator("Class.json");
        JSONArray assignments = utility.jsonArrayGenerator("Assignments.json");
        JSONArray students = utility.jsonArrayGenerator("Users.json");
        JSONArray classStudents = new JSONArray();
        JSONArray classAssignments = new JSONArray();
        for (int i = 0; i < classes.size(); i++) {
            JSONObject classy = (JSONObject) classes.get(i);
            if (courseId.equals(classy.get("id"))){
                classAssignments = (JSONArray) classy.get("assignments");
                classStudents = (JSONArray) classy.get("students");
                break;
            }
        }
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < classStudents.size(); i++) {
            String id = (String) classStudents.get(i);
            for (int j = 0; j < students.size(); j++) {
                JSONObject student = (JSONObject) students.get(j);
                if (id.equals(student.get("id"))) {
                    studentList.add(new Student((String)student.get("id"), (String)student.get("name")));
                }
            }
        }
        List<Assignment> assignmentList = new ArrayList<>();
        for (int i = 0; i < classAssignments.size(); i++) {
            String id = (String) classAssignments.get(i);
            for(int j = 0; j < assignments.size(); j++) {
                JSONObject assignment = (JSONObject) assignments.get(j);
                if(id.equals(assignment.get("id"))) {
                    assignmentList.add(new Assignment((String)assignment.get("id"), (String)assignment.get("title")));
                }
            }
        }
        return new CourseInfo(studentList, assignmentList);
    }

    public List<Grade> teacherGrades (String teacher) {
        Utility utility = new Utility();
        List<Course> courses = new ArrayList<>();
        List<Grade> gradeList = new ArrayList<>();
        if (utility.numberChecker(teacher)) {
            courses = getCourses(teacher);
            JSONArray classes = utility.jsonArrayGenerator("Class.json");

            for (int i = 0; i < courses.size(); i++) {
                for (int j = 0; j < classes.size(); j++) {
                    JSONObject classy = (JSONObject) classes.get(j);
                    if(courses.get(i).getCourseId().equals(classy.get("id"))) {
                        JSONArray students = (JSONArray) classy.get("students");
                        for (int k = 0; k < students.size(); k++) {
                            List<Grade> studentGrades = studentGrades((String)students.get(i));
                            for (Grade grade: studentGrades) {
                                grade.setStudentName(findName((String)students.get(i)));
                            }
                            gradeList.addAll(studentGrades);
                        }
                    }
                }
            }
        }
        return filterGrades(courses, gradeList);
    }

    private List<Grade> filterGrades(List<Course> courses, List<Grade> grades) {
        List<Grade> newGradesList = new ArrayList<>();
        for(Grade grade: grades) {
            for(Course course: courses) {
                if(course.getCourseId().equals(grade.getClassId()) && existsIn(newGradesList, grade)) {
                    newGradesList.add(grade);
                }
            }
        }
        return newGradesList;
    }


    private boolean existsIn (List<Grade> grades, Grade grade) {
        for(Grade checkGrade : grades) {
            if (checkGrade.equals(grade)) {
                return false;
            }
        }
        return true;
    }

}
