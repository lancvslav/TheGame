package cz.vsb.ekf.lan0116.eventSystem.events.combat;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.eventSystem.events.Event;
import cz.vsb.ekf.lan0116.eventSystem.events.EventType;
import cz.vsb.ekf.lan0116.eventSystem.events.type.CombatType;
import cz.vsb.ekf.lan0116.textUi.Context;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public class FightRoundEvent implements Event {

    private final Attack attack;
    private final Creature enemy;

    public FightRoundEvent(Creature enemy, Attack attack, Context context) {
        this.attack = attack;
        this.enemy = enemy;
    }

    public Attack getAttack() {
        return attack;
    }

    public Creature getEnemy() {
        return enemy;
    }

    @Override
    public EventType getType() {
        return CombatType.ATTACK_MOVE;
    }
}



