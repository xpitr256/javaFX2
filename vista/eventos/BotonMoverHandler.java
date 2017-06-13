package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Robot;
import vista.VistaRobot;

public class BotonMoverHandler implements EventHandler<ActionEvent> {

    private final VistaRobot vista;
    private final Robot robot;

    public BotonMoverHandler(VistaRobot vista, Robot robot) {
        this.vista = vista;
        this.robot = robot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.robot.mover();
        this.vista.update();
    }
}
