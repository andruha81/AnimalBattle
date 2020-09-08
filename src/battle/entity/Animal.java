package battle.entity;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {

    protected String name;
    protected String typeOfAnimal;
    protected int force;
    protected int agility;
    protected double endurance = 1.0;
    protected double rateDecreaseEndurance;
    protected double health = 10;

    public Animal(String newName) {
        this.name = newName;
        this.rateDecreaseEndurance = ThreadLocalRandom.current().nextDouble(0.05, 0.15);
    }

    public String getName() {
        return (typeOfAnimal + " " + name);
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

    public void setEndurance() {
        this.endurance = Math.max(0.1, this.endurance - rateDecreaseEndurance);
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double healthDamage) {
        this.health = Math.max(0, this.health - healthDamage);
    }

    public void printFighter(int fighterNumber) {
        System.out.println("Fighter " + fighterNumber + " " + getName());
        System.out.println("Force: " + force + ", Agility: " + agility + ", Rate decrease of endurance: " + rateDecreaseEndurance);
    }
}
