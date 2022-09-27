package ku.cs.appeal_system.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ku.cs.appeal_system.models.Account;
import ku.cs.appeal_system.models.AccountList;
import ku.cs.appeal_system.services.AccountFileDataSource;
import ku.cs.appeal_system.services.DataSource;

import java.io.IOException;

public class UsernameListController {
    @FXML
    private ListView<Account> accountListView;

    @FXML private Label nameLabel;
    @FXML private Label lastnameLabel;
    @FXML private Label usernameLabel;
    @FXML private Label statusLabel;
    @FXML private ImageView userImageView;

    private AccountFileDataSource dataSource;
    private AccountList accountsList;

    private Account selectedAccount;

    @FXML
    public void initialize(){

        dataSource = new AccountFileDataSource();
        dataSource.readData();
        accountsList = dataSource.getAllAccountList();
        showListView();
        clearSelectedAccount();
        handleSelectedListView();
    }
    private void showListView() {
        accountsList.sortAccount();
        accountListView.getItems().addAll(accountsList.getAllAccounts());
        accountListView.refresh();
    }
    private void handleSelectedListView() {
        accountListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Account>() {
                    @Override
                    public void changed(ObservableValue<? extends Account> observable,
                                        Account oldValue, Account newValue) {
                        //System.out.println(newValue + " is selected");
                        selectedAccount = newValue;
                        showSelectedAccount(newValue);
                    }
                });
    }
    private void showSelectedAccount(Account account) {
        nameLabel.setText(account.getName());
        lastnameLabel.setText(account.getLastname());
        usernameLabel.setText(account.getUsername());
        statusLabel.setText(account.getStatus());
        userImageView.setImage(new Image("file:"+account.getImagePath(), true));

    }
    private void clearSelectedAccount() {
        nameLabel.setText("");
        lastnameLabel.setText("");
        usernameLabel.setText("");
        statusLabel.setText("");
    }

    @FXML
    public  void handleBanAccountButton(ActionEvent actionEvent){
        if(selectedAccount.isAdmin(selectedAccount.getType())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("This is Admin don't banned");

            alert.showAndWait();
        }else{
            selectedAccount.setStatus();
            accountListView.refresh();
            showSelectedAccount(selectedAccount);

            //setStatus = Baned
            Account account = accountsList.searchUsername(selectedAccount.getUsername());
            account.setStatus();
            dataSource.writeData(accountsList);
        }

    }

    @ FXML
    public void handleUnBanAccountButton(ActionEvent actionEvent){
        String unbanned = "Not Banned";
        selectedAccount.setStatus(unbanned);
        selectedAccount.setLoginCount(0);
        accountListView.refresh();
        showSelectedAccount(selectedAccount);

        Account account = accountsList.searchUsername(selectedAccount.getUsername());
        //setContLogin ให้เป็น 0  เพราะ  unbanned แล้ว
        account.setLoginCount(0);
        dataSource.writeData(accountsList);
    }

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
