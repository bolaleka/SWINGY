package bolaleka.swingy.controller;

import java.io.IOException;

import bolaleka.swingy.model.characters.Navigate;
import bolaleka.swingy.model.characters.PrintStat;
import bolaleka.swingy.model.storage.Storage;
import bolaleka.swingy.model.ui.UtilityMode;

public class DataController {

    Storage storage;
    PrintStat stat;
    Navigate navigate;
    UtilityMode modeUI;

    public DataController(String name) throws IOException {
        this.storage = new Storage(name);
        this.stat = new PrintStat(name);
        this.navigate = new Navigate();
        this.modeUI = new UtilityMode();
    }

    public Storage getStorage() {
        return storage;
    }

    public PrintStat getStat() {
        return stat;
    }

    public Navigate getNavigate() {
        return navigate;
    }

    public UtilityMode getModeUI() {
        return modeUI;
    }

}
