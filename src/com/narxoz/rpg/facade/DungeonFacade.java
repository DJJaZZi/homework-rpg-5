package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class DungeonFacade {
    private final PreparationService prepService;
    private final BattleService battleService;
    private final RewardService rewardService;

    public DungeonFacade() {
        this.prepService = new PreparationService();
        this.battleService = new BattleService();
        this.rewardService = new RewardService();
    }

    public AdventureResult runAdventure(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();

        boolean ready = prepService.prepare(hero, boss, action, result);
        if (!ready) {
            result.addLine("Preparation failed. Adventure aborted.");
            return result;
        }

        battleService.battle(hero, boss, action, result);

        rewardService.determineReward(hero, boss, result);

        return result;
    }
}