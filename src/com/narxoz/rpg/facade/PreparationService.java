package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class PreparationService {
    public boolean prepare(HeroProfile hero, BossEnemy boss, AttackAction action, AdventureResult result) {
        if (hero == null || !hero.isAlive() || boss == null || !boss.isAlive() || action == null) {
            return false;
        }
        result.addLine(hero.getName() + " enters the dungeon to face " + boss.getName() + "!");
        result.addLine("Equipped attack: " + action.getActionName());
        result.addLine("Attack Effects: " + action.getEffectSummary());
        return true;
    }
}
