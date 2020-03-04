package com.oneconnect.OneConnect.UserCreation;

import com.oneconnect.OneConnect.Utility;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserCreationService {

    public boolean roleCheck (String role) {
        return role.equals("admin");
    }
/*
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
*/
    //for testing purposes
    public boolean createUser (String name, List<String> role, String userId, List<String> classes, List<Child> children){
        return createUser(name, role, userId, classes, children, false);
    }

    @SuppressWarnings("unchecked")
    public boolean createUser (String name, List<String> role, String userId, List<String> classes, List<Child> children, boolean test) {
        Utility utility = new Utility();
        JSONArray copyUser = new JSONArray();
        boolean userCreated = false;
        boolean childrenValid = false;
        boolean classesValid = false;
        for(int classCount = 0; classCount < classes.size(); classCount++){
            if(!utility.numberChecker(classes.get(classCount))){
                classesValid = false;
                break;
            }
            classesValid = true;
        }
        for(int childCount = 0; childCount < children.size(); childCount++){
            if(!utility.numberChecker(children.get(childCount))){
                childrenValid = false;
                break;
            }
            childrenValid = true;
        }
        if (utility.numberChecker(userId) && childrenValid) {
            JSONArray userList = utility.jsonArrayGenerator("Users.json");
            for (int i = 0; i < userList.size(); i++) {
                JSONObject user = (JSONObject) userList.get(i);
                if (userId.equals(user.get("userId"))) {
                    JSONObject replaceUser = new JSONObject();
                    replaceUser.put("name", user.get("name"));

                    JSONArray roles = (JSONArray) user.get("role");
                    JSONObject newRoles = new JSONObject();
                    newRoles.put("role", role);
                    roles.add(newRoles);
                    replaceUser.put("role", roles);

                    replaceUser.put("userId", user.get("userId"));

                    JSONArray oldClasses = (JSONArray) user.get("classes");
                    JSONObject newClasses = new JSONObject();
                    newClasses.put("classes", classes);
                    oldClasses.add(newClasses);
                    replaceUser.put("classes", oldClasses);

                    JSONArray oldChildren = (JSONArray) user.get("children");
                    JSONObject newChildren = new JSONObject();
                    newChildren.put("userId", children.get(0)); //fix index
                    newChildren.put("allowed", children.get(0)); //fix index
                    oldChildren.add(newChildren);
                    replaceUser.put("children", oldChildren);

                    copyUser.add(replaceUser);
                } else {
                    copyUser.add(user);
                }
            }
            if(!test) {
                userCreated = utility.jsonWriter(copyUser.toJSONString(), "Users.json");
            } else {
                userCreated = true;
            }
        }
        return userCreated;
    }

    public boolean updateUser(String name, List<String> role, String userId, List<String> classes, List<Child> children) {
        return updateUser(name, role, userId, classes, children, false);
    }

    @SuppressWarnings("unchecked")
    public boolean updateUser(String name, List<String> role, String userId, List<String> classes, List<Child> children, boolean test) {
        Utility utility = new Utility();
        JSONArray copyUser = new JSONArray();
        boolean userUpdated = false;
        if (utility.numberChecker(userId) && utility.numberChecker()) {
            JSONArray userList = utility.jsonArrayGenerator("Users.json");
            for (int i = 0; i < userList.size(); i++) {
                JSONObject updateUser = (JSONObject) userList.get(i);
                if (userId.equals(updateUser.get("userId"))) {
                    updateUser.put("name", name);
                    updateUser.put("role", role);
                    //updateUser.put("userId", updateUser.get("userId"));
                    updateUser.put("classes", classes);
                    updateUser.put("children", children);
                    copyUser.add(updateUser);
                } else {
                    copyUser.add(updateUser);
                }
            }
            if (!test) {
                userUpdated = utility.jsonWriter(copyUser.toJSONString(), "Grades.json");
            } else {
                userUpdated = true;
            }
        }
        return userUpdated;
    }

    public boolean doesUserExist (String name, String userId) {
        Utility utility = new Utility();
        boolean exists = false;
        if (name != null && userId != null) {
            JSONArray userList = utility.jsonArrayGenerator("Users.json");
            for (int i = 0; i < userList.size(); i++) {
                JSONObject user = (JSONObject) userList.get(i);
                if(userId.equals(user.get("userId")) && name.equals(user.get("name"))){
                    exists = true;
                    break;
                }
            }
        }
        return exists;
    }

    public List<User> getUser(String name) {
        Utility utility = new Utility();
        List<User> userList = new ArrayList<>();
        JSONArray users = utility.jsonArrayGenerator("Users.json");
        for (int i = 0; i < users.size(); i++) {
            JSONObject user = (JSONObject) users.get(i);
            if (name.equals(user.get("name"))){
                userList.add(new User( (String)user.get("name"), List<String>user.get("role"),(String) user.get("userId"), List<String>user.get("classes"), List<String>user.get("children")));
            }
        }
        return userList;
    }

    public List<User> getByUserId(String userId) {
        Utility utility = new Utility();
        List<User> userList = new ArrayList<>();
        JSONArray users = utility.jsonArrayGenerator("Users.json");
        for (int i = 0; i < users.size(); i++) {
            JSONObject user = (JSONObject) users.get(i);
            if (userId.equals(user.get("userId"))){
                userList.add(new User( (String)user.get("name"), List<String>user.get("role"),(String) user.get("userId"), List<String>user.get("classes"), List<String>user.get("children")));
            }
        }
        return userList;
    }

    public List<User> getByRole(String role) {
        Utility utility = new Utility();
        List<User> userList = new ArrayList<>();
        JSONArray users = utility.jsonArrayGenerator("Users.json");
        for (int i = 0; i < users.size(); i++) {
            JSONObject user = (JSONObject) users.get(i);
            if (role.equals(user.get("role"))){
                userList.add(new User( (String)user.get("name"), List<String>user.get("role"),(String) user.get("userId"), List<String>user.get("classes"), List<String>user.get("children")));
            }
        }
        return userList;
    }

    public List<User> getAllUsers() {
        Utility utility = new Utility();
        List<User> userList = new ArrayList<>();
        JSONArray users = utility.jsonArrayGenerator("Users.json");
        for (int i = 0; i < users.size(); i++){
            JSONObject user = (JSONObject) users.get(i);
            userList.add(new User( (String)user.get("name"), List<String>user.get("role"),(String) user.get("userId"), List<String>user.get("classes"), List<String>user.get("children")));
        }
        return userList;
    }
/*
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
 */
}
