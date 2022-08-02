package ku.cs.shop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML private TextField usernameTextField;
    @FXML private TextField passwordTextField;

    @FXML
    public void handleLoginButton(ActionEvent actionEvent) {

        // รับข้อมูลจาก TextField ข้อมูลที่รับเป็น String เสมอ
        String usernameString = usernameTextField.getText();
        String passwordString = passwordTextField.getText();
        usernameTextField.clear();
        passwordTextField.clear();
    }

    @FXML
    public void handleRegisterButton(ActionEvent actionEvent){


    }



}
