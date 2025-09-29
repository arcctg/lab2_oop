module org.arcctg.lab2_oop {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.arcctg.lab2_oop to javafx.fxml;
    exports org.arcctg.lab2_oop;
}