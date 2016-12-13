package cz.vsb.ekf.lan0116.eventSystem.events.combat;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.world.creature.enemy.EnemyDeprecated;

public class FightRoundEvent implements Event {

    private final Attack attack;
    private final EnemyDeprecated enemyDeprecated;

    public FightRoundEvent(EnemyDeprecated enemyDeprecated, Attack attack, Context context) {
        this.attack = attack;
        this.enemyDeprecated = enemyDeprecated;
    }

    public Attack getAttack() {
        return attack;
    }

    public EnemyDeprecated getEnemyDeprecated() {
        return enemyDeprecated;
    }

    @Override
    public EventType getType() {
        return CombatType.ATTACK_MOVE;
    }
}



