package ku.cs.shop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ku.cs.shop.models.Account;

import java.io.IOException;

public class LoginController {
    @FXML private TextField usernameTextField;
    @FXML private TextField passwordTextField;

    @FXML
    public void handleLoginButton(ActionEvent actionEvent) {
        // รับข้อมูลจาก TextField ข้อมูลที่รับเป็น String เสมอ
        String usernameString = usernameTextField.getText();
        String passwordString = passwordTextField.getText();
        Account account = new Account(usernameString,passwordString);
        try {
            if(usernameString != "\0" && passwordString != "\0"){
                com.github.saacsos.FXRouter.goTo("home_after_login",account);
            }
        } catch (IOException ex) {
            System.err.println("ไปที7หน้าhome ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนดroute");
        }
    }






}
