package cz.vsb.ekf.lan0116.combat;

import cz.vsb.ekf.lan0116.world.creature.Creature;

public class Fight {

    private Creature attacker;
    private Creature defender;

    public Fight(Creature attacker, Creature defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public Creature getAttacker() {
        return attacker;
    }

    public Creature getDefender() {
        return defender;
    }

    /**
     * @param attacker, defender
     * @return Damage done
     */
    public float attacking(Creature attacker, Creature defender) {
        this.attacker = attacker;
        this.defender = defender;
        float hitPower = attacker.getAttackPower();
        return this.defending(hitPower);
    }

    public float defending(float hitPower) {
        float damageDone = ((hitPower)/(1+(defender.getDefense()/100)));
        if (damageDone > 0) {
            return damageDone;
        } else {
            return 0;
        }
    }


}
