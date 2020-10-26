import java.io.*;


public class Day2 {
    public static void solveDay2() throws IOException {
        int[] input = readInput();

//        PART2
        calcForDay2Part2(19690720, input);

//        PART1
        input[1] = 12;
        input[2] = 2;
        System.out.println("Answer on part1 - " + calcForDay2Part1(input)[0]);
    }

    private static int[] readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("d:\\adventCode/day2.txt")));
        String[] strInput = br.readLine().split(",");
//        testing
//        String[] strInput = "1,9,10,3,2,3,11,0,99,30,40,50".split(",");
        int[] input = new int[strInput.length];
        int i = 0;
        for (String f : strInput) {
            input[i] = Integer.parseInt(f.trim());
            i++;
        }
        return input;
    }

    private static int[] calcForDay2Part1(int[] input) {
        int i = 0;
        while (i != input.length - 1) {
            if (input[i] == 1) {
                input[input[i + 3]] = input[input[i + 1]] + input[input[i + 2]];
                i += 4;
            } else if (input[i] == 2) {
                input[input[i + 3]] = input[input[i + 1]] * input[input[i + 2]];
                i += 4;
            } else if (input[i] == 99) {
                break;
            } else {
               throw new NumberFormatException("ERROR WITH OPCODE");
            }
        }
        return input;
    }

    private static void calcForDay2Part2(int properAddress0, int[] input) {
        for (int noun = 0; noun <= 99; noun++) {
            for (int verb = 0; verb <= 99; verb++) {
               int[] changedInput = input.clone();
                changedInput[1] = noun;
                changedInput[2] = verb;
                int[] test = calcForDay2Part1(changedInput);

                if(test[0] == properAddress0){
                    System.out.printf("Proper answer on Part2 -- %d x %d + %d = %d%n",
                            100, test[1], test[2], 100 * test[1] + test[2]);
                    return;
                }
            }
        }
        System.out.println("No such combination");
    }
}
