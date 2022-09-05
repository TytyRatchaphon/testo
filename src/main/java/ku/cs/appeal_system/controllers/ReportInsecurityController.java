package ku.cs.appeal_system.controllers;

import javafx.event.ActionEvent;
import ku.cs.appeal_system.models.AccountList;
import ku.cs.appeal_system.services.AccountFileDataSource;
import ku.cs.appeal_system.services.DataSource;

import java.io.IOException;

public class ReportInsecurityController {
    DataSource<AccountList> dataSource = new AccountFileDataSource();
    AccountList accounts = dataSource.readData();

    public void handleBackButton(ActionEvent actionEvent){
        try {
            com.github.saacsos.FXRouter.goTo("home_admin");
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า reset ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
    }
}
