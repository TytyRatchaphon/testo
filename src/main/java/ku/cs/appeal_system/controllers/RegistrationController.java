package ku.cs.appeal_system.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import ku.cs.appeal_system.models.Account;
import ku.cs.appeal_system.models.AccountList;
import ku.cs.appeal_system.services.AccountFileDataSource;
import ku.cs.appeal_system.services.DataSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

public class RegistrationController {

    @FXML private Label errorNoticeLabel;
    @FXML private TextField newNameTextField;
    @FXML private TextField newUsernameTextField;
    @FXML private PasswordField newPasswordPasswordField;
    @FXML private PasswordField confirmPasswordPasswordField;
    @FXML private TextField newLastnameTextField;
    @FXML private ImageView userImageView;
    private Account accountForSetImagePath;
    @FXML
    public void handleUploadImageButton(ActionEvent event) {
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
//                System.out.println("Upload: "+accountForSetImagePath.getImagePath())
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void handleSubmitButton(ActionEvent event) {
        //เขียนอ่านไฟล์
        DataSource<AccountList> dataSource = new AccountFileDataSource();
        AccountList accounts = dataSource.readData();

        // รับข้อมูล จาก nameTextField ข้อมูลที่รับเป็น String เสมอ
        String nameStr = newNameTextField.getText(); // ตัวแปร name
        // รับข้อมูล จาก lastNameTextField ข้อมูลที่รับเป็น String เสมอ
        String lastnameStr = newLastnameTextField.getText(); // ตัวแปร lastName
        // รับข้อมูล จาก userNameTextField ข้อมูลที่รับเป็น String เสมอ
        String usernameStr = newUsernameTextField.getText(); // ตัวแปร userName
        // รับข้อมูล จาก PasswordField ข้อมูลที่รับเป็น String เสมอ
        String passwordStr = newPasswordPasswordField.getText(); // ตัวแปร password
        // รับข้อมูล จาก PasswordField ข้อมูลที่รับเป็น String เสมอ
        String confirmPasswordStr = confirmPasswordPasswordField.getText(); // ตัวแปร confirmPassword



        if ((usernameStr.equals("") || nameStr.equals("") || lastnameStr.equals("") || passwordStr.equals("") || confirmPasswordStr.equals(""))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!!");
            alert.setHeaderText(null);
            alert.setContentText("Please check your information and try again.");

            alert.showAndWait();
        } else {
            //check ช้อมูลซ้ำ --> ว่าใน account list มี usernameStr ซ้ำไหม ถ้าซ้ำจะสมัครไม่ได้
            if (accounts.checkUsername(usernameStr)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error!!");
                alert.setHeaderText(null);
                alert.setContentText("Username is unavailable");

                alert.showAndWait();
            } else {
                if (!passwordStr.equals(confirmPasswordStr)) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error!!");
                    alert.setHeaderText(null);
                    alert.setContentText("Please check your information and try again.");

                    alert.showAndWait();

                } else {
                    //เขียนไฟล์ --> new Account
                    accounts.addAccount(new Account(nameStr,lastnameStr ,usernameStr ,passwordStr));
                    Account account = accounts.searchUsername(usernameStr);
                    if (!(accountForSetImagePath==null)) {
//                        System.out.println("เข้่า if");
                        account.setImagePath(accountForSetImagePath.getImagePath());//พอชี้เสร็จก็แก้ตัวที่เราชี้
                    }else{
//                        System.out.println("เข้า else");
                        account.setImagePath();
                    }
//                    account.setLastLogin();
                    //เขียนไฟล์
                    dataSource.writeData(accounts);

                    try {
                        FXRouter.goTo("login");
                    } catch (IOException e) {
                        System.err.println("ไปที่หน้า login ไม่ได้");
                        System.err.println("ให้ตรวจสอบการกำหนด route");
                    }
                }
            }

        }
    }
    public void handleBackButton(ActionEvent action){
        try {
            FXRouter.goTo("login");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า login ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

}
