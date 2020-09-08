package battle.entity;

import java.util.concurrent.ThreadLocalRandom;

public class Dog extends Animal{

    public Dog(String newName) {
        super(newName);

        this.typeOfAnimal = "Dog";
        setForceAgility();
    }

    @Override
    public void setForceAgility() {
        this.force = ThreadLocalRandom.current().nextInt(5,11);
        this.agility = ThreadLocalRandom.current().nextInt(1,6);
    }
}
