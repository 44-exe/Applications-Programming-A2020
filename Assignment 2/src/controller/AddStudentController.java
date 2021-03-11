package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import model.*;

public class AddStudentController extends Controller<Student>{
	@FXML private TextField numberTf;
	@FXML private TextField nameTf;
	@FXML private ToggleGroup attendanceTg;
	@FXML private CheckBox scholarCb;
	@FXML private Button cancelBtn;
	@FXML private Button addBtn;
	@FXML private Text errorTxt = new Text();
	
	boolean atten = true;

    private String getNumber() { return numberTf.getText(); }
    private String getName() { return nameTf.getText(); }
    private String getAttendance() { return attendanceTg.getSelectedToggle().getUserData().toString(); }
	public final Student getStudent() { return model; };
    
	public void initialize() {
		addBtn.setDisable(true);
		errorTxt.setVisible(false);
	}
    
	public void studentIDProperty() {
		boolean isDisabled = (numberTf.getText().isEmpty() || numberTf.getText().trim().isEmpty() || nameTf.getText().isEmpty() || nameTf.getText().trim().isEmpty() || atten || scholarCb.isSelected());
		addBtn.setDisable(isDisabled);
	}
	
	public void studentAttendanceProperty() {
		if (getAttendance().isEmpty())
			atten = true;
		else
			atten = false;
		boolean isDisabled = (numberTf.getText().isEmpty() || numberTf.getText().trim().isEmpty() || nameTf.getText().isEmpty() || nameTf.getText().trim().isEmpty() || atten || scholarCb.isSelected());
		addBtn.setDisable(isDisabled);
	}
    
	@FXML private void handleCancel(ActionEvent event) {
		//dont add anything and close window
		stage.close();
	}
    
	@FXML private void handleAddStudent(ActionEvent event) throws Exception {
		//check if student already exists (compare student number)
		//if new student add the student and then close the window
		//if student exists print "Student already exists" as shown in the image
		University uni = getStudent().getUniversity();
		if (!uni.searchStudent(getNumber()))
		{
			uni.addStudent(getNumber(), getName(), getAttendance(), scholarCb.isSelected());
			getStudent().scholarSetProperty();
			stage.close();
		}
		else
		{
			errorTxt.setVisible(true);
		}
	}
	
	

}
