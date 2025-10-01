package org.arcctg.lab2_oop.editors;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import org.arcctg.lab2_oop.shapes.EllipseShape;
import org.arcctg.lab2_oop.shapes.Shape;

public class EllipseEditor extends ShapeEditor {

    public EllipseEditor(GraphicsContext gc, Shape[] shapes) {
        super(gc, shapes);
    }

    @Override
    public void onLBUp(MouseEvent event) {
        EllipseShape ellipse = new EllipseShape();
        ellipse.set(startX, startY, event.getX(), event.getY());
        addShape(ellipse);
        onPaint();
    }

    @Override
    public void onMouseMove(MouseEvent event) {
        super.onMouseMove(event);

        double x = Math.min(startX, event.getX());
        double y = Math.min(startY, event.getY());
        double width = Math.abs(event.getX() - startX);
        double height = Math.abs(event.getY() - startY);

        gc.strokeOval(x, y, width, height);
    }
}