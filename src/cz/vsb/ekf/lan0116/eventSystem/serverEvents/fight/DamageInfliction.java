package cz.vsb.ekf.lan0116.eventSystem.serverEvents.fight;

import cz.vsb.ekf.lan0116.world.creature.Creature;

public class DamageInfliction implements FightResponse {
    private Creature attacker;
    private Creature defender;
    private float damageDealt;

    @Override
    public FightResponseType getType() {
        return FightResponseType.DAMAGE_INFLICTION;
    }

    public Creature getAttacker() {
        return attacker;
    }

    public Creature getDefender() {
        return defender;
    }

    public float getDamageDealt() {
        return damageDealt;
    }
}
