package com.narxoz.rpg.facade;

import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class RewardService {
    public void determineReward(HeroProfile hero, BossEnemy boss, AdventureResult result) {
        if (hero.isAlive()) {
            result.setWinner(hero.getName());
            result.setReward("Epic Boss Chest & 1000 Gold");
        } else {
            result.setWinner(boss.getName());
            result.setReward("None (Defeated)");
        }
    }
}