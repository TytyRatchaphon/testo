package ku.cs.appeal_system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ku.cs.appeal_system.models.Account;
import ku.cs.appeal_system.models.AccountList;
import ku.cs.appeal_system.services.AccountFileDataSource;
import ku.cs.appeal_system.services.DataSource;

import java.io.IOException;

public class RegisterOfficerController {
    @FXML private TextField nameTextField;
    @FXML private TextField lastnameTextField;
    @FXML private TextField agencyTextField;
    @FXML private TextField userNameTextField;
    @FXML private PasswordField password;
    @FXML private PasswordField confirmPassword;

    @FXML
    public void handleSubmitButton(ActionEvent event) {
        //เขียนอ่านไฟล์
        DataSource<AccountList> dataSource = new AccountFileDataSource();
        AccountList accounts = dataSource.readData();

        // รับข้อมูล จาก nameTextField ข้อมูลที่รับเป็น String เสมอ
        String nameStr = nameTextField.getText(); // ตัวแปร name
        // รับข้อมูล จาก lastNameTextField ข้อมูลที่รับเป็น String เสมอ
        String lastnameStr = lastnameTextField.getText(); // ตัวแปร lastName
        // รับข้อมูล จาก userNameTextField ข้อมูลที่รับเป็น String เสมอ
        String agency = agencyTextField.getText(); // ตัวแปร agency
        //รรับข้อมูล จาก agencyTextField ข้อมูลที่รับเป็น String เสมอ
        String usernameStr = userNameTextField.getText(); // ตัวแปร userName
        // รับข้อมูล จาก PasswordField ข้อมูลที่รับเป็น String เสมอ
        String passwordStr = password.getText(); // ตัวแปร password
        // รับข้อมูล จาก PasswordField ข้อมูลที่รับเป็น String เสมอ
        String confirmPasswordStr = confirmPassword.getText(); // ตัวแปร confirmPassword



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
                    alert.setContentText("Please check your information and try again.");

                    alert.showAndWait();

                } else {
                    //เขียนไฟล์ --> new Account
                    accounts.addAccount(new Account(nameStr,lastnameStr ,usernameStr ,passwordStr ));
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
            com.github.saacsos.FXRouter.goTo("login");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า login ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }


}
