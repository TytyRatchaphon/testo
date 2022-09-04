package ku.cs.appeal_system.controllers;

import javafx.event.ActionEvent;
import ku.cs.appeal_system.models.ComplaintList;
import ku.cs.appeal_system.services.ComplaintFileDataSource;
import ku.cs.appeal_system.services.DataSource;

import java.io.IOException;

public class ComplaintsListController {

    DataSource<ComplaintList> dataSource = new ComplaintFileDataSource();
    ComplaintList complaints = dataSource.readData();

    public void handleBackButton(ActionEvent action){
        try {
            com.github.saacsos.FXRouter.goTo("home_officer");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า home_officer ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

}
