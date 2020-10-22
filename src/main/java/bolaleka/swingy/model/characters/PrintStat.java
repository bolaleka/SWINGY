package bolaleka.swingy.model.characters;

import java.io.IOException;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import bolaleka.swingy.model.storage.Storage;

public class PrintStat {

    @NotNull
    String name;
    @NotNull
    String type;
    int hp;
    @Min(1)
    int level = 1;
    int experience;
    static int mapSize;
    int attack;
    int defense;
    //Storage data =  new Storage(name);
    List<String> list;

    public PrintStat(String name) throws IOException {
        mapSize = (this.level - 1) * 5 + 10 - (this.level % 2);
    }

    public void displayStat(String name) throws IOException {
        Storage data =  new Storage(name);
        list = data.loadData(name);
            System.out.println("                                            STATS");
            System.out.println("......................................................");
            System.out.println("\t\t\tName:\t\t        "+list.toString().replace("[", "").split(",")[0]);
            System.out.println("\t\t\tHP:\t\t        "+list.toString().split(",")[6]);
            System.out.println("\t\t\tLevel:\t\t        "+list.toString().split(",")[2]);
            System.out.println("\t\t\tAttack:\t\t        "+list.toString().split(",")[7]);
            System.out.println("\t\t\tDefense:\t\t"+list.toString().replace("]", "").split(",")[8]);
            System.out.println("\t\t\tExperience:\t\t"+list.toString().split(",")[3]);
            System.out.println("\t\t\tmapSize:\t\t"+mapSize);

    }

   

    public static int getCoordinates() {
        return mapSize;
    }



}
