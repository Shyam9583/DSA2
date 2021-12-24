package online.technotap.dsa2.dp;

import java.util.LinkedList;

/**
 * Finds the paths which reach the end with minimum number of jumps
 */
public class PathsWithMinJumps {

    private static final int INFINITY = Integer.MAX_VALUE >> 1;

    /**
     * The method prints
     * 1. Minimum number of jumps to reach the end (-1 if it's not possible)
     * 2. The list of paths to reach the end
     *
     * @param arr array denoting the steps possible at each point
     */
    public void printJumpAndPath(int[] arr) {
        int n = arr.length;
        var dp = new int[n];
        var queue = new LinkedList<PathEntry>();

        for (int i = n - 2; i >= 0; i--) {
            int min = INFINITY;
            for (int j = i + 1; j <= i + arr[i] && j < n; j++) {
                min = Math.min(min, dp[j]);
            }
            dp[i] = min + 1;
        }

        if (dp[0] >= INFINITY) {
            System.out.println(-1);
            return;
        }

        System.out.println(dp[0]);

        queue.add(new PathEntry());

        while (!queue.isEmpty()) {
            var curr = queue.remove();

            if (curr.index == n - 1) {
                System.out.println(curr.path);
                continue;
            }

            int target = dp[curr.index] - 1;
            int from = curr.index + 1;
            int to = curr.index + arr[curr.index] + 1;

            for (int j = from; j < n && j < to; j++) {
                if (dp[j] != target) continue;
                queue.add(new PathEntry(j, curr.path));
            }
        }
    }

    private static class PathEntry {
        int index;
        String path;

        PathEntry(int index, String existing) {
            this.index = index;
            this.path = existing + "->" + index;
        }

        PathEntry() {
            this.index = 0;
            this.path = "0";
        }
    }
}
