package ku.cs.appeal_system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ku.cs.appeal_system.models.Account;
import ku.cs.appeal_system.models.AccountList;
import ku.cs.appeal_system.models.OfficerAccount;
import ku.cs.appeal_system.services.AccountFileDataSource;
import ku.cs.appeal_system.services.DataSource;

import java.io.IOException;
import java.time.LocalDateTime;
import ku.cs.appeal_system.models.Account;

public class RegisterOfficerController {
    @FXML private TextField newNameTextField;
    @FXML private TextField newLastNameTextField;
    @FXML private TextField agencyTextField;
    @FXML private TextField newUserNameTextField;
    @FXML private PasswordField newPasswordPasswordField;
    @FXML private PasswordField confirmPasswordField;

    @FXML
    public void handleSubmitButton(ActionEvent event) {
        //เขียนอ่านไฟล์
        DataSource<AccountList> dataSource = new AccountFileDataSource();
        AccountList accounts = dataSource.readData();

        // รับข้อมูล จาก nameTextField ข้อมูลที่รับเป็น String เสมอ
        String nameStr = newNameTextField.getText(); // ตัวแปร name
        // รับข้อมูล จาก lastNameTextField ข้อมูลที่รับเป็น String เสมอ
        String lastnameStr = newLastNameTextField.getText(); // ตัวแปร lastName
        // รับข้อมูล จาก userNameTextField ข้อมูลที่รับเป็น String เสมอ
        String agency = agencyTextField.getText(); // ตัวแปร agency
        //รรับข้อมูล จาก agencyTextField ข้อมูลที่รับเป็น String เสมอ
        String usernameStr = newUserNameTextField.getText(); // ตัวแปร userName
        // รับข้อมูล จาก PasswordField ข้อมูลที่รับเป็น String เสมอ
        String passwordStr = newPasswordPasswordField.getText(); // ตัวแปร password
        // รับข้อมูล จาก PasswordField ข้อมูลที่รับเป็น String เสมอ
        String confirmPasswordStr = confirmPasswordField.getText(); // ตัวแปร confirmPassword
        String status = "Officer";
        Integer countLogin = 0;
        String lastLogin = String.valueOf(LocalDateTime.now());



        if ((usernameStr.equals("") || nameStr.equals("") || lastnameStr.equals("") || passwordStr.equals("") || confirmPasswordStr.equals(""))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("Please check your information and try again.");

            alert.showAndWait();
        } else {
            //check ช้อมูลซ้ำ --> ว่าใน account list มี usernameStr ซ้ำไหม ถ้าซ้ำจะสมัครไม่ได้
            if (accounts.checkUsername(usernameStr)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error!!");
                alert.setHeaderText(null);
                alert.setContentText("Username is unavailable");

                alert.showAndWait();
            } else {
                if (!passwordStr.equals(confirmPasswordStr)) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error!!");
                    alert.setHeaderText(null);
                    alert.setContentText("Password is not match.");

                    alert.showAndWait();

                } else {
                    //เขียนไฟล์ --> new Account
                    accounts.addAccount(new OfficerAccount(nameStr,lastnameStr,usernameStr,passwordStr,status,agency,countLogin));
                    dataSource.writeData(accounts);

                    try {
                        com.github.saacsos.FXRouter.goTo("login");
                    } catch (IOException e) {
                        System.err.println("ไปที่หน้า login ไม่ได้");
                        System.err.println("ให้ตรวจสอบการกำหนด route");
                    }
                }
            }

        }
    }
    public void handleBackButton(ActionEvent action){
        try {
            com.github.saacsos.FXRouter.goTo("home_admin");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า login ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }


}
