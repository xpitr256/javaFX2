package vista;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CanvasAjustable extends Canvas {

    public CanvasAjustable(double with, double height) {

        super(with, height);

        InvalidationListener listener = (new InvalidationListener() {
            @Override
            public void invalidated(Observable o) {
                draw();
            }
        });

        widthProperty().addListener(new InvalidationListener() {

            @Override
            public void invalidated(Observable arg0) {
                draw();

            }
        });

        heightProperty().addListener(listener);
    }

    private void draw() {
        double width = getWidth();
        double height = getHeight();

        System.out.println("width: " + width + "height: " + height);

        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, width, height);

        gc.setStroke(Color.RED);
        gc.strokeLine(0, 0, width, height);
        gc.strokeLine(0, height, width, 0);
    }

    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double prefWidth(double height) {
        return getWidth();
    }

    @Override
    public double prefHeight(double width) {
        return getHeight();
    }
}
