package cz.vsb.ekf.lan0116.world.items;

import cz.vsb.ekf.lan0116.world.creature.hero.HeroClass;

import java.util.Collections;
import java.util.Set;

public enum WeaponType {
    MELEE(HeroClass.WARRIOR),
    RANGED(HeroClass.RANGER),
    WAND(HeroClass.SORCERER);
    private final Set<HeroClass> availableFor;

    WeaponType(HeroClass availableFor) {
        this.availableFor = Collections.singleton(availableFor);
    }

    public Set<HeroClass> getAvailableFor() {
        return availableFor;
    }

}
