package cz.vsb.ekf.lan0116.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Localization {

    private HashMap<String, String> localization;

    public Localization(List<String> file) {
        Map<String, String> collect = file.stream().map(line -> line.split(";")).collect(Collectors.toMap(x -> x[0], x -> x[1]));
        localization = (HashMap) collect;
    }

    public HashMap<String, String> setLocalization() {
        localization = new HashMap<>();
        List<String> localList = ResourceUtil.getResource(ResourceType.LOCALIZATION, "localization");
        for (String line : localList) {
            if (!line.isEmpty()) {
                String[] split = line.split(";");
                localization.put(split[0], split[1]);
            }
        }
//        localList.stream().map(line -> line.split(";")).collect(Collectors.toMap(x -> x[0], x -> x[1]));
        return localization;
    }

    public String get(String key) {
        if (localization.get(key) != null) {
            return localization.get(key);
        } else return key;

    }
}




