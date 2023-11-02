module com.example.msjoin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.msjoin to javafx.fxml;
    exports com.example.msjoin;
}