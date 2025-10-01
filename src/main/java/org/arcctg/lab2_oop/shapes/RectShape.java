package org.arcctg.lab2_oop.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RectShape extends Shape {
    @Override
    public void show(GraphicsContext gc) {
        double centerX = xs1;
        double centerY = ys1;
        double cornerX = xs2;
        double cornerY = ys2;

        double width = Math.abs(cornerX - centerX) * 2;
        double height = Math.abs(cornerY - centerY) * 2;
        double x = centerX - width / 2;
        double y = centerY - height / 2;

        gc.setFill(Color.rgb(192, 192, 192));
        gc.fillRect(x, y, width, height);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeRect(x, y, width, height);
    }
}