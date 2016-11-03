package cz.vsb.ekf.lan0116.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Localization {

    private Map<String, String> localization;

    public Localization(List<String> file) {
        localization = file.stream()
                .filter(line -> !line.isEmpty())
                .map(line -> line.split(";"))
                .collect(Collectors.toMap(x -> x[0], x -> x[1]));
    }

    public String get(String key) {
        if (localization.get(key) != null) {
            return localization.get(key);
        } else return key;

    }
}




