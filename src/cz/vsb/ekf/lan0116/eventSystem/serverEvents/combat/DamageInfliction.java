package cz.vsb.ekf.lan0116.eventSystem.serverEvents.combat;

import cz.vsb.ekf.lan0116.combat.Attack;
import cz.vsb.ekf.lan0116.world.creature.Creature;

public class DamageInfliction implements FightResponse {

    private final Creature attacker;
    private Attack attack;
    private final Creature defender;
    private final float damageDealt;

    public DamageInfliction(Creature attacker, Creature defender, float damageDealt) {
        this.attacker = attacker;
        this.defender = defender;
        this.damageDealt = damageDealt;
    }

    public DamageInfliction(Creature attacker, Attack attack, Creature defender, float damageDealt) {
        this.attacker = attacker;
        this.attack = attack;
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

    public Attack getAttack() {
        return attack;
    }

    public Creature getDefender() {
        return defender;
    }

    public float getDamageDealt() {
        return damageDealt;
    }
}
