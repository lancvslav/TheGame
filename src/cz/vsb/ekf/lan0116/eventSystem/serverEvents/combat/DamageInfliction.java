package cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat;

import cz.vsb.ekf.lan0116.world.creature.Creature;

public class DamageInfliction implements FightResponse {

    private final Creature attacker;
    private final Creature defender;
    private final float damageDealt;

    public DamageInfliction(Creature attacker, Creature defender, float damageDealt) {
        this.attacker = attacker;
        this.defender = defender;
        this.damageDealt = damageDealt;
    }

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
