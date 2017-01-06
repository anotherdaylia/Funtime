package com.lia.Mock;

import java.util.*;

/**
 * Input: a 2D grid with 0 in each cell. Some cells are marked as 1 and and connected to
 * connected components.
 * Question: Find the perimeters of the connected components.
 * Output: An array or a list of perimeters of all the connected components.
 *
 * Created by liqu on 7/5/16.
 */
public class Perimeter {
    public List<Integer> getPerimeter(int[][] grid) {
        List<Integer> perimeters = new ArrayList<>();
        if (grid == null || grid.length < 1) return perimeters;

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    perimeters.add(dfs(grid, visited, i, j));
                }
            }
        }
        return perimeters;
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid.length) return 0;
        if (grid[row][col] == 0) return 0;
        if (visited[row][col]) return 0;
        visited[row][col] = true;
        int p = 4 - getNeighbors(grid, row, col);
        p += (dfs(grid, visited, row - 1, col) +
             dfs(grid, visited, row + 1, col) +
             dfs(grid, visited, row, col - 1) +
             dfs(grid, visited, row, col + 1));
        return p;
    }

    private int getNeighbors(int[][] grid, int row, int col) {
        int neighbors = 0;
        if (row - 1 > 0 && grid[row - 1][col] == 1) neighbors++;
        if (row + 1 < grid.length && grid[row + 1][col] == 1) neighbors++;
        if (col - 1 > 0 && grid[row][col - 1] == 1) neighbors++;
        if (col + 1 < grid[0].length && grid[row][col + 1] == 1) neighbors++;
        return neighbors;
    }

    public static void main (String[] args) {
        int[][] grid = new int[5][5];
        grid[1][1] = 1;
        grid[1][2] = 1;
        grid[1][3] = 1;
        grid[2][2] = 1;
        grid[3][4] = 1;
        grid[4][4] = 1;

        Perimeter perimeter = new Perimeter();
        List<Integer> result = perimeter.getPerimeter(grid);
        for(int i : result) {
            System.out.println("perimeter: " + i);
        }
    }
}
