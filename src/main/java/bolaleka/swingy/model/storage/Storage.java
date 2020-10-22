package bolaleka.swingy.model.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bolaleka.swingy.model.characters.Hero;

public class Storage {

    String name, type, weapon, armor;
    int level, experience, hp, attack, defense;
    JFrame windowAlert;

    public Storage(String name) {
        this.name = name;
        this.hp = new Hero().HP;
        this.type = new Hero().type;
        this.level = new Hero().level;
        this.experience = new Hero().experience;
        this.weapon = new Hero().weaponName;
        this.armor = new Hero().armorName;
        this.attack = new Hero().attack;
        this.defense = new Hero().defense;
    }

    public void saveData(String name) throws IOException {
        File heroes = new File("heroes.txt");
        FileWriter writer = new FileWriter(heroes, true);
        BufferedReader br = new BufferedReader(new FileReader("heroes.txt"));
        String line;
                
        while ((line = br.readLine()) != null) {
           if(this.name == null) {
            System.out.println(">> No input found");
            System.exit(1);
           }
            if (line.contains(this.name)) {
                System.out.println(">> The name [" + this.name + "]" + " already exist, try different name");
                System.exit(1);
            }
        }
        writer.write(this.name + ",");
        writer.write(this.type + ",");
        writer.write(this.level + ",");
        writer.write(this.experience + ",");
        writer.write(this.weapon + ",");
        writer.write(this.armor + ",");
        writer.write(this.hp + ",");
        writer.write(this.attack + ",");
        writer.write(this.defense + "\n");
        br.close();
        writer.close();
    }

    public void saveUIData(String name) throws IOException {
        File heroes = new File("heroes.txt");
        FileWriter writer = new FileWriter(heroes, true);
        BufferedReader br = new BufferedReader(new FileReader("heroes.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains(this.name)) {
                String message = "This name already exists";
                 JOptionPane.showMessageDialog(windowAlert, message, "Invalid Name",  JOptionPane.ERROR_MESSAGE);
                 System.exit(-1);
            }
        }
        writer.write(this.name + ",");
        writer.write(this.type + ",");
        writer.write(this.level + ",");
        writer.write(this.experience + ",");
        writer.write(this.weapon + ",");
        writer.write(this.armor + ",");
        writer.write(this.hp + ",");
        writer.write(this.attack + ",");
        writer.write(this.defense + "\n");
        br.close();
        writer.close();
    }

    public List<String> loadData(String name) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("heroes.txt"));
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains(this.name)) {
                list2.add(line);
                list.add(line.split(",")[0]);
            }
        }
        if (!list.contains(this.name)) {
            System.out.println(
                    ">> This name [" + this.name + "]" + " does not exist, check your spelling/create a new username.");
            System.exit(0);
        }
        br.close();
        return list2;

    }

    public void saveCurrentGame(String name, int experience2, int hp) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("heroes.txt"));
        List<String> list = new ArrayList<>();
        String line;

        this.experience = experience2;
        this.hp = hp;

        levelUp();
        while ((line = br.readLine()) != null) {
            if (line.contains(this.name)) {
                line = line.replaceAll(line,
                        this.name + "," + this.type + "," + this.level + "," + this.experience + "," + this.weapon + ","
                                + this.armor + "," + this.hp + "," + this.attack + "," + this.defense);
            }
            list.add(line);
        }
        
        br.close();
        File heroes = new File("heroes.txt");
        heroes.delete();
        FileWriter writer = new FileWriter(heroes.getAbsoluteFile(), true);
        for (int i = 0; i < list.size(); i++) {

            if(!(Integer.parseInt(list.get(i).split(",")[6]) == 0)) {
                writer.write(list.get(i));
                writer.write("\n");
            }
        }
      
        writer.close();
    }

    public void saveCurrentGameUI(String name, int level, int exp,  int hp, int attack, int defense) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("heroes.txt"));
        List<String> list = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            if (line.contains(name)) {
                line = line.replaceAll(line,
                        name + "," + this.type + "," + level + "," + exp + "," + this.weapon + ","
                                + this.armor + "," + hp + "," + attack + "," + defense);
            }
            list.add(line);
        }
        
        br.close();
        File heroes = new File("heroes.txt");
        heroes.delete();
        FileWriter writer = new FileWriter(heroes.getAbsoluteFile(), true);
        for (int i = 0; i < list.size(); i++) {

            if(!(Integer.parseInt(list.get(i).split(",")[6]) == 0)) {
                writer.write(list.get(i));
                writer.write("\n");
            }
        }
      
        writer.close();
    }

    
    private void levelUp() {
            int totalLevel = this.level * 1000 +((this.level -1)*(this.level -1))*450;
            totalLevel =+ this.experience;
        
            if(this.level == 1 && totalLevel > 2450) {

                if(totalLevel > 2450 && this.hp != 0) {
                    this.level = this.level + 1;this.defense = this.defense + 10;this.attack = this.attack + 10;
                }
            }else if(this.level == 2 && totalLevel > 4800) {
                if(totalLevel > 4800 && this.hp != 0) {
                    this.level = this.level + 1;this.defense = this.defense+10;this.attack = this.attack + 10;
                }
            }else if(this.level == 3 && totalLevel > 8050) {
                if(totalLevel > 8050 && this.hp != 0) {
                    this.level = this.level + 1;this.defense = this.defense + 10;this.attack = this.attack + 10;
                }
            }

    }

    public String getArmor() {
        return armor;
    }
    public void setArmor(String armor) {
        this.armor = armor;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getHp() {
        return hp;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public String getWeapon() {
        return weapon;
    }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getAttack() {
        return attack;
    }
    public int getDefense() {
        return defense;
    }
 
}
