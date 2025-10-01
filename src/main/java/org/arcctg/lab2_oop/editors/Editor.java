package org.arcctg.lab2_oop.editors;

import javafx.scene.input.MouseEvent;

public abstract class Editor {
    public abstract void onLBDown(MouseEvent event);

    public abstract void onLBUp(MouseEvent event);

    public abstract void onMouseMove(MouseEvent event);

    public abstract void onPaint();
}