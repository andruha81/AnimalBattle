package battle.entity;

import java.util.concurrent.ThreadLocalRandom;

public class Cat extends Animal{

    public Cat(String newName) {
        super(newName);

        this.typeOfAnimal = "Cat";
        setForceAgility();
    }

    @Override
    public void setForceAgility() {
        this.force = ThreadLocalRandom.current().nextInt(3,7);
        this.agility = ThreadLocalRandom.current().nextInt(5,9);
    }
}
