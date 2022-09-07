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


        loginAccount = accountList.searchUsername(usernameStr);

        // หา login account ไม่เจอ
        if (loginAccount == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("Please check your information and try again.");

            alert.showAndWait();
        }
        if ((loginAccount.isBanned())) {

                Account account = accountList.searchUsername(loginAccount.getUsername());
                account.setLoginCount();
                dataSource.writeData(accountList);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error!!");
                alert.setHeaderText(null);
                alert.setContentText("This account was banned.");

                alert.showAndWait();

            } else {
                //check password ของ loginAccount ว่า ตรงกับที่ user กรอกเข้ามา
                if (!(loginAccount.isPassword(passwordStr))) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error!!");
                    alert.setHeaderText(null);
                    alert.setContentText("Please check your Password.");

                    alert.showAndWait();
                }else{
                    Account account = accountList.searchUsername(loginAccount.getUsername());
                    dataSource.writeData(accountList);

                    if(loginAccount.getType().equals("User")){
                        try {
                            FXRouter.goTo("home_student",loginAccount);
                        } catch (IOException e) {
                            System.err.println("ไปที่หน้า System for user ไม่ได้");
                            System.err.println("ให้ตรวจสอบการกำหนด route");
                        }
                    }

                    if(loginAccount.getType().equals("Admin")){
                        try {
                            FXRouter.goTo("home_admin",loginAccount);
                        } catch (IOException e) {
                            System.err.println("ไปที่หน้า System for admin ไม่ได้");
                            System.err.println("ให้ตรวจสอบการกำหนด route");
                        }
                    }

                    if(loginAccount.getType().equals("Officer")){
                        try {
                            FXRouter.goTo("home_officer",loginAccount);
                        } catch (IOException e) {
                            System.err.println("ไปที่หน้า System for officer ไม่ได้");
                            System.err.println("ให้ตรวจสอบการกำหนด route");
                        }
                    }
                }

                // clear ช่อง TextField
                usernameTextField.clear();
                passwordPasswordField.clear();

            }
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

    public void handleBackButton(ActionEvent action){
        try {
            com.github.saacsos.FXRouter.goTo("home");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า login ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}