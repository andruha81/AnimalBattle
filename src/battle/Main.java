package battle;

import battle.entity.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static Animal chooseFighter() {

        Animal randomFighter;
        int randNumberOfFighter = ThreadLocalRandom.current().nextInt(1,4);

        switch (randNumberOfFighter) {
            case 1: randomFighter = new Cat("V");
                break;

            case 2: randomFighter = new Dog("V");
                break;

            case 3: randomFighter = new Monkey("V");
                break;

            default: randomFighter = new Cat("V");
        }

        return randomFighter;
    }

    public static void main(String[] args) {

        int numberOfCombats = 10;
        List<String> fighterNames = Arrays.asList("Rambo","Terminator","Killer","Mad","Dragon","Destroyer","Giant");
        Combat combat;
        Animal firtsFighter;
        Animal secondFighter;

        for (int i = 1; i < numberOfCombats + 1; i++) {
            combat = new Combat();

            System.out.println("Battle N_ " + i);

            /*
            * Choose randomly first fighter and print him
             */
            firtsFighter = chooseFighter();
            firtsFighter.printFighter(1);

            /*
             * Choose randomly sdecond fighter and print him
             * It could the same type of animal
             */
            secondFighter = chooseFighter();
            secondFighter.printFighter(2);



            //Animal winner = combat.startCombat(firtsFighter, secondFighter);

            System.out.println("--------------------------");

        }
    }
}