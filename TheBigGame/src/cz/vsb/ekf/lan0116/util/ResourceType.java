package cz.vsb.ekf.lan0116.util;

public enum ResourceType {
    ARENA("/data/enemies/arena/", "_Enemies.txt"),
    CONSUMABLE("/data/merchandise/consumables/","_Consumables.txt"),
    DATA("/data/", ".txt"),
    DRINK("/data/merchandise/consumables/",".drink_Consumables.txt"),
    FOOD("/data/merchandise/consumables/",".food_Consumables.txt"),
    LOCALIZATION("/localization/", ".csv"),
    MERCHANDISE("/data/merchandise/", "_Merchandise.txt"),
    QUOTE("/txt/", "_Quote.txt"),
    TEXT("/txt/", ".txt"),
    UI("/ui/", "_Ui.txt"),
    WEAPONS("/data/merchandise/weapons/", "_Weapons.txt"),;

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
