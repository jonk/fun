import java.util.Stack;
import java.util.Arrays;
import java.util.Collections;

class Problem14 {

    private static int[] cache = new int[1000001];

    public static void main(String[] args) {
        initializeCache();
        for (int curCollatz = 0; curCollatz <= 5; curCollatz++) {
            generateCollatzValues(curCollatz);
            if (curCollatz % 10000 == 0) {
                System.out.println(curCollatz);
            }
        }
        int max = 0;
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] > max) {
                max = cache[i];
            }
        }
        System.out.println(max);
    }

    /** Generates a stack of collatz values */
    private static void generateCollatzValues(int n) {
        Stack<Integer> collatzVals = new Stack<Integer>();
        while (n != 1) {
            if (cache[n] != -1) {
                collatzVals.push(n);
                n = nextCollatz(n);
                break;
            }
            updateCache(collatzVals);
        }
    }

    /** Updates our cache of collatz distances for values */
    private static void updateCache(Stack<Integer> nums) {
        int distanceFromOne = 1;
        while (!nums.empty()) {
            if (cache[nums.peek()] == -1) {
                cache[nums.pop()] = distanceFromOne;
            } else {
                nums.pop();
            }
            distanceFromOne++; 
        }
    }

    /** Returns the next collatz valule given an integer */
    private static int nextCollatz(int n) {
        return (n % 2 == 0) ? (n / 2) : (3 * n + 1);
    }

    /** 
     * Initializes our cache with -1, except for a 0 at 1.
     * This is so we don't keep checking cache[1] due to the while loop logic.
     */
    private static void initializeCache() {
        cache[0] = -1;
        cache[1] = 0;
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
    }
}