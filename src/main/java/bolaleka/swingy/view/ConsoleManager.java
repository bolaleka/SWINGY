package bolaleka.swingy.view;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import bolaleka.swingy.model.characters.Navigate;
import bolaleka.swingy.model.characters.PrintStat;
import bolaleka.swingy.model.storage.Storage;

public class ConsoleManager {
    
    Scanner INPUT = new Scanner(System.in);
   
    public ConsoleManager() throws IOException{
        System.out.println("\tWelcome to Adventure");
        System.out.println("Enter [1] to create new game");
        System.out.println("Enter [2] to select select hero");

        Navigate move;
       
        try {
            
            int input = INPUT.nextInt();
            String name = INPUT.nextLine();

            switch (input) {
                case 1:
                System.out.println("Enter a name to create default stats");
                System.out.println("..............................................");
                
                name = INPUT.nextLine();
                
                if(name.length() > 10) {
                    System.out.println("Name too long");
                    System.exit(1);
                }
                Storage storage = new Storage(name);
                storage.saveData(name);

                System.out.println("You have successfully created. You hava 2 options below");
                System.out.println("\tEnter START to begin");
                System.out.println("\tEnter QUIT to exit from the game");     
                 String userInput = INPUT.nextLine();
                if(userInput.equalsIgnoreCase("START")) {
                   storage.loadData(name);
                   PrintStat getStat = new PrintStat(name);
                   getStat.displayStat(name);
                   move = new Navigate();
                   move.moveDirection(PrintStat.getCoordinates(), name);
                    
                }else if(userInput.equalsIgnoreCase("QUIT")) {
                        System.exit(1);
                    }
                    break;
                case 2:
                System.out.println("Please Enter your current name");
                name = INPUT.nextLine();
                Storage storage2 = new Storage(name);
                storage2.loadData(name);
                PrintStat getStat2 = new PrintStat(name);
                getStat2.displayStat(name);
                   move = new Navigate();
                   move.moveDirection(PrintStat.getCoordinates(), name);
                    break;
                default:
                    System.out.println("You have enter an invalid option");                
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("You have enter a wrong input");
        }
    }
}
