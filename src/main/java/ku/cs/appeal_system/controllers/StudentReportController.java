package ku.cs.appeal_system.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import ku.cs.appeal_system.models.Account;
import ku.cs.appeal_system.models.Complaint;
import ku.cs.appeal_system.models.ComplaintList;
import ku.cs.appeal_system.models.OfficerAccount;
import ku.cs.appeal_system.services.ComplaintFileDataSource;
import ku.cs.appeal_system.services.DataSource;

import java.io.IOException;


public class StudentReportController {

    @FXML
    private TextField reportTopicTextField;
    @FXML
    private TextField reportDetailTextField;
    private String reportStatus = "not completed";

    private Account account;
    public void initialize(){
        account = (Account) com.github.saacsos.FXRouter.getData();
    }

    @FXML public void handleSubmitButton(ActionEvent actionEvent){

        DataSource<ComplaintList> dataSource = new ComplaintFileDataSource();
        ComplaintList Complaints = dataSource.readData();

        String topicStr = reportTopicTextField.getText();
        String detailStr = reportDetailTextField.getText();
        String statusStr = reportStatus;

        Complaints.addComplaint(new Complaint(topicStr,detailStr,statusStr));
        dataSource.writeData(Complaints);

        reportTopicTextField.clear();
        reportDetailTextField.clear();
    }



    public void handleBackButton(ActionEvent actionEvent){
        try {
            com.github.saacsos.FXRouter.goTo("home_student");
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า home_student ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
}
}
