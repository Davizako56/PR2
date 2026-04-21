package org.example.practica2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private TextField niaTextField;

    @FXML
    private TextField nombreTextField;

    @FXML
    private DatePicker nacimientoDatePicker;

    public void insertarButton() {

    }

    public void guardarButton() {


    }
}
