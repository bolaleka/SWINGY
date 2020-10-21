package bolaleka.swingy.model.characters;

import java.io.IOException;
import java.util.List;

import bolaleka.swingy.model.storage.Storage;

public class Monster {
    
    List<String> list;
    Storage level1;
    public String type;
    public int HP;
    public int attack;
    public int level;


    public Monster(String name) throws IOException {
        level1 = new Storage(name);
        list = level1.loadData(name);
        this.type = this.getClass().getSimpleName();
        this.HP = 20 * Integer.parseInt(list.toString().split(",")[2]);
        this.attack = 11 *  Integer.parseInt(list.toString().split(",")[2]);
        this.level =  Integer.parseInt(list.toString().split(",")[2]);
    }

    public int getAttack() {
        return attack;
    }

    public int getHP() {
        return HP;
    }
    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    
}
