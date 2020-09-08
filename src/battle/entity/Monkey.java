package battle.entity;

import java.util.concurrent.ThreadLocalRandom;

public class Monkey extends Animal{

    public Monkey(String newName) {
        super(newName);

        this.typeOfAnimal = "Monkey";
        setForceAgility();
    }

    @Override
    public void setForceAgility() {
        this.force = ThreadLocalRandom.current().nextInt(4,8);
        this.agility = ThreadLocalRandom.current().nextInt(4,8);
    }

}
