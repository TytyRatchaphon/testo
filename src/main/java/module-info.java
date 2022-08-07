module cs.ku {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ku.cs to javafx.fxml;
    exports ku.cs;

    exports ku.cs.appeal_system.controllers;
    opens ku.cs.appeal_system.controllers to javafx.fxml;
}