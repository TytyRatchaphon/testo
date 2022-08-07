package ku.cs.appeal_system.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.appeal_system.models.Account;

public class HomeAfterLoginController {
    private Account account;
    @FXML
    private Label usernameLabel;

    public void initialize(){
        System.out.println("initialize MemberCardDetailController");
        account = (Account) com.github.saacsos.FXRouter.getData();
        showMemberCardData();
    }


    private void showMemberCardData() {
        usernameLabel.setText(account.getUsername());
    }
}
