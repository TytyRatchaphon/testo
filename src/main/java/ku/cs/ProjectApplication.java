package ku.cs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.github.saacsos.FXRouter;

import java.io.IOException;

public class ProjectApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "6410450150", 800, 600);
        configRoute();
        FXRouter.goTo("home");
    }

    private static void configRoute() {
        String packageStr = "ku/cs/";
        FXRouter.when("home",packageStr+"home.fxml");
        FXRouter.when("login",packageStr+"login.fxml");
        FXRouter.when("home_after_login",packageStr+"home_after_login.fxml");
        FXRouter.when("register", packageStr+"registration.fxml");
        FXRouter.when("officer_register",packageStr+"officeregistrationcontroller.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}