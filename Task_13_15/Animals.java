package Task_13_15;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Animals {
    private final String name_animal; // name animal
    private final Date date_of_birth; // date of birth
    private final String group_animal; // pets and pack
    private final String type_animal; // dog,cat, hamster, horse, camel, donkey
    private final SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    public Animals(String name, Date date_of_birth, String group_animal, String type_animal) {
        this.name_animal = name;
        this.date_of_birth = date_of_birth;
        this.group_animal = group_animal;
        this.type_animal = type_animal;
    }

    public String getAnimals() {
        return this.name_animal + " " + format.format(this.date_of_birth) + " " + this.group_animal + " "
                + this.type_animal;
    }
}
