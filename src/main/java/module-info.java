module cs.ku {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ku.cs to javafx.fxml;
    exports ku.cs;

    exports ku.cs.shop.controllers;
    opens ku.cs.shop.controllers to javafx.fxml;
}