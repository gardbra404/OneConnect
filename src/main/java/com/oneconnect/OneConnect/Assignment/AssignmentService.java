package com.oneconnect.OneConnect.Assignment;

import com.oneconnect.OneConnect.Grades.Assignment;
import com.oneconnect.OneConnect.Utility;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AssignmentService {
    public List<Assignment> getAssignments(String classId) {
        Utility utility = new Utility();
        List<Assignment> assignments = new ArrayList<>();
        JSONArray assignFile = utility.jsonArrayGenerator("Assignments.json");
        for (int i = 0; i < assignFile.size(); i++) {
            JSONObject assign = (JSONObject) assignFile.get(i);
            if (assign.get("class").equals(classId)){
                Assignment assignment = new Assignment(
                        (String) assign.get("id"),
                        (String) assign.get("title")
                );
                assignments.add(assignment);
            }
        }
        return assignments;
    }

    public Assignment getAssignment (String assignmentId) {
        Assignment assignment = null;
        Utility utility = new Utility();

        JSONArray assignFile = utility.jsonArrayGenerator("Assignments.json");
        for (int i = 0; i < assignFile.size(); i++) {
            JSONObject assign = (JSONObject) assignFile.get(i);
            if (assign.get("id").equals(assignmentId)){
                assignment = new Assignment();
                assignment.setScore((String)assign.get("maxScore"));
                assignment.setDescription((String)assign.get("description"));
                assignment.setName((String)assign.get("title"));
                break;
            }
        }
        return assignment;
    }

    public boolean addAssignment(String classId, String title, String score, String description) {
        Utility utility = new Utility();
        boolean added = false;
        if (utility.numberChecker(classId) && utility.numberChecker(score) && utility.stringChecker(title) && utility.stringChecker(description)) {
            String asssignmentId = utility.newIdGenerator();
            JSONObject newAssignment = new JSONObject();
            newAssignment.put("id", asssignmentId);
            newAssignment.put("class", classId);
            newAssignment.put("title", title);
            newAssignment.put("description", description);
            newAssignment.put("maxScore", score);
            JSONArray assignments = utility.jsonArrayGenerator("Assignments.json");
            assignments.add(newAssignment);
            added = utility.jsonWriter(assignments.toJSONString(), "Assignments.json");
            if (added) {
                added = addAssignmentToClass(asssignmentId, classId);
            }
        }
        return added;
    }

    private boolean addAssignmentToClass(String assignmentId, String classId) {
        boolean added = false;
        Utility utility = new Utility();
        if (utility.numberChecker(assignmentId) && utility.numberChecker(classId)) {
            JSONArray copyClasses = new JSONArray();
            JSONArray classes = utility.jsonArrayGenerator("Class.json");
            for (int i = 0; i < classes.size(); i++) {
                JSONObject classObj = (JSONObject) classes.get(i);
                if (classObj.get("id").equals(classId)) {
                    JSONArray assignments = (JSONArray) classObj.get("assignments");
                    assignments.add(assignmentId);
                    classObj.put("assignments", assignments);
                }
                copyClasses.add(classObj);
            }
            added = utility.jsonWriter(copyClasses.toJSONString(), "Class.json");
        }
        return added;
    }
}
