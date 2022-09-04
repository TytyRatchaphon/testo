package ku.cs.appeal_system.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import ku.cs.appeal_system.models.Complaint;
import ku.cs.appeal_system.models.ComplaintList;
import ku.cs.appeal_system.services.ComplaintFileDataSource;
import ku.cs.appeal_system.services.DataSource;

import java.io.IOException;

public class ComplaintsListController {
    @FXML
    private ListView<Complaint> complaintListView;
    @FXML
    private Label complaintTopicLabel;
    @FXML
    private Label complaintDetailLabel;
    @FXML
    private Label complaintStatusLabel;

    DataSource<ComplaintList> dataSource = new ComplaintFileDataSource();

    ComplaintList complaints = dataSource.readData();

    public void initialize() {
        showListView();
        clearSelectedComplaint();
        handleSelectedListView();
    }

    private void showListView() {
        complaintListView.getItems().addAll(complaints.getAllComplaints());
        complaintListView.refresh();
    }

    public void handleSelectedListView() {
        complaintListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Complaint>() {
                    @Override
                    public void changed(ObservableValue<? extends Complaint> observable,
                                        Complaint oldValue, Complaint newValue) {
                        System.out.println(newValue + " is selected");
                        showSelectedComplaint(newValue);
                    }
                });
    }

    private void showSelectedComplaint(Complaint complaint) {
        complaintTopicLabel.setText(complaint.getTopic());
        complaintDetailLabel.setText(complaint.getDetail());
        complaintStatusLabel.setText(complaint.getStatus());
    }

    public void clearSelectedComplaint() {
        complaintTopicLabel.setText("");
        complaintDetailLabel.setText("");
        complaintStatusLabel.setText("");
    }

    public void handleBackButton(ActionEvent action){
        try {
            com.github.saacsos.FXRouter.goTo("home_officer");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า home_officer ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}