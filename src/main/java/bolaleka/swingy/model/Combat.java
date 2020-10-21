package bolaleka.swingy.model;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import bolaleka.swingy.model.characters.Monster;
import bolaleka.swingy.model.characters.Navigate;
import bolaleka.swingy.model.characters.PrintStat;
import bolaleka.swingy.model.storage.Storage;

public class Combat {
    Monster monster;
    PrintStat hero;
    
    Random getRandom = new Random();
   
    public Combat(PrintStat hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
    }

    public void battle(String name) throws IOException {
        Storage storage = new Storage(name);
        List<String> list = storage.loadData(name);
        int hp = storage.getHp();
     
        while(true) {
            Scanner readChoice = new Scanner(System.in);

            System.out.println("What do you want to do (Attack, Run, Quit): ");
            String userChoice = readChoice.nextLine();
            while(true){
                if(!userChoice.equalsIgnoreCase("Run") && !userChoice.equalsIgnoreCase("Attack") && !userChoice.equalsIgnoreCase("Quit")){
                    System.out.println("Choose a valid choice");
                    readChoice = new Scanner(System.in);
                    System.out.println("What do you want to do (Attack, Run, Quit): ");
                    userChoice = readChoice.nextLine();
                }else{                 
                        if(userChoice.equalsIgnoreCase("Run")){
                            int run = (int)(Math.random() * 100 + 1);
                            if(run >= 50){
                                System.out.println(run);
                                System.out.println(PrintStat.getCoordinates());
                                System.out.println("You successfully run.");
                                Navigate back = new Navigate();
                                back.moveDirection(PrintStat.getCoordinates(), name);
                                break;
                            }else{
                                System.out.println("Your chance to run is less than 50%.");
                                System.out.println("What do you want to do (Attack, Run, Quit): ");
                                userChoice = readChoice.nextLine();
                                int enemyHealth = getRandom.nextInt(monster.HP);

                                while(enemyHealth > 0) {
                                     int damageDealt = getRandom.nextInt(storage.getAttack() + storage.getDefense());
                                     int damageTaken = getRandom.nextInt(monster.attack);
                         
                                     enemyHealth -= damageDealt;
                                     hp -= damageTaken;
                         
                                     System.out.println("\t> You strike the " + monster.type + " for " +damageDealt+ " damage.");
                                     System.out.println("\t> You received " + damageTaken + " in retaliation");
                         
                                     if(hp < 1){
                                         System.out.println("You have taken too much damage, you are too weak to go on.");
                                         break;
                                     }
                                }
                                if(hp < 1) {
                                    hp = 0;
                                    int exper = Integer.parseInt(list.toString().split(",")[3]);
                                    int newExperience = exper  + (monster.HP * monster.attack) ;
                                    storage.saveCurrentGame(name, newExperience, hp);
                                    System.out.println("You lost this battle\n");
                                    System.exit(1);
                                }
                                System.out.println("-----------------------------------------------------------------------");
                                System.out.println(" # " + monster.type + " was defeated # ");
                                System.out.println(" # " + hp + " HP left");
                              
                                
                            }
            
                        }else if(userChoice.equalsIgnoreCase("Attack")){
                            int enemyHealth = getRandom.nextInt(monster.HP);

                            while(enemyHealth > 0) {
                                 int damageDealt = getRandom.nextInt(storage.getAttack() + storage.getDefense());
                                 int damageTaken = getRandom.nextInt(monster.attack);
                     
                                 enemyHealth -= damageDealt;
                                 hp -= damageTaken;
                     
                                 System.out.println("\t> You strike the " + monster.type + " for " +damageDealt+ " damage.");
                                 System.out.println("\t> You received " + damageTaken + " in retaliation");
                     
                                 if(hp < 1){
                                     hp = 0;

                                     System.out.println("You have taken too much damage, you are too weak to go on.");

                                     break;
                                 }
                            }
                            if(hp < 1) {
                                hp = 0;

                                int exper = Integer.parseInt(list.toString().split(",")[3]);
                                int newExperience = exper  + (monster.HP * monster.attack) ;
                                storage.saveCurrentGame(name, newExperience, hp);
                                System.out.println("You lost this battle\n");
                                System.out.println(name+" ->>> You are out of the game, create a name to start a new game");

                                System.out.println("######################");
                                System.out.println("# Thanks for playing #");
                                System.out.println("######################");

                                System.exit(1);
                            }
                            System.out.println("-----------------------------------------------------------------------");
                            System.out.println(" # " + monster.type + " was defeated # ");
                            System.out.println(" # You hava " + hp + " HP left");

                            
                            int exper = Integer.parseInt(list.toString().split(",")[3]);
                            int newExperience = exper  + (monster.HP * monster.attack) ;
                            storage.saveCurrentGame(name, newExperience, hp);
                            Navigate back = new Navigate();
                            back.moveDirection(PrintStat.getCoordinates(), name);
                            break;
                        }else if(userChoice.equalsIgnoreCase("Quit")) {
                            System.exit(1);
                        }
                }
            }
        readChoice.close();
        }
        
    
    }
    

}
