import java.io.*;
import java.util.ArrayList;
import java.util.List;



//For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
public class Day1 {
    public static void solveDay1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("d:\\adventCode/day1.txt")));
        int finalFuelNeeded = 0;
        while(br.ready()){
            int mass = Integer.parseInt(br.readLine());
            int initModuleFuel = mass / 3 - 2;
            int allModuleFuel = calcForDay1Final(initModuleFuel);
            finalFuelNeeded += allModuleFuel;
        }
        System.out.println(finalFuelNeeded);
    }

    private static int calcForDay1Final (int fuel) {
        if(fuel > 0)
            return fuel + calcForDay1Final(fuel / 3 - 2);
        else
            return 0;
    }
}
