package org.arcctg.lab2_oop.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class EllipseShape extends Shape {
    @Override
    public void show(GraphicsContext gc) {
        double x = Math.min(xs1, xs2);
        double y = Math.min(ys1, ys2);
        double width = Math.abs(xs2 - xs1);
        double height = Math.abs(ys2 - ys1);

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeOval(x, y, width, height);
    }
}