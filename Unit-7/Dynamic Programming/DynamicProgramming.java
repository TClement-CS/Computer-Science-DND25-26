import java.util.HashMap;

public class DynamicProgramming {

    // Every day for the rest of the year, you're going to be given a choice between
    // two jobs to do:
    // one that is LOW stress, and one that is HIGH stress. Each job pays out a
    // dollar amount;
    // *usually* the high stress jobs pay more. However, after doing a high stress
    // job, you need to
    // REST for a day.

    // Given a list of all the payouts for all the low stress and high stress jobs,
    // what is the most amount of money you can get?

    // You can assume lowPayouts.length == highPayouts.length
    public static int hiLoStress(int[] lowPayouts, int[] highPayouts) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return hiLoHelper(0, lowPayouts, highPayouts, memo);
    }

    public static int hiLoHelper(int day, int[] lowPayouts, int[] highPayouts, HashMap<Integer, Integer> memo) {
        if (day >= lowPayouts.length) {
            return 0;
        }
        if (memo.containsKey(day)) {
            return memo.get(day);
        }
        int takeLow = lowPayouts[day] + hiLoHelper(day + 1, lowPayouts, highPayouts, memo);
        int takeHigh = highPayouts[day] + hiLoHelper(day + 2, lowPayouts, highPayouts, memo);
        int maxPayout = Math.max(takeLow, takeHigh);
        memo.put(day, maxPayout);
        return maxPayout;
    }

    // You are partaking in a scavenger hunt!
    // You've gotten a secret map to find many of the more difficult
    // items, but they are only available at VERY specific times at
    // specific places. You have an array, times[], that lists at which
    // MINUTE an item is available, in increasing order.
    // Items in the ScavHunt are worth varying numbers of points.
    // You also have an array, points[], same length as times[],
    // that lists how many points each of the corresponding items is worth.
    // Problem is: to get from one location to the other takes 5 minutes,
    // so if there is an item, for example, available at time 23 and another
    // at time 27, it's just not possible for you to make it to both: you'll
    // have to choose!
    // Write a method that returns the maximum POINTS you can get.
    public static int scavHunt(int[] times, int[] points) {
        HashMap<Integer, Integer> stored = new HashMap<>();
        return maxReward(times, points, 0, stored);
    }

    public static int maxReward(int[] times, int[] points, int index, HashMap<Integer, Integer> stored) {
        System.out.println("Index: " + index);
        if (index >= times.length) {
            return 0;
        }

        int tempIndex = -1;
        int maximum = 0;

        maximum = maxReward(times, points, index + 1, stored);

        int maxpoints = 0;
        int pointsofindex = points[index];
        for (int i = index + 1; i < times.length; i++) {
            if (times[i] >= 5 + times[index]) {
                System.out.println("Considering item at index " + i + " (time: " + times[i] + ")");
                tempIndex = i;
                break;
            }
        }
        if (tempIndex != -1) {
            pointsofindex += maxReward(times, points, tempIndex, stored);
        }
        int result = Math.max(maximum, pointsofindex);
        stored.put(index, result);
        System.out.println("Max points at index " + index + ": " + result);

        return result;
    }

    /*
     * Uses memoization to calculate the route which grants the most cookies,
     * starting at [0][0], only going right or down at each point
     */
    public static int dynamicCookies(int[][] cookieGrid) {
        HashMap<String, Integer> hmap = new HashMap<>();
        return recursiveCookies(0, 0, cookieGrid, hmap);
    }

    public static int recursiveCookies(int row, int col, int[][] cookieGrid, HashMap<String, Integer> hmap) {
        int numRows = cookieGrid.length;
        int numCols = cookieGrid[0].length;
        if (!validPoint(row, col, numCols, numRows, cookieGrid)) {
            return 0;
        }
        if (row == numRows - 1 && col == numCols - 1) {
            return cookieGrid[row][col];
        }
        int down = 0;
        int right = 0;
        String key = row + " " + col;
        if (hmap.containsKey(key)) {
            return hmap.get(key);
        }

        right = recursiveCookies(row, col + 1, cookieGrid, hmap);
        down = recursiveCookies(row + 1, col, cookieGrid, hmap);
        int maximum = Math.max(down, right);
        int result = cookieGrid[row][col] + maximum;
        hmap.put(key, result);

        return result;
    }

    private static boolean validPoint(int row, int col, int numCols, int numRows, int[][] cookieGrid) {

        if (row < numRows && col < numCols && cookieGrid[row][col] != -1) {
            return true;
        }
        return false;

    }
}
