package battle;

import battle.entity.Animal;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

public class Combat {

    int serialAttacks = 1;            // Серия атак
    int round = 1;                    // Номер хода
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

    /*
    * Выбор атакующего бойца
    * В первом ходе определяется случайно
    *  В последующих ходах каждому атакующему может выпасть счастливое число атаковать еще раз
    *  Если не выпала повторная атака, атакующий и защищающийся меняются местами
     */
    private void chooseWhoAttack(Animal firstFighter, Animal secondFighter){
        System.out.println("******* ROUND" + round + " *******");
        round++;

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

    /*
    * Проверка повезло ли атакующему нанести удар еще раз
    * С каждой повторной атакой вероятность уменьшается пропорцианально серии атак
     */
    private boolean checkLuckyAttack() {
        return (ThreadLocalRandom.current().nextInt(1,20 * serialAttacks) == 5);
    }

    /*
    * Нападение
    * Урон расчитывается исходя из силы в зависимости от велечины выносливости в данный момент
    * и от него отнимается велечина ловкости, которая тоже расчитывается в зависимости от выносливости
     */
    private void attack(){
        BigDecimal damage = attacker.getForce().multiply(attacker.getEndurance()).subtract(defender.getAgility().multiply(defender.getEndurance()));
        if (damage.compareTo(BigDecimal.ONE) <= 0){
            damage = BigDecimal.ONE;
        }

        System.out.println(defender.getName() + " is damaged by " + damage);

        defender.setHealth(damage);
        defender.setEndurance();
        attacker.setEndurance();

        System.out.println(defender.getName() + " health is " + defender.getHealth());
    }

    /*
    * Если у защищающегося здоровье равно 0, то атакующий признается победителем
     */
    private void checkWinner(){
        if (defender.getHealth().compareTo(BigDecimal.ZERO) == 0) {
            winner = attacker;
            System.out.println("******* ENF OF THE BATTLE *******");
            System.out.println("The winner is " + attacker.getName());
        }
    }
}
