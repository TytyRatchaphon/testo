package ku.cs.appeal_system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ku.cs.appeal_system.models.Account;
import ku.cs.appeal_system.models.OfficerAccount;
import com.github.saacsos.FXRouter;

import java.io.IOException;

public class HomeStudentController {
    @FXML private Label typeLabel;
    @FXML private Label userNameLabel;
    @FXML public ImageView userImageView;

    public Account loginAccount;

    public  void initialize(){
        loginAccount = (Account) FXRouter.getData();
        showAccountData(loginAccount);
    }
    private void showAccountData(Account loginAccount){
        typeLabel.setText(loginAccount.getType());
        userNameLabel.setText(loginAccount.getUsername());
        userImageView.setImage(new Image("file:"+loginAccount.getImagePath(), true));
    }
    @FXML
    public void handleReportButton(ActionEvent actionEvent) {
        try {
            com.github.saacsos.FXRouter.goTo("report_list");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า Report ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
            System.err.println(e);
        }
    }
//
//    @FXML
//    public void handleResetPasswordButton(ActionEvent actionEvent) {
//        try {
//            com.github.saacsos.FXRouter.goTo("reset", account);
//        } catch (IOException ex) {
//            System.err.println("ไปทีหน้า Reset ไม่ได้");
//            System.err.println("ให้ตรวจสอบการกําหนด route");
//            System.err.println(ex);
//        }
//    }
//
//    public void handleLogoutButton(ActionEvent actionEvent) {
//        try {
//            com.github.saacsos.FXRouter.goTo("login");
//        } catch (IOException ex) {
//            System.err.println("ไปทีหน้า login ไม่ได้");
//            System.err.println("ให้ตรวจสอบการกําหนด route");
//            System.err.println(ex);
//        }
//    }
}
