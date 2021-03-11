package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.*;

public class UniversityController extends Controller<University>{
	@FXML private ListView<Student> studentLv;
	@FXML private ImageView Logo = new ImageView("/view/logo.png");
	@FXML private Button addBtn;
	@FXML private Button removeBtn;
	@FXML private Button loginBtn;
	
	public final University getUniversity() { return model; };
	
	private Student getStudent() { return studentLv.getSelectionModel().getSelectedItem(); };
	
	public void initialize() {
		removeBtn.setDisable(true);
		loginBtn.setDisable(true);
	}
	
	@FXML private void handleAddStudent(ActionEvent event) throws Exception{
		Student student = new Student(model, null, null, null, false);
		ViewLoader.showStage(student, "/view/add_student.fxml", "Add Student", new Stage());
	}
	
	@FXML private void handleRemoveStudent(ActionEvent event) {
		getStudent().withdrawAll();
		getUniversity().remove(getStudent());
	}
	
	@FXML private void handleLogin(ActionEvent event) throws Exception{
		ViewLoader.showStage(getStudent(), "/view/student.fxml", "Student", new Stage());
	}
	
	@FXML private void handleClickList(MouseEvent event) {
		removeBtn.setDisable(false);
		loginBtn.setDisable(false);
	}

}
