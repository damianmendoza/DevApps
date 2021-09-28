module main.tareaapps {
    requires javafx.controls;
    requires javafx.fxml;
    requires postgresql;
    requires java.sql;


    opens main.tareaapps to javafx.fxml;
    exports main.tareaapps;

    exports POJO;
    opens  POJO to javafx.fxml;
}