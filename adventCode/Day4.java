import java.io.*;

public class Day4 {

    public static void solveDay4() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("d:/adventCode/day4.txt")));
        String[] strInput = br.readLine().split("-");
        int lowestPoint = Integer.parseInt(strInput[0]);
        int highestPoint = Integer.parseInt(strInput[1]);

        int countPart1 = 0;
        int countPart2 = 0;
        for(int i = lowestPoint; i < highestPoint; i++){
            if(checkForPart1(i)) {
                countPart1++;
                if(checkSingleDouble(i)) countPart2++;
            }
        }
        System.out.printf("Total Password Combinations:%n \tFor Part1: %d,%n\tfor Part2: %d%n", countPart1, countPart2);
    }

    private static boolean checkForPart1(int num){
        boolean isDouble = false;
        String[] sNums = Integer.toString(num).split("");
        int prevNum = Integer.parseInt(sNums[0]);
        for(int i = 1; i < sNums.length; i++){
            int currentNum = Integer.parseInt(sNums[i]);
            if(prevNum > currentNum) return false;
            if(currentNum == prevNum) isDouble = true;
            prevNum = currentNum;
        }
        return isDouble;
    }
    //part2
    private static boolean checkSingleDouble(int num){
        String[] s = Integer.toString(num).split("");
        int prevNum = Integer.parseInt(s[0]);
        int repeats = 0;
        for(int i = 1; i < s.length; i++){
            int currentNum = Integer.parseInt(s[i]);
            if(prevNum == currentNum) repeats++;
            if(prevNum != currentNum && repeats == 1
                    || repeats==1 && i == s.length - 1) {
                return true;
            } else if (prevNum != currentNum) repeats = 0;
            prevNum = currentNum;
        }
        return false;
    }
}
