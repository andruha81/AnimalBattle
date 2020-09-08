package battle;

import battle.entity.*;

public class Main {

    public static void main(String[] args) {

        int numberOfCombats = 10;
        Combat combat;
        Animal firtsFighter;
        Animal secondFighter;

        for (int i = 1; i < numberOfCombats + 1; i++) {
            combat = new Combat();
            firtsFighter = new Cat("Vaska");
            secondFighter = new Dog("Sharik");

            System.out.println("Battle N_ " + i);

            System.out.println("First fighter: " + firtsFighter.getName());
            System.out.println("Force: " + firtsFighter.getForce());
            System.out.println("Agility: " + firtsFighter.getAgility());
            System.out.println("Rate decrease of endurance: " + firtsFighter.getRateDecreaseEndurance());

            System.out.println("First fighter: " + secondFighter.getName());
            System.out.println("Force: " + secondFighter.getForce());
            System.out.println("Agility: " + secondFighter.getAgility());
            System.out.println("Rate decrease of endurance: " + secondFighter.getRateDecreaseEndurance());

            Animal winner = combat.startCombat(firtsFighter, secondFighter);

        }
    }
}