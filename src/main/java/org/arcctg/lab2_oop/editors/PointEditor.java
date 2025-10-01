package org.arcctg.lab2_oop.editors;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import org.arcctg.lab2_oop.shapes.PointShape;
import org.arcctg.lab2_oop.shapes.Shape;

public class PointEditor extends ShapeEditor {
    public PointEditor(GraphicsContext gc, Shape[] shapes) {
        super(gc, shapes);
    }

    @Override
    public void onLBDown(MouseEvent event) {
        super.onLBDown(event);
        PointShape point = new PointShape();
        point.set(startX, startY, startX, startY);
        addShape(point);
        onPaint();
    }

    @Override
    public void onLBUp(MouseEvent event) {
        // Empty implementation: points are created instantly on mouse down,
        // no additional processing needed on mouse up
    }

    @Override
    public void onMouseMove(MouseEvent event) {
        // Empty implementation: points don't require mouse movement tracking
        // since they are single-pixel shapes created at click position
    }
}