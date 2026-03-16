package com.narxoz.rpg;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.CriticalFocusDecorator;
import com.narxoz.rpg.decorator.FireRuneDecorator;
import com.narxoz.rpg.decorator.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        HeroProfile hero = new HeroProfile("TODO Hero", 150);
        BossEnemy boss = new BossEnemy("TODO Boss", 200, 25);

        // 1. Base Attack
        AttackAction basic = new BasicAttack("Sword Strike", 15);

        // 2. Combination A: Just Fire
        AttackAction fireStrike = new FireRuneDecorator(basic);

        // 3. Combination B: Poison + Crit
        AttackAction poisonCritStrike = new CriticalFocusDecorator(
                new PoisonCoatingDecorator(basic)
        );

        // 4. Combination C: The Supreme Stack (All 3 combined)
        AttackAction supremeStrike = new FireRuneDecorator(
                new PoisonCoatingDecorator(
                        new CriticalFocusDecorator(basic)
                )
        );

        System.out.println("--- Decorator Preview ---");
        System.out.println("1) Base action: " + basic.getActionName() + " | DMG: " + basic.getDamage() + " | SPEC: " + basic.getEffectSummary());
        System.out.println("2) Fire action: " + fireStrike.getActionName() + " | DMG: " + fireStrike.getDamage() + " | SPEC: " + fireStrike.getEffectSummary());
        System.out.println("3) Poison/Crit: " + poisonCritStrike.getActionName() + " | DMG: " + poisonCritStrike.getDamage() + " | SPEC: " + poisonCritStrike.getEffectSummary());
        System.out.println("4) Supreme:    " + supremeStrike.getActionName() + " | DMG: " + supremeStrike.getDamage() + " | SPEC: " + supremeStrike.getEffectSummary());


        System.out.println("\n--- Facade Preview ---");
        DungeonFacade facade = new DungeonFacade().setRandomSeed(42L);
        AdventureResult result = facade.runAdventure(hero, boss, supremeStrike);

        for (String line : result.getLog()) {
            System.out.println(line);
        }

        System.out.println("\n--- RUN SUMMARY ---");
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Reward: " + result.getReward());

        System.out.println("\n=== Demo Complete ===");
    }
}
