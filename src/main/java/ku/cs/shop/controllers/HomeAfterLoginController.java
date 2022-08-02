package ku.cs.shop.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.shop.models.Account;

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
