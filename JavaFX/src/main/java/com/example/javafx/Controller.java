package com.example.javafx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label ourLabel;

    public void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }
    @FXML
    public void onButtonClicked(ActionEvent e) {
        if(e.getSource().equals(helloButton)){
            System.out.println("Hello "+nameField.getText());
        } else if (e.getSource().equals(byeButton)){
            System.out.println("Bye "+nameField.getText());
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "UI thread" : "background thread";
                    System.out.println(s);
                    Thread.sleep(3000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI thread" : "background thread";
                            System.out.println(s);
                            ourLabel.setText("Text changed");
                        }
                    });
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };

        new Thread(task).start();

        if(ourCheckBox.isSelected()) {
            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
    }
    @FXML
    public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    @FXML
    public void handleChange() {
        System.out.println("The checkbox is " + (ourCheckBox.isSelected() ? "checked" : "not checked"));
    }

}