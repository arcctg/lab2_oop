module org.arcctg.lab2_oop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires static lombok;

    opens org.arcctg.lab2_oop to javafx.fxml;

    exports org.arcctg.lab2_oop;
    exports org.arcctg.lab2_oop.shapes;
    opens org.arcctg.lab2_oop.shapes to javafx.fxml;
    exports org.arcctg.lab2_oop.editors;
    opens org.arcctg.lab2_oop.editors to javafx.fxml;
}