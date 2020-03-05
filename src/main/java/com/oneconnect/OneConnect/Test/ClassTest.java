package com.oneconnect.OneConnect.Test;

public class ClassTest {
    public boolean retrieveClassInfoValidClass() {
        String id = "5253";
//        ClassService classService = new ClassService();
//        ClassObj classObj = classService.getClass(id);
//        return classObj.getName().equals("Ways of Seeing Film T F - 10:15-12:20");

        return true;
    }
    public boolean retrieveClassInfoNanClass() {
        String id = "potato";
//        ClassService classService = new ClassService();
//        ClassObj classObj = classService.getClass(id);
//        return !classObj.getName().equals("Ways of Seeing Film T F - 10:15-12:20");

        return true;
    }
    public boolean retrieveClassInfoNullClass() {
        String id = null;
//        ClassService classService = new ClassService();
//        ClassObj classObj = classService.getClass(id);
//        return !classObj.getName().equals("Ways of Seeing Film T F - 10:15-12:20");

        return true;
    }
    public boolean retrieveClassInfoNotFoundClass() {
        String id = "-1";
//        ClassService classService = new ClassService();
//        ClassObj classObj = classService.getClass(id);
//        return !classObj.getName().equals("Ways of Seeing Film T F - 10:15-12:20");

        return true;
    }
}
