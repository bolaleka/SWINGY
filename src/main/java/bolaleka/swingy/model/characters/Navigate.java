package bolaleka.swingy.model.characters;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import bolaleka.swingy.model.Combat;
//import bolaleka.swingy.model.storage.Storage;

public class Navigate {

   
    private int x = 0;
    private int y = 0;
    int choice = 1;
    Scanner INPUT = new Scanner(System.in);
    Random getRandom = new Random();
    
    public Navigate() {
        
    }
    
    public void moveDirection(int coordinates, String name) throws IOException {
        Monster enemy = new Monster(name);
        //Storage curr = new Storage(name);
        PrintStat hero = new PrintStat(name);
        Combat fight = new Combat(hero, enemy);
        
        String[] enemies = {null, enemy.type, null, null};
        
        System.out.printf ("Choices:\n");
        System.out.println("1. To move north press 1");
        System.out.println("2. To move south press 2");
        System.out.println("3. To move east press 3");
        System.out.println("4. To move west press 4");
        System.out.println("5. To view status 5");
        System.out.println("0. Quit the game\n");
        System.out.println("Choose one:");
        while(choice != 0) {

            choice = INPUT.nextInt();
            switch (choice) {
                case 0:
                    System.exit(1);
                    break;
                case 1:
                    while(++y > 0) {
                        String enemyName = enemies[getRandom.nextInt(enemies.length)];
                        if(enemyName  != null) {
                            System.out.println("You have encounter a "+ enemyName + "   HP: " + enemy.HP + " Attack:    " + enemy.attack );
                            fight.battle(name);
                            break;
                        }
                        if(y == coordinates) {
                            System.out.println("You have reach the end of the border, now you have move on to the next level");
                            setVitoryMessage(name);
                            y = 1;
                            break;
                        }
                        break;        
                    }
                    break;
                case 2:
                    while(--y < 0) {
                        String enemyName  = enemies[getRandom.nextInt(enemies.length)];
                        if(enemyName  != null) {
                            System.out.println("You have encounter a "+ enemyName  + "  HP: " + enemy.HP  + " Attack:    " + enemy.attack );
                            fight.battle(name);
                            break;
                        }
                        if(y == (-coordinates)) {
                            System.out.println("You have reach the end of the border, now you have move on to the next level");
                            setVitoryMessage(name);
                            y = 1;
                            break;
                        }
                        break;  
                    }
                    break;
                case 3:
                    while(--x < 0) {
                        String enemyName  = enemies[getRandom.nextInt(enemies.length)];
                        if(enemyName  != null) {
                            System.out.println("You have encounter a "+ enemyName  + "  HP: " + enemy.HP  + " Attack:    " + enemy.attack );
                            fight.battle(name);
                            break;
                        }
                        if(x == (-coordinates)) {
                            System.out.println("You have reach the end of the border, now you have move on to the next level");
                            setVitoryMessage(name);
                            x = 1;
                            break;
                        }

                        break;  
                    }  
                    break;
                case 4:
                    while(x++ > 0) {
                        String enemyName  = enemies[getRandom.nextInt(enemies.length)];
                        if(enemyName  != null) {
                            System.out.println("You have encounter a "+ enemyName  + "  HP: " + enemy.HP  + " Attack:    " + enemy.attack );
                            fight.battle(name);
                            break;
                        }
                        if(x == coordinates) {
                            System.out.println("You have reach the end of the border, now you have move on to the next level");
                            setVitoryMessage(name);
                            x = 1;
                            break;
                        }
                        break;
                    }  
                        break;
                    case 5:
                         hero.displayStat(name);
                        break;
                default:
                    System.out.println("Please choose beteween 0-5");
                    choice = INPUT.nextInt();
                    break;
            }
        }
       choice = INPUT.nextInt();
    }


    public boolean setVitoryMessage(String name) throws IOException {
        String choice = INPUT.nextLine();
        System.out.println("What would you like to do?");
        System.out.println("........................................");
        System.out.println("\t\t1. To continue press 1");
        System.out.println("\t\t2. To Quit press 2");

        choice =  INPUT.nextLine();
        if(!choice.equals("1") && !choice.equals("2")) {
            System.out.println("You need to choose between 1-2");
            System.out.println("What would you like to do?");
            System.out.println("........................................");
            System.out.println("\t\t1. To continue press 1");
            System.out.println("\t\t2. To Quit press 2");
            choice =  INPUT.nextLine();
        }
        if(choice.equals("1")) {
            new Navigate().moveDirection(PrintStat.getCoordinates(), name);;
        }else if(choice.equals("2")) {
            System.exit(1);
        }
        return true;
    }


}
