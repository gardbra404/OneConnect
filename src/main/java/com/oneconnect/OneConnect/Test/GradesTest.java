package com.oneconnect.OneConnect.Test;

import com.oneconnect.OneConnect.Grades.GradesService;

public class GradesTest {

    //All commented out sections of code are due to the fact that these pieces of code do not yet exist
    //and as such will cause compilation to fail immediately. Data passed subject to change following creation of
    //actual test data

    //forewarning, grades contains tests for unimplemented features (got ahead of myself)

    private boolean roleCheckTeacher() {
        String role = "teacher";
         GradesService gradesService = new GradesService();
         return gradesService.roleCheck(role);
    }

    private boolean roleCheckAdmin() {
        String role = "admin";
          GradesService gradesService = new GradesService();
           return !gradesService.roleCheck(role);
    }

    private boolean roleCheckStudent() {
        String role = "student";

          GradesService gradesService = new GradesService();
           return !gradesService.roleCheck(role);
    }

    private boolean roleCheckParent() {
        String role = "parent";

         GradesService gradesService = new GradesService();
          return !gradesService.roleCheck(role);

    }

    private boolean createValidAssignValidStudentValidGrade () {
        String assign = "10052";
        String student = "123";
        String classId = "5252";
        String grade = "99";
        GradesService gradesService = new GradesService();
        return gradesService.createGrades(student, assign, classId, grade, true);
    }

    private boolean createNullAssignValidStudentValidGrade () {
        String assign = null;
        String student = "123";
        String classId = "5252";
        String grade = "99";
        GradesService gradesService = new GradesService();
        return !gradesService.createGrades(student, assign, classId, grade, true);
    }

    private boolean createNanAssignValidStudentValidGrade () {
        String assign = "potato";
        String student = "123";
        String classId = "5252";
        String grade = "99";
        GradesService gradesService = new GradesService();
        return !gradesService.createGrades(student, assign, classId, grade, true);
    }

    private boolean createNotFoundAssignValidStudentValidGrade () {
        String assign = "-1";
        String student = "123";
        String classId = "5252";
        String grade = "99";
        GradesService gradesService = new GradesService();
        return !gradesService.createGrades(student, assign, classId, grade, true);
    }

    private boolean createValidAssignNotFoundStudentValidGrade () {
        String assign = "10052";
        String student = "-1";
        String classId = "5252";
        String grade = "99";
        GradesService gradesService = new GradesService();
        return !gradesService.createGrades(student, assign, classId, grade, true);
    }

    private boolean createValidAssignNullStudentValidGrade () {
        String assign = "10052";
        String student = null;
        String classId = "5252";
        String grade = "99";
        GradesService gradesService = new GradesService();
        return !gradesService.createGrades(student, assign, classId, grade, true);
    }

    private boolean createValidAssignNanStudentValidGrade () {
        String assign = "10052";
        String student = "potato";
        String classId = "5252";
        String grade = "99";
        GradesService gradesService = new GradesService();
        return !gradesService.createGrades(student, assign, classId, grade, true);
    }

    private boolean createValidAssignValidStudentNullGrade () {
        String assign = "10052";
        String student = "123";
        String classId = "5252";
        String grade = null;
        GradesService gradesService = new GradesService();
        return !gradesService.createGrades(student, assign, classId, grade, true);
    }

    private boolean createValidAssignValidStudentEmptyGrade () {
        String assign = "10052";
        String student = "123";
        String classId = "5252";
        String grade = "";
        GradesService gradesService = new GradesService();
        return !gradesService.createGrades(student, assign, classId, grade, true);
    }

    private boolean createValidAssignValidStudentNanGrade () {
        String assign = "10052";
        String student = "123";
        String classId = "5252";
        String grade = "potato";
        GradesService gradesService = new GradesService();
        return !gradesService.createGrades(student, assign, classId, grade, true);
    }

