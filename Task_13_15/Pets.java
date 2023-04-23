package Task_13_15;

import java.util.Date;

public class Pets extends Animals {
    private String commands;

    public Pets(String name_animal, Date date_of_birth, String type, String commands) {
        super(name_animal, date_of_birth, "pets", type);
        this.commands = commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public String getAnimal() {
        return getAnimals() + " " + this.commands;
    }
}
