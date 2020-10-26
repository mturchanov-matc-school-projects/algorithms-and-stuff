import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Solution {
    /**
     *
     * Code Advent Results
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        /************************************************
         * Advent Code
         **********************************************/
//        Day1.solveDay1();
//        Day2.solveDay2();
//        Day3.solveDay3();
//        Day4.solveDay4();
//        Day6.solveDay6();


        /************************************************
         * Code Camp Algorithms
         **********************************************/
//        //sum all numbers in a range
//        int[] sumRange = {5, 10};
//        sumAll(sumRange);
//
//        //make a difference between arrays
//        Integer[] arr1 = {1, 2, 3, 5};
//        Integer[] arr2 = {1, 2, 3, 4, 5};
//        diffArray(arr1, arr2);
//
//        //filter array having additional arguments of a parameter
//        destroyer(arr1, 2, 3);
//
//        //format a string adding a - between words
//        spinalCase("Teletubbies say Eh-oh");
//        int[] arr = {1,1,1,1};
//        countPairs(arr, 2);
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
//        PrintWriter pw = new PrintWriter()

        BufferedReader reader = new BufferedReader(new InputStreamReader(new File("C:\\Users\\mih98\\OneDrive\\Рабочий стол\\unedited.txt")));
        Set<String> set = new TreeSet<>();
    }


    /**
     *
     * Intermediate Algorithm Scripting: Sum All Numbers in a RangePassed
     *
     * For example, sumAll([4,1]) should return 10 because sum of all the numbers
     * between 1 and 4 (both inclusive) is 10.
     *
     * @param arr array that consists 2 ends of a range
     */

    public static void sumAll (int[] arr) {
        int min = Math.min(arr[0], arr[1]);
        int max = Math.max(arr[0], arr[1]);
        int result = IntStream.rangeClosed(min,max).reduce( (acc, x) -> acc + x).getAsInt();
        System.out.println(result);
    }


    /**
     *
     * Compare two arrays and return a new array with any items only found
     * in one of the two given arrays, but not both. In other words, return the
     * symmetric difference of the two arrays.
     *
     * Note
     * You can return the array with its elements in any order.   *
     *
     * @param arr1 first array where the difference is looked
     * @param arr2 second array where the difference is looked
     */

    public static void diffArray(Integer[] arr1, Integer[] arr2) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(arr2));

        Set<Integer> r = Stream.concat(set1.stream(), set2.stream())
                .filter(i -> ! (set1.contains(i) && set2.contains(i)))
                .collect(Collectors.toSet());

        System.out.print("Arrays difference: ");
        for(Integer num : r){
            System.out.print(num + " ");
        }
    }

    /**
     *
     * the array is filtered from specified elements
     *
     * @param arr1 array that should be filtered
     * @param args specified elements that must be destroyed
     */
    public static void destroyer(Integer[] arr1, Integer... args){
        System.out.print("\nFiltered Array: ");
        System.out.print(Stream.of(arr1)
                .filter((x -> !Arrays.asList(args).contains(x)))
                .collect(Collectors.toList()));
    }


    /**
     * format a string adding a '-'
     * between words in small case
     *
     * @param str provided unformatted string
     * @returns {string} formatted string
     *
     */
    public static void spinalCase (String str) {
        String formattedString = str.replaceAll("([a-z])([A-Z])", "$1 $2")
        .replaceAll("\\s|_","-")
        .toLowerCase();

        System.out.println("\nFormatted String: " + formattedString);
    }


    /**
     * Given an array of integers, and a number ‘sum’,
     * find the number of pairs of integers in the array whose sum is equal to ‘sum’.
     *
     * Examples:
     *
     * Input  :  arr[] = {1, 5, 7, -1},
     *           sum = 6

     */
    public static void countPairs(int[] arr, int sum) {
        int counter = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int z = i + 1; z < arr.length; z++) {
                if(arr[i] + arr[z] == sum) counter++;
            }
        }
        System.out.printf("There's %d pairs that give the sum %d%n", counter, sum);
    }
}


