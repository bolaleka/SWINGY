package bolaleka.swingy;

import java.io.IOException;

import bolaleka.swingy.controller.ConsoleController;
import bolaleka.swingy.controller.GuiController;


public class Game {
      
    
    public static void main(String[] args)throws IOException {

        try {
            if(args[0].equalsIgnoreCase("gui") && args.length == 1) {
                new GuiController();
            }else if(args[0].equalsIgnoreCase("console") && args.length == 1) {
                new ConsoleController();
            }else if(args.length != 1) {
                System.out.println("Too many argument");
                System.exit(1);
            }else {
                System.out.println("USAGE: java -jar target/bolaleka-swingy.jar [GUI/CONSOLE]");
                System.exit(1);
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("USAGE: java -jar target/bolaleka-swingy.jar [GUI/CONSOLE]");
            System.exit(1);
        }
        
    }
}
