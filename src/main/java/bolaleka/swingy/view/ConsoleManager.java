package bolaleka.swingy.view;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import bolaleka.swingy.controller.DataController;
import bolaleka.swingy.model.characters.PrintStat;

public class ConsoleManager {
    
    Scanner INPUT = new Scanner(System.in);
   
    public ConsoleManager() throws IOException{
        System.out.println("\tWelcome to Adventure");
        System.out.println("Enter [1] to create new game");
        System.out.println("Enter [2] to select select hero");


        try {
            
            int input = INPUT.nextInt();
            if(Integer.toString(input).isEmpty()) {
                System.out.println("No input");
            }
            String name = INPUT.nextLine();
           

            switch (input) {
                case 1:
                System.out.println("Enter a name to create default stats");
                System.out.println("..............................................");
                
                name = INPUT.nextLine();
                if(name.isEmpty()) {
                    System.out.println("No input found");
                    System.exit(0);
                }    
                if(name.length() > 10) {
                    System.out.println("Name too long");
                    System.exit(1);
                }
                

                DataController control = new DataController(name);
                control.getStorage().saveData(name);

                System.out.println("You have successfully created. You hava 2 options below");
                System.out.println("\tEnter START to begin");
                System.out.println("\tEnter QUIT to exit from the game");     
                 String userInput = INPUT.nextLine();
                if(userInput.equalsIgnoreCase("START")) {
                    control.getStorage().loadData(name);
                    control.getStat().displayStat(name);
                    control.getNavigate().moveDirection(PrintStat.getCoordinates(), name);
                    
                }else if(userInput.equalsIgnoreCase("QUIT")) {
                        System.exit(1);
                    }
                    break;
                case 2:
                System.out.println("Please Enter your current name");
                name = INPUT.nextLine();
                DataController control2 = new DataController(name);
                control2.getStorage().loadData(name);
                control2.getStat().displayStat(name);
                control2.getNavigate().moveDirection(PrintStat.getCoordinates(), name);

                    break;
                default:
                    System.out.println("You have enter an invalid option");                
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("You have enter a wrong input");
        }
    }
}
