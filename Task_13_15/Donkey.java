package Task_13_15;

import java.util.Date;

public class Donkey extends Pack {
    public Donkey(String name_animal, Date date_of_birth, String commands) {
        super(name_animal, date_of_birth, "donkey", commands);
    }

    @Override
    public String toString() {
        return getAnimal();
    }
}
