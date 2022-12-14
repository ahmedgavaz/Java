package viceCity;

import viceCity.core.EngineImpl;
import viceCity.core.interfaces.Controller;
import viceCity.core.interfaces.ControllerImpl;
import viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl(); // TODO
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
