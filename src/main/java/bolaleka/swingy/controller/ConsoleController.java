package bolaleka.swingy.controller;

import java.io.IOException;

import bolaleka.swingy.view.ConsoleManager;

public class ConsoleController {
    ConsoleManager displayConsole;

    public ConsoleController() throws IOException {
        displayConsole = new ConsoleManager();
    }
}
