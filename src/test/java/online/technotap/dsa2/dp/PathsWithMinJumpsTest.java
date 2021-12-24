package online.technotap.dsa2.dp;

import org.junit.jupiter.api.Test;

class PathsWithMinJumpsTest {

    @Test
    void printJumpAndPath() {
        var solution = new PathsWithMinJumps();
        int[] input = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
        solution.printJumpAndPath(input);
    }
}