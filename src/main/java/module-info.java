module org.labarranca.barrancapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.labarranca.barrancapp.controllers to javafx.fxml;
    exports org.labarranca.barrancapp;
}