package ku.cs.appeal_system.controllers;

import javafx.event.ActionEvent;
import ku.cs.appeal_system.models.Account;
import ku.cs.appeal_system.models.OfficerAccount;

import java.io.IOException;

public class HomeOfficerController {
    private Account account;
    private OfficerAccount officer;
    public void initialize(){
        account = (Account) com.github.saacsos.FXRouter.getData();
    }

    public void handleComplaintsButton(ActionEvent actionEvent) {
        try {
            com.github.saacsos.FXRouter.goTo("complaints_list");
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า complaints ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
    }

    public void handleLogoutButton(ActionEvent actionEvent) {
        try {
            com.github.saacsos.FXRouter.goTo("login");
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า login ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
    }
    public void handleResetPasswordButton(ActionEvent actionEvent) {
        try {
            com.github.saacsos.FXRouter.goTo("reset",account);
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า reset ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
    }

}