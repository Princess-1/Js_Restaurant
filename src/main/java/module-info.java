module otusanya.personal.js_restaurant {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;


    opens otusanya.personal.js_restaurant to javafx.fxml;
    exports otusanya.personal.js_restaurant;
    exports personnel;
    opens personnel to javafx.fxml;
}