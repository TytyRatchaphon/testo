package ku.cs.appeal_system.controllers.Admin;

import javafx.event.ActionEvent;
import ku.cs.appeal_system.models.Account;

import java.awt.*;
import java.io.IOException;

public class HomeAdminController {
    private Account account;
    private Label usernameLabel;

    private void showMemberCardData() {
        usernameLabel.setText(account.getUsername());
    }


    public void handleRegisterOfficerButton(ActionEvent actionEvent) {
        try {
            com.github.saacsos.FXRouter.goTo("");
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า register ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
    }

    public void handleResetPasswordButton(ActionEvent actionEvent) {
        try {
            com.github.saacsos.FXRouter.goTo("reset");
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า reset ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
    }

    public void handleUserListButton(ActionEvent actionEvent){
        try {
            com.github.saacsos.FXRouter.goTo("user_name_list");
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า reset ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
    }

    public void handleReportButton(ActionEvent actionEvent){
        try {
            com.github.saacsos.FXRouter.goTo("report_insecurity");
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า reset ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
    }

    public void handleLogoutButton(ActionEvent actionEvent){
        try {
            com.github.saacsos.FXRouter.goTo("home");
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า reset ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
    }
}
