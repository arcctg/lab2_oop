package org.arcctg.lab2_oop.editors;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.arcctg.lab2_oop.shapes.Shape;

public abstract class ShapeEditor extends Editor {
    protected Shape[] shapes;
    protected double startX, startY;
    protected GraphicsContext gc;

    protected ShapeEditor(GraphicsContext gc, Shape[] shapes) {
        this.gc = gc;
        this.shapes = shapes;
    }

    @Override
    public void onLBDown(MouseEvent event) {
        startX = event.getX();
        startY = event.getY();
    }

    @Override
    public void onPaint() {
        gc.clearRect(0, 0, 1000, 1000);

        for (Shape shape : shapes) {
            if (shape == null) break;
            shape.show(gc);
        }
    }

    @Override
    public void onMouseMove(MouseEvent event) {
        onPaint();
        gc.setStroke(Color.RED);
        gc.setLineWidth(1);
    }

    public void addShape(Shape shape) {
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] == null) {
                shapes[i] = shape;
                break;
            }
        }
    }
}