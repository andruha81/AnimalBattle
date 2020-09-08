package battle;

import battle.entity.Animal;

import java.util.concurrent.ThreadLocalRandom;

public class Combat {

    int serialAttacks = 1;
    Animal winner;
    Animal attacker;
    Animal defender;

    public Animal startCombat(Animal firstFighter, Animal secondFighter){
        while (winner == null) {
            chooseWhoAttack(firstFighter, secondFighter);
            attack();
            checkWinner();
        }

        return winner;
    }

    private void chooseWhoAttack(Animal firstFighter, Animal secondFighter){
        if (attacker == null) {
            if (ThreadLocalRandom.current().nextInt(0,2) == 0) {
                attacker = firstFighter;
                defender = secondFighter;
            } else {
                attacker = secondFighter;
                defender = firstFighter;
            }

        } else if (checkLuckyAttack()) {
            serialAttacks += 1;

        } else {
            Animal fighter = attacker;
            attacker = defender;
            defender = fighter;
            serialAttacks = 1;
        }
    }

    private void attack(){

    }

    private void checkWinner(){
        if (defender.getHealth() <= 0) {
            winner = attacker;
        }
    }

    private boolean checkLuckyAttack() {
        return (ThreadLocalRandom.current().nextInt(1,20 * serialAttacks) == 5);
    }
}
