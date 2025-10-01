package org.arcctg.lab2_oop.editors;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import org.arcctg.lab2_oop.shapes.RectShape;
import org.arcctg.lab2_oop.shapes.Shape;

public class RectEditor extends ShapeEditor {
    public RectEditor(GraphicsContext gc, Shape[] shapes) {
        super(gc, shapes);
    }

    @Override
    public void onLBUp(MouseEvent event) {
        RectShape rect = new RectShape();
        rect.set(startX, startY, event.getX(), event.getY());
        addShape(rect);
        onPaint();
    }

    @Override
    public void onMouseMove(MouseEvent event) {
        super.onMouseMove(event);

        double width = Math.abs(event.getX() - startX) * 2;
        double height = Math.abs(event.getY() - startY) * 2;
        double x = startX - width / 2;
        double y = startY - height / 2;

        gc.strokeRect(x, y, width, height);
    }
}