import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AlgorithmsAndStuff {


    public static void main(String[] args) {
//        System.out.println(getEffectiveFib(1000))
// // fix naiveFib by memorization results;
//        int n = 1000;
//        long[] mem = new long[n + 1];
//        Arrays.fill(mem, -1); //fill #mem arr with -1
//        System.out.println(getNaiveFixedFib(n, mem));

//        int[] digits = {3, 1, 7, 9, 5, 9, 9};
//        System.out.println(maxNumFromDigits(digits));

//        int[] stations = {0, 200, 375, 550, 750, 950};
//        System.out.println(minStops(stations, 400));

//        getPrimeNumbers(100);
//        System.out.println("Is number is prime: " + isPrime(1));
//        isPolyndrom("dod");
//            listArmstrongNums(500000);
//            System.out.println(isArmstrong(1634));
//        getFactorial(4);
//        System.out.println(getRecursiveFact(4));
//        System.out.println(reverseString("hello"));

    }


    /**
     * General stuff
     * Big O difficulties
     * log n > sqrt(n) > n < (somewhat fine)n log n < (poor)n**2 > (terrible)2**n
     */

    /**
     * Gets FIBANACCI nums with effective O(n)
     * <p>
     * fib num is sum of current num and prev num till and the limit
     * effective solution because F(n) would cause n actions in func only
     * Algorithm difficulty O(n)
     **/

    private static long getEffectiveFib(int n) {
        // +1 to avoid out of boundary ex
        long[] arr = new long[n + 1]; // O(n)
        arr[0] = 0; //O(1)
        arr[1] = 1; //O(1)
        for (int i = 2; i <= n; i++) { //O(n)
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n]; //O(1)
    }
    //Evaluating alg
    //O(n) + O(1) + O(1) + O(n) + O(1) = O(2n) + O(3)=O(2n+3)=O(n)

    /**
     * gets fabbinaci nums with ineffective solution;
     * fibbinaci of 100 calc would be 10years
     * the recursive would increment the call every time as tree
     * because unnecessary tree like calls will be
     * Algorithm difficulty O(2^n)
     */
    private static long getNaiveFib(int n) {
        if (n <= 1) { //base
            System.out.print("Fib sum num: ");
            return n;
        } else { //core
            return getNaiveFib(n - 1) + getNaiveFib(n - 2);
        }
    }

    /**
     * Gets fab nums with Algorithm difficulty O(n)
     * Improves the naive solution via using memorization
     */

    private static long getNaiveFixedFib(int n, long[] mem) {
        if (mem[n] != -1)  //if mem arr already has recorded result then return it; no need to work
            return mem[n];

        if (n <= 1)  // constants in fib, f0=0, f1=1
            return n; //base

        //with this tree calls will not repeat itself; tree with only unique results
        long result = getNaiveFixedFib(n - 1, mem) + getNaiveFixedFib(n - 2, mem);
        mem[n] = result;
        return result;
    }

    /**
     * Find the biggest possible num from
     * arr nums using greedy algorithms
     * <p>
     * testcase: [1,3,9,2] -> 9321
     */
    private static String maxNumFromDigits(int[] digits) {
        // O(n*log(n)) sorting
        // O(n) iterate over sorted arr and add to str
        // result O(n*log(n))
        Arrays.sort(digits);
        StringBuilder result = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            result.append(digits[i]);
        }
        return String.join("", Arrays.stream(digits).boxed()
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .toArray(String[]::new));
    }


    /**
     * Binary Search
     * Looks for index of key
     * in a sorted array
     * Sort(O(nlogn) + search(logn))
     * If often check is there a num/index
     * then worth it otherwise just iteration is better
     */
    private static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) { //if no elements
            int middle = low + (high - low) / 2;
            if (key < a[middle]) {
                high = middle - 1;
            } else if (key > a[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


    /**
     * Gets Prime nums(an be divided by 1 and itself only)
     */
    private static void getPrimeNumbers(int limit) {
        System.out.print("Prime numbers: ");
        for (int i = 1; i < limit; i++) {
            int divs = 0;
            for (int j = 1; j < limit; j++) {
                if (i % j == 0) divs++;
            }
            if (divs == 2) { //prime number can be divided only by 1 and itself
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    /**
     * Checks whether num is prime
     */
    private static boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        num = (int) Math.sqrt(num);
        if (num % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks whether num is PALINDROME(word equals word.reverse())
     */
    private static boolean isPolyndrom(String word) {
        StringBuilder reverse = new StringBuilder(word).reverse();
        boolean isPolyndrom = word.toLowerCase().equals(reverse.toString().toLowerCase());
        System.out.printf("Is word %s polyndrom? - %b%n", word, isPolyndrom);
        return isPolyndrom;
    }

    /**
     * Checks whether num is PALINDROME(word equals word.reverse())
     * without using stringBuilder
     */
    private static boolean isPolyndromNoSb(String word) {
        String reverse = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }
        boolean isPolyndrom = word.toLowerCase().equals(reverse.toLowerCase());
        System.out.printf("Is word %s polyndrom? - %b%n", word, isPolyndrom);
        return isPolyndrom;
    }

    /**
     * Reverse word in place
     * reverse string in place -> meaning no additional variables except input one
     */
    private static String inPlaceReverse(final String input) {
        final StringBuilder builder = new StringBuilder(input);
        int length = builder.length();
        for (int i = 0; i < length / 2; i++) { //replace till reach the centrum
            final char current = builder.charAt(i);//go from beginning
            final int otherEnd = length - i - 1; //go from the end
            builder.setCharAt(i, builder.charAt(otherEnd)); // swap
            builder.setCharAt(otherEnd, current);
        }
        return builder.toString();
    }


    /**
     * Gets list of Armstrong nums
     * testcase: 153 is armstrong num -> 153 == (1**3 + 5**3 + 3**3)
     */
    private static void listArmstrongNums(int limit) {
        System.out.print("Armstrong numbers till " + limit + ": ");
        for (int i = 1; i <= limit; i++) {
            //deconstruct #i to separate nums}
            int[] numDeconstr = Arrays.stream(String.valueOf(i)
                    .split(""))
                    .mapToInt((num -> Integer.parseInt(num)))
                    .toArray();
            //count sum of nums in cube
            int armstrNum = 0;
            for (int num : numDeconstr) {
                armstrNum += (int) Math.pow(num, String.valueOf(i).length());
            }
            if (armstrNum == i) { //check whether armstr or
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    /**
     * Checks whether a num is an amrstrong num
     */
    private static boolean isArmstrong(int num) {
        int[] numDeconstr = Arrays.stream(String.valueOf(num)
                .split(""))
                .mapToInt((el -> Integer.parseInt(el)))
                .toArray();
        int armstr = 0;
        for (int el : numDeconstr) {
            armstr += Math.pow(el, String.valueOf(num).length());
        }
        System.out.println(armstr);
        return armstr == num;
    }

    /**
     * gets Factorial of a num
     * testcase: !n e.g !4 = 1*2*3*4(24)
     */
    private static void getFactorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        System.out.printf("Factorial of %d is %d%n", num, fact);
    }

    /**
     * gets Factorial of a num using recursion
     */
    private static int getRecursiveFact(int num) {
        if (num == 0) {
            return 1;
        } else {
            return getRecursiveFact(num - 1) * num;
        }
    }

    /**
     * Reverses a string using iteration
     */
    private static String reverseString(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }
        String reverse = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }
        return reverse;
    }

    /**
     * Two Sum
     * TODO: Given an array of integers nums and an integer target,
     * return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution,
     * and you may not use the same element twice.
     * <p>
     * finds two indexes of arr #nums that equals to #target
     * via brute force solution - O(n^2) (2 iterations)
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        int[] result = new int[2];
        //O(n)
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            //another O(n)
            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j];
                if (first + second == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * Gets two sum indexes via a hashtable for a lookup
     * and 1 iteration = 2 num passes
     */
    public int[] twoSumHashTwoPasses(int[] nums, int target) {
        //store {val, index} to check if second difference from target equals 0
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { //O(1) - fast lookup
            map.put(nums[i], i);
        }

        // in loop make first diff from target
        // and then check in map whether there's needed val to get 0
        for (int i = 0; i < nums.length; i++) { //O(n)
            int first = target - nums[i];
            if (map.containsKey(first) && map.get(first) != i) {
                return new int[]{i, map.get(first)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Gets two sum indexes via a hashtable for a lookup
     * and 1 iteration = 1 pass
     */
    public int[] twoSumHashOnePass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //in loop make first diff
        // and here also check second diff from target to get 0
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {//check whether there's another val to get 0
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

