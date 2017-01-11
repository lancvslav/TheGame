package cz.vsb.ekf.lan0116.world.creature.humanoid;

import cz.vsb.ekf.lan0116.world.item.Merchandise;
import cz.vsb.ekf.lan0116.world.item.type.ItemType;

import java.util.List;
import java.util.Map;

public class Merchant extends Humanoid {

    private Map<ItemType, List<Merchandise>> merchandiseSupply;

    public Merchant(String merchantId) {
        super(merchantId);
    }

    public Map<ItemType, List<Merchandise>> getMerchandiseSupply() {
        return merchandiseSupply;
    }

    public List<Merchandise> getSpecificMerchandise(ItemType type) {
        return merchandiseSupply.get(type);
    }
}
