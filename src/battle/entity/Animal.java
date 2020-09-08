package battle.entity;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {

    protected String name;
    protected int force;
    protected int agility;
    protected double endurance = 10.0;
    protected double rateDecreaseEndurance;
    protected double health = 30;

    public Animal(String newName) {
        this.name = newName;
        this.rateDecreaseEndurance = ThreadLocalRandom.current().nextDouble(0.5, 1.5);
    }

    public String getName() {
        return name;
    }

    public int getForce() {
        return force;
    }

    public void setForceAgility() {
    }

    public int getAgility() {
        return agility;
    }

    public double getEndurance() {
        return endurance;
    }

    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }

    public double getRateDecreaseEndurance() {
        return rateDecreaseEndurance;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
}
