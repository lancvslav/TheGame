package cz.vsb.ekf.lan0116.combat;

public class Attack {

    private String name;
    private AttackProperty property;
    private float penetration;
    private float multiplier;
    private float staminaRequired;

    public Attack(String name, AttackProperty property, float penetration, float multiplier, float staminaRequired) {
        this.name = name;
        this.property = property;
        this.penetration = penetration;
        this.multiplier = multiplier;
        this.staminaRequired = staminaRequired;
    }

    public String getName() {
        return name;
    }

    public AttackProperty getProperty() {
        return property;
    }

    public float getPenetration() {
        return penetration;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public float getStaminaRequired() {
        return staminaRequired;
    }
}
