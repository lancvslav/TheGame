package cz.vsb.ekf.lan0116.util;

public enum ResourceType {
    ARENA_ENEMY("/data/creatures/locationEnemies/arena/", "_Enemies.txt"),
    ATTACK_ALL("/data/",".csv"),
    CONSUMABLE_ALL("/data/merchandise/consumables/",".csv"),
    CONSUMABLE_SHOP("/data/merchandise/consumables/","_Consumables.txt"),
    DATA("/data/", ".txt"),
    DIALOGUE("/txt/dialogues/",".txt"),
    DRINK("/data/merchandise/consumables/",".drink_Consumables.txt"),
    CREATURES_ALL("/data/creatures/",".csv"),
    FOOD("/data/merchandise/consumables/",".food_Consumables.txt"),
    LOCALIZATION("/localization/", ".csv"),
    MERCHANDISE("/data/merchandise/", "_Merchandise.txt"),
    QUOTE("/txt/", "_Quote.txt"),
    TEXT("/txt/", ".txt"),
    UI("/ui/", "_Ui.txt"),
    WEAPON_ALL("/data/merchandise/weapons/", ".csv"),
    WEAPON_SHOP("/data/merchandise/weapons/shops/", "_Weapons.txt"),;

    private final String path;
    private final String ext;

    ResourceType(String path, String ext) {
        this.path = path;
        this.ext = ext;
    }

    public String getPath() {
        return path;
    }

    public String getExt() {
        return ext;
    }
}
