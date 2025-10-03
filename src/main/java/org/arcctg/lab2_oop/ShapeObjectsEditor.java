package org.arcctg.lab2_oop;

import java.util.Arrays;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import lombok.Setter;
import org.arcctg.lab2_oop.editors.EllipseEditor;
import org.arcctg.lab2_oop.editors.LineEditor;
import org.arcctg.lab2_oop.editors.PointEditor;
import org.arcctg.lab2_oop.editors.RectEditor;
import org.arcctg.lab2_oop.editors.ShapeEditor;
import org.arcctg.lab2_oop.shapes.Shape;

public class ShapeObjectsEditor implements Initializable {
    private static final int ARRAY_SIZE = 117;

    @FXML
    private Canvas canvas;

    @Setter
    private Stage stage;
    private final Shape[] shapes = new Shape[ARRAY_SIZE];
    private ShapeEditor currentEditor;
    private GraphicsContext gc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupCanvasEvents();
        gc = canvas.getGraphicsContext2D();
    }
    
    @FXML
    public void startPointEditor() {
        currentEditor = new PointEditor(gc, shapes);
        updateTitle("Точка");
    }
    
    @FXML
    public void startLineEditor() {
        currentEditor = new LineEditor(gc, shapes);
        updateTitle("Лінія");
    }
    
    @FXML
    public void startRectEditor() {
        currentEditor = new RectEditor(gc, shapes);
        updateTitle("Прямокутник");
    }
    
    @FXML
    public void startEllipseEditor() {
        currentEditor = new EllipseEditor(gc, shapes);
        updateTitle("Еліпс");
    }

    @FXML
    private void handleClear() {
        clearAll();
        currentEditor.onPaint();
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    public void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Про програму");
        alert.setHeaderText("Графічний редактор");
        alert.setContentText(
            """
            Лабораторна робота №2
            Розробка графічного редактора об'єктів
            
            Варіант: 17
            Масив: статичний, 117 елементів
            Гумовий слід: суцільна червона лінія
            Прямокутник: від центру, сіре заповнення
            Еліпс: по кутам, без заповнення
            Позначка режиму: в заголовку вікна"""
        );
        alert.showAndWait();
    }

    private void setupCanvasEvents() {
        canvas.setOnMousePressed(this::onMousePressed);
        canvas.setOnMouseReleased(this::onMouseReleased);
        canvas.setOnMouseDragged(this::onMouseDragged);
    }

    private void onMousePressed(MouseEvent event) {
        if (currentEditor != null) {
            currentEditor.onLBDown(event);
        }
    }

    private void onMouseReleased(MouseEvent event) {
        if (currentEditor != null) {
            currentEditor.onLBUp(event);
        }
    }

    private void onMouseDragged(MouseEvent event) {
        if (currentEditor != null) {
            currentEditor.onMouseMove(event);
        }
    }

    private void updateTitle(String shapeName) {
        if (stage != null) {
            Platform.runLater(() -> stage.setTitle("Графічний редактор - " + shapeName));
        }
    }

    private void clearAll() {
        Arrays.fill(shapes, null);
    }
}