    private boolean createValidAssignValidStudentNegativeGrade () {
        String assign = "10052";
        String student = "123";
        String classId = "5252";
        String grade = "-1";
        GradesService gradesService = new GradesService();
        return !gradesService.createGrades(student, assign, classId, grade, true);
    }

    private boolean updateValidAssignValidStudentValidGrade () {
        String assign = "10052";
        String student = "123";
        String classId = "5252";
        String grade = "99";
        GradesService gradesService = new GradesService();
        return gradesService.updateGrade(student, assign, classId, grade, true);
    }

    private boolean updateNullAssignValidStudentValidGrade () {
        String assign = null;
        String student = "123";
        String classId = "5252";
        String grade = "99";
        GradesService gradesService = new GradesService();
        return !gradesService.updateGrade(student, assign, classId, grade, true);
    }

    private boolean updateNanAssignValidStudentValidGrade () {
        String assign = "potato";
        String student = "123";
        String classId = "5252";
        String grade = "99";
        GradesService gradesService = new GradesService();
        return !gradesService.updateGrade(student, assign, classId, grade, true);
    }

    private boolean updateNotFoundAssignValidStudentValidGrade () {
        String assign = "-1";
        String student = "123";
        String classId = "5252";
        String grade = "99";
        GradesService gradesService = new GradesService();
        return !gradesService.updateGrade(student, assign, classId, grade, true);
    }

    private boolean updateValidAssignNotFoundStudentValidGrade () {
        String assign = "10052";
        String student = "-1";
        String classId = "5252";
        String grade = "99";
        GradesService gradesService = new GradesService();
        return !gradesService.updateGrade(student, assign, classId, grade, true);
    }

    private boolean updateValidAssignNullStudentValidGrade () {
        String assign = "10052";
        String student = null;
        String classId = "5252";
        String grade = "99";
        GradesService gradesService = new GradesService();
        return !gradesService.updateGrade(student, assign, classId, grade, true);
    }

    private boolean updateValidAssignNanStudentValidGrade () {
        String assign = "10052";
        String student = "potato";
        String classId = "5252";
        String grade = "99";
        GradesService gradesService = new GradesService();
        return !gradesService.updateGrade(student, assign, classId, grade, true);
    }

    private boolean updateValidAssignValidStudentNullGrade () {
        String assign = "10052";
        String student = "123";
        String classId = "5252";
        String grade = null;
        GradesService gradesService = new GradesService();
        return !gradesService.updateGrade(student, assign, classId, grade, true);
    }

    private boolean updateValidAssignValidStudentEmptyGrade () {
        String assign = "10052";
        String student = "123";
        String classId = "5252";
        String grade = "";
        GradesService gradesService = new GradesService();
        return !gradesService.updateGrade(student, assign, classId, grade, true);
    }

    private boolean updateValidAssignValidStudentNanGrade () {
        String assign = "10052";
        String student = "123";
        String classId = "5252";
        String grade = "potato";
        GradesService gradesService = new GradesService();
        return !gradesService.updateGrade(student, assign, classId, grade, true);
    }

    private boolean updateValidAssignValidStudentNegativeGrade () {
        String assign = "10052";
        String student = "123";
        String classId = "5252";
        String grade = "-1";
        GradesService gradesService = new GradesService();
        return !gradesService.updateGrade(student, assign, classId, grade, true);
    }

    //for the following tests, please note, their results are best reflected when using the initial test data files
    //included in this application.
    private boolean viewStudentValidAllGrades () {
        String id = "123";
         GradesService gradesService = new GradesService();
         return gradesService.studentGrades(id).size() >=2;
    }

    private boolean viewTeacherValidAllGrades () {
        String id = "127";

        GradesService gradesService = new GradesService();
        return gradesService.teacherGrades(id).size() == 4;

    }

    private boolean viewStudentValidClass() {
        String id = "4567";
        String classId = "2050";
        /*
         * GradesService gradesService = new GradesService();
         *
         * return gradesService.getStudentClassGrades(id, classId).size() == 1;
         * */
        return true;
    }

