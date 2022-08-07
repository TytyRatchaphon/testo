package ku.cs.shop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ku.cs.shop.models.Account;
import com.github.saacsos.FXRouter;
import ku.cs.shop.models.Student;

import java.io.IOException;

public class LoginController {
    @FXML private TextField usernameTextField;
    @FXML private TextField passwordTextField;

    @FXML
    public void handleLoginButton(ActionEvent actionEvent) { //มีerror
        // รับข้อมูลจาก TextField ข้อมูลที่รับเป็น String เสมอ
        String usernameString = usernameTextField.getText();
        String passwordString = passwordTextField.getText();
        Account account = new Account(usernameString,passwordString);
        try {
            if(usernameString != "\0" && passwordString != "\0"){
                FXRouter.goTo("home_after_login",account);
            }
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนดroute");
        }
    }

    public void handleRegisterButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("register");
        }
        catch (IOException ex) {
            System.err.println("ไปทีหน้าregisterไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนดroute");
            System.err.println(ex);
        }
    }

    public void handleOfficerRegisterButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("officer_register");
        }
        catch (IOException ex) {
            System.err.println("ไปทีหน้าregisterไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนดroute");
            System.err.println(ex);
        }
    }
}