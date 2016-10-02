package cz.vsb.ekf.lan0116.world.items;

import cz.vsb.ekf.lan0116.world.creature.hero.HeroClass;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public enum WeaponType implements ItemType {
    UNISEX(EnumSet.allOf(HeroClass.class)),
    MELEE(HeroClass.WARRIOR),
    RANGED(HeroClass.RANGER),
    WAND(HeroClass.SORCERER);
    private final Set<HeroClass> availableFor;

    WeaponType(HeroClass availableFor) {
        this.availableFor = Collections.singleton(availableFor);
    }

    WeaponType(Set<HeroClass> set) {
        this.availableFor = Collections.unmodifiableSet(set);
    }

    public Set<HeroClass> getAvailableFor() {
        return availableFor;
    }

    @Override
    public ItemSuperType getSuperType() {
        return ItemSuperType.WEAPON;
    }
}
