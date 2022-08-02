package ku.cs.shop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ku.cs.shop.models.Account;

import java.io.IOException;

public class HomeController {
    @FXML
    public void initialize() {

    }

    @FXML
    public void handleLoginButton(ActionEvent actionEvent){
        try {
            com.github.saacsos.FXRouter.goTo("login");
        } catch (IOException ex) {
            System.err.println("ไปที7หน้าhome ไม่ได้");
            System.err.println("ให้ตรวจสอบการกําหนดroute");
        }
    }


}
