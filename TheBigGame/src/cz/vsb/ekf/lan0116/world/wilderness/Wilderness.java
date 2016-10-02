package cz.vsb.ekf.lan0116.world.wilderness;

import cz.vsb.ekf.lan0116.world.Location;
import cz.vsb.ekf.lan0116.world.LocationType;
import java.util.List;

public class Wilderness extends Location {

    private List<Enemy> enemies;

    public Wilderness(String nameOfLocation) {
        super(nameOfLocation, LocationType.WILDERNESS);
//        List<String> enemiesString = ResourceUtil.getResource(ResourceType.DATA, nameOfLocation);
//        InputStream enemiesStream = Wilderness.class.getResourceAsStream("/data" + nameOfLocation + "Enemies.txt");
//        enemies = new ArrayList();
//        try (BufferedReader enemiesTxt = new BufferedReader(new InputStreamReader(enemiesStream))) {
//            String line;
//            while ((line = enemiesTxt.readLine()) != null) {
//                String[] split = line.split(";");
//                String name = split[0];
//                int maxHp = Integer.parseInt(split[1]);
//                int att = Integer.parseInt(split[2]);
//                int def = Integer.parseInt(split[3]);
//                Enum special = Attacks.valueOf(split[4]);
//                enemies.add(new Enemy(name, maxHp, att, def, special));
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(Wilderness.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
