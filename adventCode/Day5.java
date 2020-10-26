import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Opcodes (like 1, 2, or 99) mark the beginning of an instruction.
 * The values used immediately after an opcode, if any, are called the instruction's parameters.
 *
 * Opcode 1 adds together numbers read from two positions and stores the result in a third position.
 *
 * Opcode 2 works exactly like opcode 1, except it multiplies the two inputs instead of adding them.
 *
 * Opcode 3 takes a single integer as input and saves it to the position given by its only parameter.
 * For example, the instruction 3,50 would take an input value and store it at address 50.
 *
 * Opcode 4 outputs the value of its only parameter. For example, the instruction 4,50 would output the value at address 50.
 */
public class Day5 {
    public static void solveDay2() throws IOException {
        int[] input = readInput();

    }

    private static int[] readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("d:\\adventCode/day5.txt")));
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
}
