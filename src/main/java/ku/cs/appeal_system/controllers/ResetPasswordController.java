package ku.cs.appeal_system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import ku.cs.appeal_system.models.Account;
import com.github.saacsos.FXRouter;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;

public class ResetPasswordController {
    @FXML private TextField usernameTextField;
    @FXML private PasswordField currentPasswordField;
    @FXML private PasswordField newPasswordField;
    @FXML private PasswordField confirmNewPasswordField;

    private Account account;

    public void initialize(){
        account = (Account)FXRouter.getData();
    }
    //private Account loginAccount;

    public void handleSaveButton(ActionEvent actionEvent){
        String usernameString = usernameTextField.getText();
        String currentPasswordString = currentPasswordField.getText();
        String newPasswordString = newPasswordField.getText();
        String confirmPasswordString = confirmNewPasswordField.getText();
        if (currentPasswordString.equals("") && newPasswordString.equals("") && confirmPasswordString.equals("") && usernameString.equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("Please fill your information.");

            alert.showAndWait();
        } else if (newPasswordString.equals(currentPasswordString)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("New password must different from current password.");

            alert.showAndWait();
        } else if (confirmPasswordString.equals("") && !newPasswordString.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("You must enter the same password twice in order to confirm password.");

            alert.showAndWait();
        } else if (!confirmPasswordString.equals(newPasswordString)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("New password and confirmation password must be the same.");

            alert.showAndWait();
        } else{
            //loginAccount.setPassword(newPasswordString);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success!!");
            alert.setHeaderText(null);
            alert.setContentText("Password change success.");

            alert.showAndWait();

            try {
                if(account.getType().equals("Admin")){
                    FXRouter.goTo("home_admin");
                }
                else if(account.getType().equals("Officer")){
                    FXRouter.goTo("home_officer");
                }
                else if(account.getType().equals("User")){
                    FXRouter.goTo("home_student");
                }
            } catch (IOException e) {
                System.err.println("ไปที่หน้า login ไม่ได้");
                System.err.println("ให้ตรวจสอบการกำหนด route");
            }
        }

    }
    public void handleBackButton(ActionEvent action){
        try {
            if(account.getType().equals("Admin")){
                FXRouter.goTo("home_admin");
            }
            else if(account.getType().equals("Officer")){
                FXRouter.goTo("home_officer");
            }
            else if(account.getType().equals("User")){
                FXRouter.goTo("home_student");
            }

        } catch (IOException e) {
            System.err.println("ไปที่หน้า login ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}

