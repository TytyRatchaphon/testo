package ku.cs.appeal_system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ku.cs.appeal_system.models.Officer;
import com.github.saacsos.FXRouter;

import java.io.IOException;

public class OfficeRegistrationController {

    private Officer officer ;
    @FXML
    private Label errorNoticeLabel;
    @FXML private TextField newAgencyTextField;
    @FXML private TextField newNameTextField;
    @FXML private TextField newUsernameTextField;
    @FXML private PasswordField newPasswordPasswordField;
    @FXML private PasswordField confirmPasswordPasswordField;


    @FXML
    public void initialize() {
        officer = (Officer) com.github.saacsos.FXRouter.getData();
    }

    private void showErrorNoticePasswordDidNotMatch() {
        errorNoticeLabel.setText("Those password did not match. Try Again.");
    }

    public void handleSubmitButton(ActionEvent actionEvent) { //รับชื่อ username password และใส่ confirm password
        String agency = newAgencyTextField.getText();
        String name = newNameTextField.getText();
        String username = newUsernameTextField.getText();
        String password = newPasswordPasswordField.getText();
        String confirmPassword = confirmPasswordPasswordField.getText();

        if (password.equals("") && username.equals("") && name.equals("") && confirmPassword.equals("") && agency.equals("")) { // ในกรณีที่ password กับ confirm password ตรงกัน และผู้ใช้ยังไม่มีบัญชีอยู่ในระบบ
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("Please fill your information.");

            alert.showAndWait();

        } else if (password.equals(confirmPassword)) {// ในกรณีที่ password กับ confirm password ตรงกัน และผู้ใช้ยังไม่มีบัญชีอยู่ในระบบ
            Officer officer1 = new Officer(agency,name, username, password); // จะส่งค่าไปเก็บที่คลาส Student
            try {
                FXRouter.goTo("login"); // เด้งไปที่หน้า login กรอก username และ password ที่ได้ทำการ register ไป
            }
            catch (IOException ex) {
                System.err.println("ไปทีหน้า login ไม่ได้");
                System.err.println("ให้ตรวจสอบการกําหนด route");
                System.err.println(ex);
            }
        }

//      else if (ผู้สมัครมีบัญชีใช้งานอยู่แล้ว) {
//          showErrorNoticeUserAlreadyTaken(); //ถ้า username มีอยู่ในระบบอยู่แล้วให้
//      }                                      //showErrorNoticeUserAlreadyTaken() ช่วยแสดง error ตามบรรทัดที่ 32

        else  {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("Password did not match.");

            alert.showAndWait();  //ถ้า password กับ confirm password ไม่ตรงกันแสดง popup ว่า Password did not match.
        }
    }
    public void  handleBackButton(ActionEvent actionEvent){
        try{
            FXRouter.goTo("login");
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า login ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
    }

}
