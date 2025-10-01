package org.arcctg.lab2_oop.editors;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import org.arcctg.lab2_oop.shapes.LineShape;
import org.arcctg.lab2_oop.shapes.Shape;

public class LineEditor extends ShapeEditor {

    public LineEditor(GraphicsContext gc, Shape[] shapes) {
        super(gc, shapes);
    }

    @Override
    public void onLBUp(MouseEvent event) {
        LineShape line = new LineShape();
        line.set(startX, startY, event.getX(), event.getY());
        addShape(line);
        onPaint();
    }

    @Override
    public void onMouseMove(MouseEvent event) {
        super.onMouseMove(event);

        gc.strokeLine(startX, startY, event.getX(), event.getY());
    }
}