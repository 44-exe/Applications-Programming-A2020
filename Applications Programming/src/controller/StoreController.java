package controller;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class StoreController extends Controller<Store>{
	@FXML private ListView<Product> productsLv;
	@FXML private Button openBtn;
	
    @FXML private Text cashTxt = new Text();
	
	public final Store getStore() { return model; };
		
	private Product getGroup() { return productsLv.getSelectionModel().getSelectedItem(); };
	
	@FXML private void initialize() {
        cashTxt.textProperty().bind(getStore().getCashRegister().cashProperty().asString("$%.2f"));
	}
	
	@FXML private void handleOpen(ActionEvent event) throws Exception{
        ViewLoader.showStage(getGroup(), "/view/product.fxml", "Store", new Stage());
	}
	
	@FXML private Product getSelectedProduct() {
		return productsLv.getSelectionModel().getSelectedItem();
	}
}

