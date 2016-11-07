package cz.vsb.ekf.lan0116.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class ResourceUtil {

    private ResourceUtil() {
    }

    public static List<String> getResource(ResourceType resourceType, String fileName) {
        String path = resourceType.getPath() + fileName + resourceType.getExt();
        InputStream enemiesStream = ResourceUtil.class.getResourceAsStream(path);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(enemiesStream))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Game failed to load a resource.", e);
        }
    }
}
