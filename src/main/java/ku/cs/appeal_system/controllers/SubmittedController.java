package ku.cs.appeal_system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;

public class SubmittedController {

    @FXML private ImageView imageCase;
    @FXML private ImageView imageTyty;
    @FXML private ImageView imageRada;
    @FXML private ImageView imagePeem;

    @FXML
    public void initialize() {

        String url1 = getClass().getResource("/ku/cs/image/Kaze.jpg").toExternalForm();
        imageCase.setImage(new Image(url1));
        String url2 = getClass().getResource("/ku/cs/image/Tyty.jpg").toExternalForm();
        imageTyty.setImage(new Image(url2));
        String url3 = getClass().getResource("/ku/cs/image/Rada.jpg").toExternalForm();
        imageRada.setImage(new Image(url3));
        String url4 = getClass().getResource("/ku/cs/image/Peem.jpg").toExternalForm();
        imagePeem.setImage(new Image(url4));
    }


    public void handleBackButton(ActionEvent action){
        try {
            com.github.saacsos.FXRouter.goTo("home");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า login ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

}
