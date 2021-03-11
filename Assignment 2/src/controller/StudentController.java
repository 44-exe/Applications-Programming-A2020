package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import model.*;

public class StudentController extends Controller<Student> {
	@FXML private Button withdrawBtn;
	@FXML private Button enrolBtn;
	@FXML private Button logoutBtn;
	@FXML private HBox tableSpacer1;
	@FXML private HBox tableSpacer2;
	@FXML private TableView<Activity> activitiesTv;
	@FXML private TableView<Activity> subjectTv;
	@FXML private ComboBox enrolCmb;	
	
	private int sub;
	
	public final Student getStudent() { return model; };
	private Activity getActivities() { return subjectTv.getSelectionModel().getSelectedItem(); }
	
	public void initialize() {
		HBox.setHgrow(tableSpacer1, Priority.ALWAYS);
		HBox.setHgrow(tableSpacer2, Priority.ALWAYS);
		activitiesTv.setItems(getStudent().getActivities());
		
		subjectTv.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldSubject, newSubject) ->
				enrolBtn.setDisable(newSubject == null));
		
		activitiesTv.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldActivities, newActivities) ->
				withdrawBtn.setDisable(newActivities == null));
	}
	
	@FXML private void handleComboBox(ActionEvent event) throws Exception {
		String newCmbStr = enrolCmb.getSelectionModel().getSelectedItem().toString();
		
		if(newCmbStr != null) {
			switch(newCmbStr) {
				case "48024 Applications Programming":
					subjectTv.setItems(getStudent().getUniversity().getSubjects().get(0).getActivities());
					sub = 0;
					newCmbStr = null;
					break;
					
				case "31284 Web Services Development":
					subjectTv.setItems(getStudent().getUniversity().getSubjects().get(1).getActivities());
					sub = 1;
					newCmbStr = null;
					break;
			}
		}
	}
	
	@FXML private void handleWithdraw(ActionEvent event) throws Exception {
		//remove the activity from activitiesTv
		//update the view of the student activities
		getStudent().withdraw(activitiesTv.getSelectionModel().getSelectedItem());
		activitiesTv.setItems(getStudent().getActivities());
		subjectTv.refresh();
	}
	
	@FXML private void handleEnrol(ActionEvent event) throws Exception {
		//if enrol is available
		Activity act = subjectTv.getSelectionModel().getSelectedItem();
		if (act.canEnrol())
		{
			//if student is not already enrolled in the activity
			if (!(getStudent().isEnrolledIn(act)))
			{
				if (getStudent().activity(act.getSubjectNumber(), act.getGroup()) != null)
					getStudent().withdraw(getStudent().activity(act.getSubjectNumber(), act.getGroup()));
					getStudent().enrol(getActivities());
			}
		}
		activitiesTv.setItems(getStudent().getActivities());
		subjectTv.refresh();
		enrolBtn.setDisable(true);
	}
	
	@FXML private void handleClickTable(MouseEvent event) {
		enrolBtn.setDisable(!(subjectTv.getSelectionModel().getSelectedItem().canEnrol()));
	}
	
	@FXML private void handleLogout(ActionEvent event) throws Exception {
		stage.close();
	}
}
