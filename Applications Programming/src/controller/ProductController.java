package controller;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class ProductController extends Controller<Product> {
    @FXML private TextField amountTf;

    public final Product getProduct() { return model; }
    private int getAmount() { return Integer.parseInt(amountTf.getText()); }
    private void setAmount(int amount) { amountTf.setText("" + amount); }

    @FXML private void handleSell(ActionEvent event) {
        int amount = getAmount();
        if (getProduct().has(amount)) {
            getProduct().sell(getAmount());
            setAmount(0);
        }
    }
    
    @FXML private void handleOpen(ActionEvent event) throws Exception {
        ViewLoader.showStage(getProduct(), "/view/product.fxml", "Stadium", new Stage());
    }
    

}
