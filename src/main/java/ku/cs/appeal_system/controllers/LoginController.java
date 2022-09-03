package ku.cs.appeal_system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ku.cs.appeal_system.models.Account;
import com.github.saacsos.FXRouter;
import ku.cs.appeal_system.models.AccountList;
import ku.cs.appeal_system.services.AccountFileDataSource;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;

    public Account loginAccount;

    private AccountList accountList;
    private AccountFileDataSource dataSource;


    @FXML public void handleLoginButton(ActionEvent event) {
        String usernameStr = usernameTextField.getText();
        String passwordStr = passwordPasswordField.getText();

        dataSource = new AccountFileDataSource();
        dataSource.readData();
        accountList = dataSource.getAllAccountList();

        // --> return ข้อมูล account ของคนที่ username นี้
        loginAccount = accountList.searchUsername(usernameStr);

        // หา login account ไม่เจอ
        if (loginAccount == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("Please check your information and try again.");

            alert.showAndWait();
        } else {
            if ((loginAccount.isBanned())) {

                Account account = accountList.searchUsername(loginAccount.getUsername());
                //เพิ่มจำนวน การพยายามเข้าใช้งาน ของ user ที่ถูกแบน
                dataSource.writeData(accountList);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error!!");
                alert.setHeaderText(null);
                alert.setContentText("This account was banned.");

                alert.showAndWait();

            }
            //user ผิด passผิด
            //login ได่ แยกเป็นadmin officer student

        }

        // clear ช่อง TextField
        usernameTextField.clear();
        passwordPasswordField.clear();

    }




    public void handleRegisterButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("register");
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า register ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
    }

    public void handleResetPasswordButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("reset");
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า reset ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
    }
}