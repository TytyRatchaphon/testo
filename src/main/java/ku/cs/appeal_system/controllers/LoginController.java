package ku.cs.appeal_system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ku.cs.appeal_system.models.Account;
import com.github.saacsos.FXRouter;

import java.io.IOException;

public class LoginController {
    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordPasswordField;

    @FXML
    public void handleLoginButton(ActionEvent actionEvent) { //มีerror
        // รับข้อมูลจาก TextField ข้อมูลที่รับเป็น String เสมอ
        String usernameString = usernameTextField.getText();
        String passwordString = passwordPasswordField.getText();
        Account account = new Account(usernameString,passwordString);
        if(usernameString != "" && passwordString != ""){
            try {
                FXRouter.goTo("home_after_login",account);
            } catch (IOException ex) {
                System.err.println("ไปทีหน้า home_after_login ไม่ได้");
                System.err.println("ให้ตรวจสอบการกําหนด route");
                }
        }
        else if(usernameString.equals("") && passwordString.equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("Please fill your information.");

            alert.showAndWait();
        }
    }

    public void handleRegisterButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("register");
        }
        catch (IOException ex) {
            System.err.println("ไปทีหน้า register ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
    }

    public void handleOfficerRegisterButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("officer_register");
        }
        catch (IOException ex) {
            System.err.println("ไปทีหน้า register ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
    }
    public void handleResetPasswordButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("reset");
        }
        catch (IOException ex) {
            System.err.println("ไปทีหน้า reset ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
    }

}