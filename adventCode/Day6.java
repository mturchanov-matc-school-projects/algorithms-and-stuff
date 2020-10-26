import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Day6 {
    public static int counter = 0;
    public static Map<String, String> map = new HashMap<>();
    public static Map<String, Integer> ways = new HashMap<>();

    public static void solveDay6() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("d:/adventCode/day6.txt")));
        while (br.ready()) {
            String[] strInput = br.readLine().split("\\)");
            String key = strInput[0];
            String orbit = strInput[1];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + "," + orbit);
            } else {
                map.put(key, orbit);
            }
        }

        //part 1 - get all distances
        getDistancesToPlanets("COM", 0);
        ways.forEach((k, v) -> { counter += v; });

        //part2 - find way from YOU to SAN
        AtomicReference<String> closestToYou = new AtomicReference<>("");
        map.forEach((k,v) -> {
            if(v.contains("YOU")) closestToYou.setRelease(k);
        });
        getDistancesToPlanets(closestToYou.get(), 0);
        System.out.println("Add direct/indirect orbit distance - " + counter);
        System.out.printf("smallest distance from YOU to SAN - %d%n", ways.get("SAN") - 1);
    }

    //handle keys
    public static void getDistancesToPlanets(String key, int distance) {
        if(!ways.containsKey(key)){
            ways.put(key, distance);
        }
        getDistancesToOrbits(key,distance);
        distance++;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String newKey = pair.getKey();
            List<String> newVals = Arrays.asList(pair.getValue().split(","));
            if(newVals.contains(key)){
                if(!ways.containsKey(newKey)){
                    ways.put(newKey, distance);
                    getDistancesToPlanets(newKey, distance);
                }
            }
        }
    }

    //handle vals
    public static void getDistancesToOrbits(String key, int distance) {
        distance++;
        String[] vals = map.get(key).split(",");
        for (String val : vals) {
            if (!ways.containsKey(val)) {
                ways.put(val, distance);
                if(val.equals("SAN")) return;
                if(map.containsKey(val)) {
                    getDistancesToOrbits(val, distance);
                }
            }
        }
    }
}




//    //for some reason it's working((
//    private static int findDistance(String valueToFind, int singleDistance) {
//        for (Map.Entry<String, String> pair : map.entrySet()) {
//            String key = pair.getKey();
//            List<String> vals = Arrays.asList(pair.getValue().split(","));
//            if (vals.contains(valueToFind)) {
//                System.out.println(singleDistance);
//                for (String v : vals) {
//                    if (v.equals(valueToFind)) {
//                        return findDistance(key, singleDistance + 1);
//                    }
//                }
//            }
//        }
//        return singleDistance;
//    }

//    private static void checkForPart1() {
//        for (Map.Entry<String, String> pair : map.entrySet()) {
//            int singleDistance = 1;
//            String key = pair.getKey();
//            List<String> vals = Arrays.asList(pair.getValue().split(","));
//            for (String v : vals) {
//                int dist = findDistance(key, singleDistance);
//                System.out.printf("key(valueToFind) - %s, vals - %s, dist - %d%n", key, vals, dist);
//                counter += dist;
//            }
//        }
//    }