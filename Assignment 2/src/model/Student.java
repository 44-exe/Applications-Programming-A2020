package model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Student {
    private University university;
    private StringProperty number = new SimpleStringProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty attendance = new SimpleStringProperty();
    private StringProperty scholar = new SimpleStringProperty();
    private boolean scholarship;
    private ObservableList<Activity> activities = FXCollections.observableArrayList();

    public Student(University university, String number, String name, String attendance, boolean scholarship) {
        this.university = university;
        this.number.set(number);
        this.name.set(name);
        this.attendance.set(attendance);
        this.scholarship = scholarship;
        scholarSetProperty();
    }
    
    public University getUniversity() { return university; }
    public String getNumber() { return number.get(); }
    public final String getName() { return name.get(); }
    public ReadOnlyStringProperty nameProperty() { return name; }
    public String getAttendance() { return attendance.get(); }
    public ReadOnlyStringProperty attendanceProperty() { return attendance; }
    public String getScholar() { return scholar.get(); }
    public ReadOnlyStringProperty scholarProperty() { return scholar; }
    public boolean getScholarship() { return scholarship; }
    public ObservableList<Activity> getActivities() { return activities; }

    
    public void scholarSetProperty() {
    	if (scholarship)
    		scholar.set("Yes");
    	else
    		scholar.set("No");
    }
    
    public boolean isEnrolledIn(Activity activity) {
        return activities.contains(activity);
    }

    public boolean matches(String number) {
        return this.number.get().equals(number);
    }

    public void enrol(Activity activity) {
        // You should first check if the student is already enrolled
        // in an existing activity with the same subject and group.
        // If so, the student should be withdrawn from that activity first.
        // See Lecture 5 for hints.
        activities.add(activity);
        activity.enrol();
    }

    public void withdraw(Activity activity) {
        activities.remove(activity);
        activity.withdraw();
    }

    public void withdrawAll() {
    	for (Activity activity : activities)
            activity.withdraw();
    	activities.removeAll();
    }
    
    // This lookup function should be useful to check if a student is
    // already enrolled in an activity.
    public Activity activity(int subjectNumber, String group) {
        for (Activity activity : activities)
            if (activity.matches(subjectNumber, group))
                return activity;
        return null;
    }

    @Override
    public String toString() {
        return number.get() + " - " + name.get();
    }
}
