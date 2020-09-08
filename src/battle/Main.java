package battle;

import battle.entity.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static final List<String> fighterNames = Arrays.asList("Rambo","Terminator","Killer","Mad","Dragon","Destroyer","Giant","Titan","Chack Norris","Ninja");

    private static String chooseName(){

        return fighterNames.get(ThreadLocalRandom.current().nextInt(0,fighterNames.size()));
    }

    private static Animal chooseFighter() {

        Animal randomFighter;
        int randNumberOfFighter = ThreadLocalRandom.current().nextInt(1,4);

        switch (randNumberOfFighter) {
            case 1: randomFighter = new Cat(chooseName());
                break;

            case 2: randomFighter = new Dog(chooseName());
                break;

            case 3: randomFighter = new Monkey(chooseName());
                break;

            default: randomFighter = new Cat(chooseName());
        }

        return randomFighter;
    }

    public static void main(String[] args) {

        int numberOfCombats = 2;
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

            combat.startCombat(firtsFighter, secondFighter);

            System.out.println("--------------------------");

        }
    }
}