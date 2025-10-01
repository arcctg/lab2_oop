package org.arcctg.lab2_oop.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PointShape extends Shape {
    @Override
    public void show(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillOval(xs1 - 2, ys1 - 2, 4, 4);
    }
}