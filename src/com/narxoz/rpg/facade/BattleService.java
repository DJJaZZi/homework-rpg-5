package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class BattleService {
    public void battle(HeroProfile hero, BossEnemy boss, AttackAction action, AdventureResult result) {
        int round = 0;
        int maxRounds = 100;

        while (hero.isAlive() && boss.isAlive() && round < maxRounds) {
            round++;
            result.addLine("\n[Round " + round + "]");

            int damage = action.getDamage();
            boss.takeDamage(damage);
            result.addLine(hero.getName() + " attacks for " + damage + " damage! Boss HP: " + boss.getHealth());

            if (!boss.isAlive()) {
                result.addLine(boss.getName() + " has been defeated!");
                break;
            }

            int bossDamage = boss.getAttackPower();
            hero.takeDamage(bossDamage);
            result.addLine(boss.getName() + " strikes back for " + bossDamage + " damage! Hero HP: " + hero.getHealth());

            if (!hero.isAlive()) {
                result.addLine(hero.getName() + " has fallen...");
                break;
            }
        }

        result.setRounds(round);
    }
}