    private boolean viewTeacherValidClass() {
        String id = "5874";
        String classId = "2050";
        /*
         * GradesService gradesService = new GradesService();
         *
         * return gradesService.getTeacherClassGrades(id, classId).size() == 3;
         * */
        return true;
    }

    private boolean viewInvalidStudentAllGrades () {
        String id = "-1";
        GradesService gradesService = new GradesService();
        return gradesService.studentGrades(id).size() == 0;
    }

    private boolean viewInvalidStudentValidClass() {
        String id = "-1";
        String classId = "2050";
        /*
         * GradesService gradesService = new GradesService();
         *
         * return gradesService.getStudentClassGrades(id, classId) == null;
         * */
        return true;
    }

    private boolean viewInvalidTeacherAllGrades () {
        String id = "-1";
        GradesService gradesService = new GradesService();
        return gradesService.teacherGrades(id).size() == 0;
    }

    private boolean viewInvalidTeacherValidClass() {
        String id = "-1";
        String classId = "2050";
        /*
         * GradesService gradesService = new GradesService();
         *
         * return gradesService.getTeacherClassGrades(id, classId) == null;
         * */
        return true;
    }

    private boolean viewStudentInvalidClass() {
        String id = "4567";
        String classId = "-1";
        /*
         * GradesService gradesService = new GradesService();
         *
         * return gradesService.getStudentClassGrades(id, classId).size() == 1;
         * */
        return true;
    }

    private boolean viewTeacherInvalidClass() {
        String id = "5874";
        String classId = "-1";
        /*
         * GradesService gradesService = new GradesService();
         *
         * return gradesService.getTeacherClassGrades(id, classId).size() == 3;
         * */
        return true;
    }

    private boolean viewNanStudentValidClass() {
        String id = "potato";
        String classId = "2050";
        /*
         * GradesService gradesService = new GradesService();
         *
         * return gradesService.getStudentClassGrades(id, classId) == null;
         * */
        return true;
    }

    private boolean viewNanTeacherAllGrades () {
        String id = "potato";
        GradesService gradesService = new GradesService();
        return gradesService.teacherGrades(id).size() == 0;
    }

    private boolean viewNanTeacherValidClass() {
        String id = "potato";
        String classId = "2050";
        /*
         * GradesService gradesService = new GradesService();
         *
         * return gradesService.getTeacherClassGrades(id, classId) == null;
         * */
        return true;
    }

    private boolean viewStudentNanClass() {
        String id = "4567";
        String classId = "potato";
        /*
         * GradesService gradesService = new GradesService();
         *
         * return gradesService.getStudentClassGrades(id, classId).size() == 1;
         * */
        return true;
    }

    private boolean viewTeacherNanClass() {
        String id = "5874";
        String classId = "potato";
        /*
         * GradesService gradesService = new GradesService();
         *
         * return gradesService.getTeacherClassGrades(id, classId).size() == 3;
         * */
        return true;
    }
    //cont
    private boolean viewNullStudentValidClass() {
        String id = null;
        String classId = "2050";
        /*
         * GradesService gradesService = new GradesService();
         *
         * return gradesService.getStudentClassGrades(id, classId) == null;
         * */
        return true;
    }

    private boolean viewNullTeacherAllGrades () {
        String id = null;

        GradesService gradesService = new GradesService();

        return gradesService.teacherGrades(id).size() == 0;
    }

    private boolean viewNullTeacherValidClass() {
        String id = null;
        String classId = "2050";
        /*
         * GradesService gradesService = new GradesService();
         *
         * return gradesService.getTeacherClassGrades(id, classId) == null;
         * */
        return true;
    }

    private boolean viewStudentNullClass() {
        String id = "4567";
        String classId = null;
        /*
         * GradesService gradesService = new GradesService();
         *
         * return gradesService.getStudentClassGrades(id, classId).size() == 1;
         * */
        return true;
    }

