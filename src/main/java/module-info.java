module org.labarranca.barrancapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.labarranca.barrancapp to javafx.fxml;
    exports org.labarranca.barrancapp;
}