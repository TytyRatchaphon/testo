package ku.cs.appeal_system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import ku.cs.appeal_system.models.Account;
import ku.cs.appeal_system.models.AccountList;
import ku.cs.appeal_system.models.OfficerAccount;
import com.github.saacsos.FXRouter;
import ku.cs.appeal_system.services.AccountFileDataSource;
import ku.cs.appeal_system.services.DataSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

public class HomeStudentController {
    @FXML private Label typeLabel;
    @FXML private Label userNameLabel;
    @FXML public ImageView userImageView;

    public Account loginAccount;
    private Account accountForSetImagePath;

    public  void initialize(){
        loginAccount = (Account) FXRouter.getData();
        showAccountData(loginAccount);
    }
    private void showAccountData(Account loginAccount){
        typeLabel.setText(loginAccount.getType());
        userNameLabel.setText(loginAccount.getUsername());
        userImageView.setImage(new Image("file:"+loginAccount.getImagePath(), true));
    }
    @FXML
    public void handleReportButton(ActionEvent actionEvent) {
        try {
            com.github.saacsos.FXRouter.goTo("report_list");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า Report ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
            System.err.println(e);
        }
    }

    @FXML
    public void handleResetPasswordButton(ActionEvent actionEvent) {
        try {
            com.github.saacsos.FXRouter.goTo("reset", loginAccount);
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
    public void handleUploadImageButton(ActionEvent event) {
        DataSource<AccountList> dataSource = new AccountFileDataSource();
        AccountList accounts = dataSource.readData();

        FileChooser chooser = new FileChooser();

        // SET FILECHOOSER INITIAL DIRECTORY
        chooser.setInitialDirectory(new File(System.getProperty("user.dir")));


        // DEFINE ACCEPTABLE FILE EXTENSION
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("images PNG JPG", "*.png", "*.jpg", "*.jpeg"));

        // GET FILE FROM FILECHOOSER WITH JAVAFX COMPONENT WINDOW
        Node source = (Node) event.getSource();
        File file = chooser.showOpenDialog(source.getScene().getWindow());
        if (file != null) {
            try {

                // CREATE FOLDER IF NOT EXIST
                File destDir = new File("images");

                if (!destDir.exists()) destDir.mkdirs();


                // RENAME FILE
                String[] fileSplit = file.getName().split("\\.");

                String filename = LocalDate.now() + "_" + System.currentTimeMillis() + "."
                        + fileSplit[fileSplit.length - 1];
                Path target = FileSystems.getDefault().getPath(
                        destDir.getAbsolutePath() + System.getProperty("file.separator") + filename
                );


                // COPY WITH FLAG REPLACE FILE IF FILE IS EXIST
                Files.copy(file.toPath(), target, StandardCopyOption.REPLACE_EXISTING);


                // SET NEW FILE PATH TO IMAGE
                userImageView.setImage(new Image(target.toUri().toString()));

                //setImagePath
                Account accountForSetImagePath = new Account("usernameSetImage","nameSetImage","lastnameSetImage","0");
                accountForSetImagePath.setImagePath(destDir + "/" + filename);
                this.accountForSetImagePath=accountForSetImagePath;

                Account account = accounts.searchUsername(loginAccount.getUsername());
                account.setImagePath(accountForSetImagePath.getImagePath());
                //เขียนไฟล์
                dataSource.writeData(accounts);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("");
                alert.setHeaderText(null);
                alert.setContentText("Add image completed");

                alert.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
