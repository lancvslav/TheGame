package cz.vsb.ekf.lan0116.world.creature.humanoid;

import cz.vsb.ekf.lan0116.world.creature.CreatureClass;
import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.item.type.ItemType;

import java.util.List;

public class Merchant extends Humanoid {

    private List<List<Merchandise>> merchandiseSupply;

    public Merchant(String name, CreatureClass clazz, float maxLifeEssence, float maxStamina, float attackPower,
                    float defense, String weaponId, String... attacks) {
        super(name, clazz, maxLifeEssence, maxStamina, attackPower, defense, weaponId, attacks);
    }

    public List<List<Merchandise>> getMerchandiseSupply() {
        return merchandiseSupply;
    }

    public List<Merchandise> getSpecificMerchandise(ItemType type) {
        List<Merchandise> specificMerchandise = null;
        for (List<Merchandise> list : merchandiseSupply) {
            if (list.contains(type)) {
                specificMerchandise = list;
            }
        }
        return specificMerchandise;
    }
}
