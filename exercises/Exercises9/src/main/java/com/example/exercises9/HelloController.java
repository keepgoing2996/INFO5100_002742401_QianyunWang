package com.example.exercises9;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class HelloController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btnMultiply;

    @FXML
    private Label outputText;

    @FXML
    private TextField tfNum1;

    @FXML
    private TextField tfNum2;

    @FXML
    void onHelloButtonClick(ActionEvent event) {
        if (event.getSource() == btnClear) {
            tfNum1.setText("");
            tfNum2.setText("");
            outputText.setText("?");
            return;
        }
        String operation = "";
        double ans = 0.0;
        double num1 = Double.parseDouble(tfNum1.getText());
        double num2 = Double.parseDouble(tfNum2.getText());
        if (event.getSource() == btnAdd) {
            operation = " + ";
            ans = num1 + num2;
        } else if (event.getSource() == btnMinus) {
            operation = " - ";
            ans = num1 - num2;
        } else if (event.getSource() == btnMultiply) {
            operation = " * ";
            ans = num1 * num2;
        } else if (event.getSource() == btnDivide) {
            operation = " / ";
            ans = num1 / num2;
        }

        outputText.setText("" + num1 + operation + num2 + " = " + ans);
    }

}

