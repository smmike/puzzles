package solutions;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Solution to the CakeThief problem.
 * @author Mikhail Smirnov
 */

public class CakeThief {

    HashMap<CakeType, Integer> solution;
    /**
     * Takes an array of cake type objects and a weight capacity, and returns the maximum monetary value the duffel bag can hold.
     *
     * @param cakeTypes an array of cake type objects
     * @param capacity  Duffel bag weight capacity, can be 0
     * @return the maximum monetary value the duffel bag can hold.
     */
    public int maxDuffelBagValue(CakeType[] cakeTypes, int capacity) {
        solution = new HashMap<>();
        //sort cakeTypes according to their value-to-weight ratio, starting from
        // the most effective (descending order)
        Arrays.sort(cakeTypes, Collections.reverseOrder());
//        System.out.println(Arrays.toString(cakeTypes));
        //Now when cakes are in their efficiency order we can make a scan through the list
        // But first check some conditions
        if (cakeTypes[0].weight == 0) {
            solution.put(cakeTypes[0], Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        } else if (capacity == 0) {
            return 0;
        }
        return maxBagValue(cakeTypes, capacity, 0);
    }

    /**
     * Internal recursive implementation of the algorithm, that is performed on
     * sorted array of CakeTypes, where there’s no types with infinite ratio value/weight,
     * where value != 0 and weight = 0.
     * start - position in the cakeTypes array where we start scan, previous positions were
     * either uses or skipped
     */
    private int maxBagValue(CakeType[] cakeTypes, int capacity, int start) {
        if (capacity == 0) {
            return 0;
        }
        for (int idx = start; idx < cakeTypes.length; idx++) {
            System.out.println("checking " + cakeTypes[idx] + " for capacity " + capacity);
            if (cakeTypes[idx].weight > capacity) {
                continue;
            }
            int cakesNumber = capacity / cakeTypes[idx].weight;
            solution.put(cakeTypes[idx], cakesNumber);
            int remainingCapacity = capacity - cakesNumber * cakeTypes[idx].weight;
            return cakesNumber * cakeTypes[idx].value +
                    maxBagValue(cakeTypes, remainingCapacity, idx + 1);
        }
        return 0;
    }

    /**
     *
     * Prints the last solution of the problem as a sequence of Cake Types and the number of cakes of this type
     */
    public void printLastSolution() {
        System.out.print("Solution: ");
        for (CakeType key: solution.keySet()) {
            System.out.print(key + ": " + solution.get(key) + " times, ");
        }
        System.out.println();
    }


}
