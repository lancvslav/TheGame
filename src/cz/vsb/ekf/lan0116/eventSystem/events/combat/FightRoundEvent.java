package cz.vsb.ekf.lan0116.eventSystem.events.combat;

import cz.vsb.ekf.lan0116.combat.AttackDeprecated;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.world.creature.enemy.Enemy;

public class FightRoundEvent implements Event {

    private final AttackDeprecated attackDeprecated;
    private final Enemy enemy;

    public FightRoundEvent(Enemy enemy, AttackDeprecated attackDeprecated, Context context) {
        this.attackDeprecated = attackDeprecated;
        this.enemy = enemy;
    }

    public AttackDeprecated getAttackDeprecated() {
        return attackDeprecated;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    @Override
    public EventType getType() {
        return CombatType.ROUND;
    }
}



