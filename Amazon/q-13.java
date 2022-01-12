package Amazon;

import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] isVisited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(isVisited[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    boolean[][] check = new boolean[grid.length][grid[0].length];
                    helper(grid, isVisited, check, 0, i, j);
                }
            }
        }

        int globalTime = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0 && isVisited[i][j] == Integer.MAX_VALUE) {
                    return -1;
                }

                if (grid[i][j] != 0) {
                    globalTime = Math.max(globalTime, isVisited[i][j]);
                }
            }
        }

        return globalTime;
    }

    public void helper(int[][] grid, int[][] isVisited, boolean[][] check, int t, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || check[i][j] || grid[i][j] == 0) {
            return;
        }

        isVisited[i][j] = Math.min(isVisited[i][j], t);
        check[i][j] = true;
        helper(grid, isVisited, check, t + 1, i - 1, j);
        helper(grid, isVisited, check, t + 1, i + 1, j);
        helper(grid, isVisited, check, t + 1, i, j - 1);
        helper(grid, isVisited, check, t + 1, i, j + 1);
        check[i][j] = false;
    }

    public void print(int[][] isVisited) {
        for (int i = 0; i < isVisited.length; i++) {
            for (int j = 0; j < isVisited[0].length; j++) {
                System.out.print(isVisited[i][j] + " ");
            }
            System.out.println();
        }
    }
}
