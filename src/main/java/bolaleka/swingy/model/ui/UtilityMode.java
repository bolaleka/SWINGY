package bolaleka.swingy.model.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import bolaleka.swingy.model.characters.Monster;
import bolaleka.swingy.model.storage.Storage;


public class UtilityMode implements ActionListener {

    JPanel navigatePanel, statUpdatePanel;
    JButton northButton, southButton, westButton, eastButton, quitButton;
    JTextArea statTextField;
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 16);
    Random getRandom = new Random();
    
    
    
    private int x = 0;
    private int y = 0;
    int coordinates;
    List<String> statsData;
    
    public void navigateUI(JFrame window, String name) throws IOException {
        
        Storage data = new Storage(name);
        statsData = data.loadData(name);
        final Monster enemys = new Monster(name);

        String[] enemies = { null, enemys.type, null, null };
        int level = Integer.parseInt(statsData.toString().split(",")[2]);
        coordinates = (level - 1) * 5 + 10 - (level % 2);

        statUpdatePanel = new JPanel();
        statUpdatePanel.setBounds(5, 5, 250, 150);
        statUpdatePanel.setBackground(Color.white);
        statUpdatePanel.setLayout(new GridLayout(1, 3));
        window.add(statUpdatePanel);

        statTextField = new JTextArea("Name:\t" + statsData.toString().replace("[", "").split(",")[0] + "\n" + "HP:\t"
                + statsData.toString().split(",")[6] + "\n" + "Level:\t" + statsData.toString().split(",")[2] + "\n"
                + "Attack:\t" + statsData.toString().split(",")[7] + "\n" + "Defense:\t"
                + statsData.toString().replace("]", "").split(",")[8] + "\n" + "Experience:\t"
                + statsData.toString().split(",")[3] + "\n" + "Weapon:\t" + statsData.toString().split(",")[4] + "\n"
                + "Armor:\t" + statsData.toString().split(",")[5]);
        statTextField.setEditable(false);
        statUpdatePanel.add(statTextField);

        navigatePanel = new JPanel();
        navigatePanel.setBounds(150, 250, 300, 250);
        navigatePanel.setBackground(Color.lightGray);
        navigatePanel.setLayout(new GridLayout(10, 1));
        window.add(navigatePanel);

        northButton = new JButton("North");
        northButton.setBackground(Color.BLUE);
        northButton.setForeground(Color.white);
        northButton.setFocusPainted(false);
        northButton.setFont(normalFont);
        northButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                Monster enemy;
                while (++y >= 0) {
                 //  northButton.setText("North " + Integer.toString(y));
                    try {
                        enemy = new Monster(name);
                    
                    String enemyName = enemies[getRandom.nextInt(enemies.length)];

                    if (enemyName != null) {
                      
                        JOptionPane.showMessageDialog(window, "You have encounter a " + enemyName + "   HP: " + enemy.getHP()
                                + " Attack:    " + enemy.getAttack(), "Battle", JOptionPane.INFORMATION_MESSAGE);
                        try {
                            battleUI(name, window);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    }
                    if (y == coordinates) {
                        JOptionPane.showMessageDialog(window, "You have move to the next level");
                        y = 0;
                        break;
                    }
                    break;
                } catch (IOException e2) {
                        
                    e2.printStackTrace();
                }
                }
            }

        });
        navigatePanel.add(northButton);

        southButton = new JButton("South  " );
        southButton.setBackground(Color.BLUE);
        southButton.setForeground(Color.white);
        southButton.setFocusPainted(false);
        southButton.setFont(normalFont);
        southButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Monster enemy;
                while (--y < 0) {
                   try {
                    enemy = new Monster(name);
                    String enemyName = enemies[getRandom.nextInt(enemies.length)];

                    if (enemyName != null) {
                        JOptionPane.showMessageDialog(window, "You have encounter a " + enemyName + "   HP: " + enemy.getHP()
                                + " Attack:    " + enemy.getAttack(), "Battle", JOptionPane.INFORMATION_MESSAGE);
                        try {
                            battleUI(name, window);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    }
                    if (y == -coordinates) {
                        JOptionPane.showMessageDialog(window, "You have move to the next level");
                        y = 0;
                        break;
                    }
                    break;
                } catch (IOException e2) {
                    
                    e2.printStackTrace();
                }
                }
            }

        });
        navigatePanel.add(southButton);

        westButton = new JButton("West");
        westButton.setBackground(Color.BLUE);
        westButton.setForeground(Color.white);
        westButton.setFocusPainted(false);
        westButton.setFont(normalFont);
        westButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Monster enemy;
                while (--x < 0) {
                 
                  try {
                    enemy = new Monster(name);
                    String enemyName = enemies[getRandom.nextInt(enemies.length)];

                    if (enemyName != null) {
                        JOptionPane.showMessageDialog(window, "You have encounter a " + enemyName + "   HP: " + enemy.getHP()
                                + " Attack:    " + enemy.getAttack(), "Battle", JOptionPane.INFORMATION_MESSAGE);
                        try {
                            battleUI(name, window);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    }
                    if (x == -coordinates) {
                        JOptionPane.showMessageDialog(window, "You have move to the next level");
                        x = 0;
                        break;
                    }
                    break;
                } catch (IOException e2) {
                    
                    e2.printStackTrace();
                }
                }
            }

        });
        navigatePanel.add(westButton);

        eastButton = new JButton("East  ");
        eastButton.setBackground(Color.BLUE);
        eastButton.setForeground(Color.white);
        eastButton.setFocusPainted(false);
        eastButton.setFont(normalFont);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        eastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Monster enemy;
                while (++x > 0) {
                   // eastButton.setText("East " + Integer.toString(x));
                   try {
                    enemy = new Monster(name);
                    String enemyName = enemies[getRandom.nextInt(enemies.length)];

                    if (enemyName != null) {
                        JOptionPane.showMessageDialog(window, "You have encounter a " + enemyName + "   HP: " + enemy.getHP()
                                + " Attack:    " + enemy.getAttack(), "Battle", JOptionPane.INFORMATION_MESSAGE);
                        try {
                            battleUI(name, window);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    }
                    if (x == coordinates) {
                        JOptionPane.showMessageDialog(window, "You have move to the next level");
                        x = 0;
                        break;
                    }
                    break;
                } catch (IOException e2) {
                    
                    e2.printStackTrace();
                }
                }
            }

        });
        navigatePanel.add(eastButton);

        quitButton = new JButton("Quit");
        quitButton.setBackground(Color.BLUE);
        quitButton.setForeground(Color.white);
        quitButton.setFocusPainted(false);
        quitButton.setFont(normalFont);
        quitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
            
        });
        navigatePanel.add(quitButton);
    }

    public void battleUI(String name, JFrame window) throws IOException {

        Storage storage = new Storage(name);

        List<String> list = storage.loadData(name);
        Monster enemy = new Monster(name);
        int hp = storage.getHp();

        String[] options = {"FIGHT", "RUN"}; 
        int battleOption = JOptionPane.showOptionDialog(window, "What would you like to do?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if(battleOption == JOptionPane.YES_OPTION) {
         
            int enemyHealth = getRandom.nextInt(enemy.getHP());
            while(enemyHealth > 0) {
                int damageDealt = getRandom.nextInt(storage.getAttack() + storage.getDefense());
                int damageTaken = getRandom.nextInt(enemy.getAttack());
    
                enemyHealth -= damageDealt;
                hp -= damageTaken;
                JOptionPane.showMessageDialog(window, "You strike the " + enemy.type + " for " +damageDealt+ " damage.\nYou received " + damageTaken + " in retaliation");
    
                if(hp < 1){
                    JOptionPane.showMessageDialog(window, "You have taken too much damage, you are too weak to go on.");
                    break;
                }
                break;
           }
           if(hp < 1) {
               hp = 0;
            int exper = Integer.parseInt(list.toString().split(",")[3]);
            int newExperience = exper  + (enemy.getHP() * enemy.getAttack()) ;
            storage.saveCurrentGame(name, newExperience, hp);
            JOptionPane.showMessageDialog(window, "You lost this battle\n");
               System.exit(1);
           }
           int newExperience =  Integer.parseInt(list.toString().split(",")[3])  + (enemy.getHP() * enemy.getAttack()) ;
           int def = Integer.parseInt(list.toString().replace("]", "").split(",")[8])  ;
           int att = Integer.parseInt(list.toString().replace("]", "").split(",")[7]) ;
           int lev = Integer.parseInt(list.toString().replace("]", "").split(",")[2]) ;

           int reqLevel = lev * 1000 +((lev -1)*(lev -1))*450;
           reqLevel =+ newExperience;
           if(lev == 1 && reqLevel > 2450) {
                lev = lev + 1;def = def + 10;att = att + 10;
            }else if(lev == 2 && reqLevel > 4800) {
                lev = lev + 1;def = def + 10;att = att + 10;
            }else if(lev == 3 && reqLevel > 8050) {
                lev = lev + 1;def = def + 10;att = att + 10;
            }else if(lev == 4 && reqLevel > 12200) {
                lev = lev + 1;def = def + 10;att = att + 10;
            }

           JOptionPane.showMessageDialog(window, enemy.type+"was defeated. You gain "+newExperience+"XP");
           System.out.println(lev);
           storage.saveCurrentGameUI(name, lev, newExperience, hp, att, def);
           //storage.saveCurrentGame(name, newExperience, hp);
           statTextField.setText("Name:\t" + list.toString().replace("[", "").split(",")[0] + "\n" + "HP:\t"
                + hp + "\n" + "Level:\t" + lev + "\n"
                + "Attack:\t" + att + "\n" + "Defense:\t"
                + def + "\n" + "Experience:\t"
                + newExperience + "\n" + "Weapon:\t" + list.toString().split(",")[4] + "\n"
                + "Armor:\t" + list.toString().split(",")[5]);
           navigateUI(window, name);
        }else if(battleOption == JOptionPane.NO_OPTION) {
            
            int run = (int)(Math.random() * 100 + 1);
            if(run >= 50){
                JOptionPane.showMessageDialog(window, "You successfully run away from enemy.");
                navigateUI(window, name);
            }else {
                String[] runOpt = {"FIGHT"};
                JOptionPane.showMessageDialog(window, "Your chance of running is low. ");
                int runOption = JOptionPane.showOptionDialog(window, "You have to fight the enemy", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, runOpt, runOpt);
                if(runOption == JOptionPane.YES_OPTION ) {

                    int enemyHealth = getRandom.nextInt(enemy.getHP());
                    while(enemyHealth > 0) {
                        int damageDealt = getRandom.nextInt(storage.getAttack() + storage.getDefense());
                        int damageTaken = getRandom.nextInt(enemy.getAttack());
            
                        enemyHealth -= damageDealt;
                        hp -= damageTaken;
                        JOptionPane.showMessageDialog(window, "You strike the " + enemy.type + " for " +damageDealt+ " damage.\nYou received " + damageTaken + " in retaliation");
            
                        if(hp < 1){
                            JOptionPane.showMessageDialog(window, "You have taken too much damage, you are too weak to go on.");
                            break;
                        }
                        
                   }
                   if(hp < 1) {
                       hp = 0;
                    int newExperience =  Integer.parseInt(list.toString().split(",")[3])  + (enemy.getHP() * enemy.getAttack()) ;
                    storage.saveCurrentGame(name, newExperience, hp);
                    JOptionPane.showMessageDialog(window, "You lost this battle\n");
                       System.exit(1);
                   }
                   
                   int newExperience =  Integer.parseInt(list.toString().split(",")[3])  + (enemy.getHP() * enemy.getAttack()) ;
                   int def = Integer.parseInt(list.toString().replace("]", "").split(",")[8]) * enemy.getLevel();
                   int att = Integer.parseInt(list.toString().replace("]", "").split(",")[7]) * enemy.getLevel();
                   int lev = Integer.parseInt(list.toString().replace("]", "").split(",")[2]) * enemy.getLevel();

                   int reqLevel = lev * 1000 +((lev -1)*(lev -1))*450;
                   reqLevel =+ newExperience;
                  
                   if(lev == 1 && reqLevel > 2450) {
                       lev = lev + 1;def = def + 10;att = att + 10;
                   }else if(lev == 2 && reqLevel > 4800) {
                        lev = lev + 1;def = def + 10;att = att + 10;
                   }else if(lev == 3 && reqLevel > 8050) {
                        lev = lev + 1;def = def + 10;att = att + 10;
                    }else if(lev == 4 && reqLevel > 12200) {
                        lev = lev + 1;def = def + 10;att = att + 10;
                    }
                   
                   JOptionPane.showMessageDialog(window, enemy.type+" was defeated. You gain "+(enemy.getHP() * enemy.getAttack()) +"XP");
               
                   storage.saveCurrentGameUI(name, lev, newExperience, hp, att, def);
                   statTextField.setText("Name:\t" + list.toString().replace("[", "").split(",")[0] + "\n" + "HP:\t"
                        + hp + "\n" + "Level:\t" + lev + "\n"
                        + "Attack:\t" + att + "\n" + "Defense:\t"
                        + def + "\n" + "Experience:\t"
                        + newExperience + "\n" + "Weapon:\t" + list.toString().split(",")[4] + "\n"
                        + "Armor:\t" + list.toString().split(",")[5]);
                    navigateUI(window, name);
                  
                }
            }

        }
    }


   
    @Override
    public void actionPerformed(ActionEvent e) {
  
    }
    
}
