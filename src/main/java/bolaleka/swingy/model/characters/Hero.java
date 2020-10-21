package bolaleka.swingy.model.characters;

import javax.validation.constraints.NotNull;

import bolaleka.swingy.model.weaponfactory.Knife;
import bolaleka.swingy.model.weaponfactory.Weapon;
import bolaleka.swingy.model.weaponfactory.Armor.Armor;
import bolaleka.swingy.model.weaponfactory.Armor.SilverArmor;

@NotNull
public class Hero {
  
    public String type = this.getClass().getSimpleName();
    public int level = 1;
    public int experience = 1000;
    public int HP = 40 * this.level;
    public Weapon knife = new Knife();
    public Armor silverArmor = new  SilverArmor();
    public String weaponName = knife.name;
    public String armorName = silverArmor.name;
    public int attack = knife.attack;
    public int defense = silverArmor.defense;

    public int getHP() {
        return HP;
    }
    
}

