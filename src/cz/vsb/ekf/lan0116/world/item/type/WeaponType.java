package cz.vsb.ekf.lan0116.world.item.type;

import cz.vsb.ekf.lan0116.world.creature.CreatureClass;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum WeaponType implements ItemType {
    UNISEX(EnumSet.allOf(CreatureClass.class)),

    MELEE(CreatureClass.WARRIOR),
    RANGED(CreatureClass.RANGER),
    WAND(CreatureClass.SORCERER);
    private final Set<CreatureClass> availableFor;

    WeaponType(CreatureClass availableFor) {
        this.availableFor = Collections.singleton(availableFor);
    }

    WeaponType(Set<CreatureClass> set) {
        this.availableFor = Collections.unmodifiableSet(set);
    }

    public Set<CreatureClass> getAvailableFor() {
        return availableFor;
    }

    @Override
    public ItemSuperType getSuperType() {
        return ItemSuperType.WEAPON;
    }
}
