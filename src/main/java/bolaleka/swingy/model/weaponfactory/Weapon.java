package bolaleka.swingy.model.weaponfactory;

import javax.validation.constraints.NotNull;

public class Weapon {
    @NotNull
    public String name;
    @NotNull
    public int attack;
}
