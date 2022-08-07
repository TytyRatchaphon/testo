package ku.cs.appeal_system.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ku.cs.appeal_system.models.Student;
import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import java.io.IOException;

public class RegistrationController {

    private Student student;

    @FXML private Label errorNoticeLabel;
    @FXML private TextField newNameTextField;
    @FXML private TextField newUsernameTextField;
    @FXML private PasswordField newPasswordPasswordField;
    @FXML private PasswordField confirmPasswordPasswordField;

    @FXML
    public void initialize() {
        student = (Student) FXRouter.getData();
    }

    private void showErrorNoticePasswordDidNotMatch() {
        errorNoticeLabel.setText("Those password did not match. Try Again.");
    }

//  private void showErrorNoticeUserAlreadyTaken() {
//      errorNoticeLabel.setText("This user already taken. Please login.");
//  }

    public void handleSubmitButton(ActionEvent actionEvent) { //รับชื่อ username password และใส่ confirm password
        String name = newNameTextField.getText();
        String username = newUsernameTextField.getText();
        String password = newPasswordPasswordField.getText(); //
        String confirmPassword = confirmPasswordPasswordField.getText();

        if (password.equals("") && username.equals("") && name.equals("") && confirmPassword.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("Please fill your information.");

            alert.showAndWait();
        } else if (password.equals(confirmPassword)) {// ในกรณีที่ password กับ confirm password ตรงกัน และผู้ใช้ยังไม่มีบัญชีอยู่ในระบบ
            Student student1 = new Student(name, username, password); // จะส่งค่าไปเก็บที่คลาส Student
            try {
                FXRouter.goTo("login"); // เด้งไปที่หน้า login กรอก username และ password ที่ได้ทำการ register ไป
            } catch (IOException ex) {
                System.err.println("ไปทีหน้า login ไม่ได้");
                System.err.println("ให้ตรวจสอบการกําหนด route");
                System.err.println(ex);
            }
        }

//      else if (ผู้สมัครมีบัญชีใช้งานอยู่แล้ว) {
//          showErrorNoticeUserAlreadyTaken(); //ถ้า username มีอยู่ในระบบอยู่แล้วให้
//      }                                      //showErrorNoticeUserAlreadyTaken() ช่วยแสดง error ตามบรรทัดที่ 32

        else {
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
