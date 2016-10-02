package cz.vsb.ekf.lan0116.util;

public enum ResourceType {
    LOCALIZATION("/localization/", ".csv"),
    DATA("/data/", ".txt"),
    TEXT("/txt/", ".txt"),
    UI("/ui/", "_Ui.txt"),
    WEAPONS("/data/merchandise/weapons/", "_Weapons.txt"),
    MERCHANDISE("/data/merchandise/", "_Merchandise.txt"),
    ARENA("/data/enemies/arena/", "_Enemies.txt"),
    QUOTE("/txt/", "_Quote.txt"),;

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
