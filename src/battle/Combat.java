package battle;

import battle.entity.Animal;

import java.util.concurrent.ThreadLocalRandom;

public class Combat {

    int serialAttacks = 1;
    Animal winner;
    Animal attacker;
    Animal defender;

    public void startCombat(Animal firstFighter, Animal secondFighter){
        while (winner == null) {
            chooseWhoAttack(firstFighter, secondFighter);
            attack();
            checkWinner();
        }
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
            System.out.println("Another chance to attack for " + attacker.getName());
            serialAttacks += 1;

        } else {
            Animal fighter = attacker;
            attacker = defender;
            defender = fighter;
            serialAttacks = 1;
        }

        System.out.println("Attacking " + attacker.getName() + ", defending " + defender.getName());
    }

    private void attack(){
        double damage = (attacker.getForce() * attacker.getEndurance()) - (defender.getAgility() * defender.getEndurance());
        if (damage <=0){
            damage = 1;
        }

        System.out.println(defender.getName() + " is damaged by " + damage);

        defender.setHealth(damage);
        defender.setEndurance();
        attacker.setEndurance();

        System.out.println(defender.getName() + " health is " + defender.getHealth());
    }

    private void checkWinner(){
        if (defender.getHealth() == 0) {
            winner = attacker;
            System.out.println("The winner is " + attacker.getName());
        }
    }

    private boolean checkLuckyAttack() {
        return (ThreadLocalRandom.current().nextInt(1,20 * serialAttacks) == 5);
    }
}