    private boolean viewTeacherNullClass() {
        String id = "5874";
        String classId = null;
        /*
         * GradesService gradesService = new GradesService();
         *
         * return gradesService.getTeacherClassGrades(id, classId).size() == 3;
         * */
        return true;
    }

    private boolean viewValidParentAllowed() {
        String id = "126";

        GradesService gradesService = new GradesService();

        return gradesService.parentGrades (id).size() == 1;
    }

    private boolean viewValidParentNotAllowed() {
        String id = "125";
        GradesService gradesService = new GradesService();
        return gradesService.parentGrades (id).size() == 1;
    }

    private boolean viewNanParent() {
        String id = "potato";

        GradesService gradesService = new GradesService();

        return gradesService.parentGrades (id).size() == 0;
    }

    private boolean viewNullParent() {
        String id = null;

        GradesService gradesService = new GradesService();

        return gradesService.parentGrades (id).size() == 0;
    }


    //Note, as stated previously, some test had been written prematurely and require the use of other features to be
    //implemented, such as class grades requiring a class feature to be first implemented for it to be accessible
    //As such, these tests are not run.
    public String runTests() {
        return "<br/><br/>Grades Test:"
                +"<br/>roleCheckTeacher: " + (roleCheckTeacher() ? "Passed" : "Failed")
                +"<br/>roleCheckAdmin: " + (roleCheckAdmin() ? "Passed" : "Failed")
                +"<br/>roleCheckStudent: " + (roleCheckStudent() ? "Passed" : "Failed")
                +"<br/>roleCheckParent: " + (roleCheckParent() ? "Passed" : "Failed")
                +"<br/>createValidAssignValidStudentValidGrade: " + (createValidAssignValidStudentValidGrade() ? "Passed" : "Failed")
                +"<br/>createNullAssignValidStudentValidGrade: " + (createNullAssignValidStudentValidGrade() ? "Passed" : "Failed")
                +"<br/>createNanAssignValidStudentValidGrade: " + (createNanAssignValidStudentValidGrade() ? "Passed" : "Failed")
                +"<br/>createNotFoundAssignValidStudentValidGrade: " + (createNotFoundAssignValidStudentValidGrade() ? "Passed" : "Failed")
                +"<br/>createValidAssignNotFoundStudentValidGrade: " + (createValidAssignNotFoundStudentValidGrade() ? "Passed" : "Failed")
                +"<br/>createValidAssignNullStudentValidGrade: " + (createValidAssignNullStudentValidGrade() ? "Passed" : "Failed")
                +"<br/>createValidAssignNanStudentValidGrade: " + (createValidAssignNanStudentValidGrade() ? "Passed" : "Failed")
                +"<br/>createValidAssignValidStudentNullGrade: " + (createValidAssignValidStudentNullGrade() ? "Passed" : "Failed")
                +"<br/>createValidAssignValidStudentEmptyGrade: " + (createValidAssignValidStudentEmptyGrade() ? "Passed" : "Failed")
                +"<br/>createValidAssignValidStudentNanGrade: " + (createValidAssignValidStudentNanGrade() ? "Passed" : "Failed")
                +"<br/>createValidAssignValidStudentNegativeGrade: " + (createValidAssignValidStudentNegativeGrade() ? "Passed" : "Failed")
                +"<br/>updateValidAssignValidStudentValidGrade: " + (updateValidAssignValidStudentValidGrade() ? "Passed" : "Failed")
                +"<br/>updateNullAssignValidStudentValidGrade: " + (updateNullAssignValidStudentValidGrade() ? "Passed" : "Failed")
                +"<br/>updateNanAssignValidStudentValidGrade: " + (updateNanAssignValidStudentValidGrade() ? "Passed" : "Failed")
                +"<br/>updateNotFoundAssignValidStudentValidGrade: " + (updateNotFoundAssignValidStudentValidGrade() ? "Passed" : "Failed")
                +"<br/>updateValidAssignNotFoundStudentValidGrade: " + (updateValidAssignNotFoundStudentValidGrade() ? "Passed" : "Failed")
                +"<br/>updateValidAssignNullStudentValidGrade: " + (updateValidAssignNullStudentValidGrade() ? "Passed" : "Failed")
                +"<br/>updateValidAssignNanStudentValidGrade: " + (updateValidAssignNanStudentValidGrade() ? "Passed" : "Failed")
                +"<br/>updateValidAssignValidStudentNullGrade: " + (updateValidAssignValidStudentNullGrade() ? "Passed" : "Failed")
                +"<br/>updateValidAssignValidStudentEmptyGrade: " + (updateValidAssignValidStudentEmptyGrade() ? "Passed" : "Failed")
                +"<br/>updateValidAssignValidStudentNanGrade: " + (updateValidAssignValidStudentNanGrade() ? "Passed" : "Failed")
                +"<br/>updateValidAssignValidStudentNegativeGrade: " + (updateValidAssignValidStudentNegativeGrade() ? "Passed" : "Failed")
                +"<br/>viewStudentValidAllGrades: " + (viewStudentValidAllGrades() ? "Passed" : "Failed")
                +"<br/>viewTeacherValidAllGrades: " + (viewTeacherValidAllGrades() ? "Passed" : "Failed")
//                +"<br/>viewStudentValidClass: " + (viewStudentValidClass() ? "Passed" : "Failed")
//                +"<br/>viewTeacherValidClass: " + (viewTeacherValidClass() ? "Passed" : "Failed")
                +"<br/>viewInvalidStudentAllGrades: " + (viewInvalidStudentAllGrades() ? "Passed" : "Failed")
//                +"<br/>viewInvalidStudentValidClass: " + (viewInvalidStudentValidClass() ? "Passed" : "Failed")
                +"<br/>viewInvalidTeacherAllGrades: " + (viewInvalidTeacherAllGrades() ? "Passed" : "Failed")
//                +"<br/>viewInvalidTeacherValidClass: " + (viewInvalidTeacherValidClass() ? "Passed" : "Failed")
//                +"<br/>viewStudentInvalidClass: " + (viewStudentInvalidClass() ? "Passed" : "Failed")
//                +"<br/>viewTeacherInvalidClass: " + (viewTeacherInvalidClass() ? "Passed" : "Failed")
//                +"<br/>viewNanStudentValidClass: " + (viewNanStudentValidClass() ? "Passed" : "Failed")
                +"<br/>viewNanTeacherAllGrades: " + (viewNanTeacherAllGrades() ? "Passed" : "Failed")
//                +"<br/>viewNanTeacherValidClass: " + (viewNanTeacherValidClass() ? "Passed" : "Failed")
//                +"<br/>viewStudentNanClass: " + (viewStudentNanClass() ? "Passed" : "Failed")
//                +"<br/>viewTeacherNanClass: " + (viewTeacherNanClass() ? "Passed" : "Failed")
//                +"<br/>viewNullStudentValidClass: " + (viewNullStudentValidClass() ? "Passed" : "Failed")
                +"<br/>viewNullTeacherAllGrades: " + (viewNullTeacherAllGrades() ? "Passed" : "Failed")
//                +"<br/>viewNullTeacherValidClass: " + (viewNullTeacherValidClass() ? "Passed" : "Failed")
//                +"<br/>viewStudentNullClass: " + (viewStudentNullClass() ? "Passed" : "Failed")
//                +"<br/>viewTeacherNullClass: " + (viewTeacherNullClass() ? "Passed" : "Failed")
                +"<br/>viewValidParentAllowed: " + (viewValidParentAllowed() ? "Passed" : "Failed")
                +"<br/>viewValidParentNotAllowed: " + (viewValidParentNotAllowed() ? "Passed" : "Failed")
                +"<br/>viewNanParent: " + (viewNanParent() ? "Passed" : "Failed")
                +"<br/>viewNullParent: " + (viewNullParent() ? "Passed" : "Failed");
    }
}
