package Task_13_15;

import java.util.Date;

public class Dog extends Pets {
    public Dog(String name_animal, Date date_of_birth, String commands) {
        super(name_animal, date_of_birth, "dog", commands);
    }

    @Override
    public String toString() {
        return getAnimal();
    }
}
