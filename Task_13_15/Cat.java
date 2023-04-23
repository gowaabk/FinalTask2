package Task_13_15;

import java.util.Date;

public class Cat extends Pets {
    public Cat(String name_animal, Date date_of_birth, String commands) {
        super(name_animal, date_of_birth, "cat", commands);
    }

    @Override
    public String toString() {
        return getAnimal();
    }
}
