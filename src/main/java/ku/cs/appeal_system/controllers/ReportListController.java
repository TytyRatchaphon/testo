package ku.cs.appeal_system.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import ku.cs.appeal_system.models.Complaint;
import ku.cs.appeal_system.models.ComplaintList;
import ku.cs.appeal_system.services.ComplaintFileDataSource;

import java.io.IOException;

public class ReportListController {
    @FXML
    private Label topicLabel;
    @FXML
    private Label detailLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private ListView<Complaint> complaintListView;
    @FXML
    private ComplaintFileDataSource dataSource;
    private ComplaintList complaintList;
    private Complaint selectedComplaint;

    public void initialize() {
        dataSource = new ComplaintFileDataSource();
        dataSource.readData();
        complaintList = dataSource.getAllComplaintList();
        showListView();
        clearSelectedComplaint();
        handleSelectedListView();
    }

    private void showListView() {
        complaintListView.getItems().addAll(complaintList.getAllComplaints());
        complaintListView.refresh();
    }

    private void handleSelectedListView() {
        complaintListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Complaint>() {
                    @Override
                    public void changed(ObservableValue<? extends Complaint> observable,
                                        Complaint oldValue, Complaint newValue) {
                        selectedComplaint = newValue ;
                        showSelectedComplaint(newValue);
                    }
                }
        );
    }

    private void showSelectedComplaint(Complaint report) {
        topicLabel.setText(report.getTopic());
        detailLabel.setText(report.getDetail());
        statusLabel.setText(report.getStatus());
    }

    private void clearSelectedComplaint() {
        topicLabel.setText("");
        detailLabel.setText("");
        statusLabel.setText("");
    }

    public void handleAddReportButton(ActionEvent actionEvent){
        try {
            com.github.saacsos.FXRouter.goTo("student_report");
        } catch (IOException ex) {
            System.err.println("ไปทีหน้า student_report ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนด route");
            System.err.println(ex);
        }
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
