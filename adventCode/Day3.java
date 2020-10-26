import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Day3 {
    public static void solveDay3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("d:/adventCode/day3.txt")));
        Map<String, Integer> wire = new HashMap<>();
        int lowestDistance = Integer.MAX_VALUE;
        int lowestStep = Integer.MAX_VALUE;
        String[] input = br.readLine().split(",");
        int x = 0, y = 0, d = 0;

//      process wire1
        for(int i = 0; i < input.length;i++){
            int[] dir = getDirection(input[i].charAt(0));
            int len = Integer.parseInt(input[i].substring(1));
            for(int j = 0; j < len; j++){
                int newX = x + dir[0];
                int newY = y + dir[1];
                wire.put(newX + "_" + newY, ++d);
                x = newX;
                y = newY;
            }
        }

        input = br.readLine().split(",");
        x = y = d = 0;

        //process wire2
        for(int i = 0; i < input.length;i++){
            int[] dir = getDirection(input[i].charAt(0));
            int len = Integer.parseInt(input[i].substring(1));
            for(int j = 0; j < len; j++){
                int newX = x + dir[0];
                int newY = y + dir[1];
                d++;

                /**if map-wire already has such point-coordinate then it's intersection
                 * therefore, we already can find the lowest distance and the lowest step
                 */
                if(wire.containsKey(newX + "_" + newY)){
                    lowestDistance = Math.min(lowestDistance, (int) Math.abs(newX + newY));
                    lowestStep = Math.min(lowestStep, wire.get(newX + "_" + newY) + d);
                }
                x = newX;
                y = newY;
            }
        }

        System.out.printf("Lowest distance: %d%n", lowestDistance);
        System.out.printf("Lowest step: %d%n", lowestStep);
    }

    private static int[] getDirection(char c){
        switch(c){
            case 'U':
                return new int[]{0, 1};
            case 'D':
                return new int[]{0, -1};
            case 'L':
                return new int[]{-1, 0};
            case 'R':
                return new int[]{1,0};
        }
        return null;
    }
}
