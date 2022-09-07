package ku.cs.appeal_system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ku.cs.appeal_system.models.Account;
import ku.cs.appeal_system.models.OfficerAccount;

import java.io.IOException;

public class HomeStudentController {

    private Account account;

    public void initialize() {
        account = (Account) com.github.saacsos.FXRouter.getData();
    }

    @FXML
    public void handleReportButton(ActionEvent event) {
        try {
            com.github.saacsos.FXRouter.goTo("student_report");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า Report ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
            System.err.println(e);
        }
    }

    @FXML
    public void handleResetPasswordButton(ActionEvent actionEvent) {
        try {
            com.github.saacsos.FXRouter.goTo("reset", account);
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า Reset ไม่ได้");
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
}
