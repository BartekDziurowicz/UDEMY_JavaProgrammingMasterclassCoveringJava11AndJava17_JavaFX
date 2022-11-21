package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nameField;

    public void onButtonClicked() {
        System.out.println("Hello, " + nameField.getText());
    }

}