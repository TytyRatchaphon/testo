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
        FXRouter.bind(this, stage, "Project Myopia", 800, 600);
        configRoute();
        FXRouter.goTo("home");
    }

    private static void configRoute() {
        String packageStr = "ku/cs/";
        FXRouter.when("home",packageStr+"home.fxml");
        FXRouter.when("submitted",packageStr+"submitted.fxml");
        FXRouter.when("login",packageStr+"login.fxml");
        FXRouter.when("home_after_login",packageStr+"home_after_login.fxml");
        FXRouter.when("register", packageStr+"registration.fxml");
        FXRouter.when("officer_register",packageStr+"officer_registration.fxml");
        FXRouter.when("reset",packageStr+"reset_password.fxml");
        FXRouter.when("home_admin",packageStr+"home_admin.fxml");
        FXRouter.when("user_name_list",packageStr+"user_name_list.fxml");
        FXRouter.when("register_officer",packageStr+"register_officer.fxml");
        FXRouter.when("report_insecurity",packageStr+"report_insecurity.fxml");
        FXRouter.when("home_officer",packageStr+"home_officer.fxml");
        FXRouter.when("complaints_list",packageStr+"complaints_list.fxml");
        FXRouter.when("home_student",packageStr+"home_student.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}