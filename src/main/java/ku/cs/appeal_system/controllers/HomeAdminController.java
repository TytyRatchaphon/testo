package ku.cs.appeal_system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ku.cs.appeal_system.models.Account;

import java.awt.*;
import java.io.IOException;
import com.github.saacsos.FXRouter;

public class HomeAdminController {


    private Account account;

    public void handleRegisterOfficerButton(ActionEvent actionEvent) {
        try {
            com.github.saacsos.FXRouter.goTo("register_officer");
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
