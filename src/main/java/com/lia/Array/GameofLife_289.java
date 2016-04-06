package com.lia.Array;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised
 * by the British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its
 * eight neighbors (horizontal, vertical, diagonal) using the following four rules:
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * Write a function to compute the next state (after one update) of the board given its current state.
 *
 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated at the same time:
 * You cannot update some cells first and then use their updated values to update other cells.
 *
 * In this question, we represent the board using a 2D array. In principle, the board is infinite,
 * which would cause problems when the active area encroaches the border of the array.
 * How would you address these problems?
 *
 * Created by liqu on 3/22/16.
 */

import java.util.HashMap;

public class GameofLife_289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;

        HashMap<Integer, Integer> life = new HashMap<>();
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                int ix = getIndex(x,y,n);
                life.put(ix, 0);

                // northwest
                if (x > 0 && y > 0) {
                    life.put(ix, life.get(ix) + board[x-1][y-1] + board[x-1][y] + board[x][y-1]);
                } else if (x > 0) { //west
                    life.put(ix, life.get(ix) + board[x-1][y]);
                } else if (y > 0) { //east
                    life.put(ix, life.get(ix) + board[x][y-1]);
                }

                // southeast
                if (x < m - 1 && y < n - 1) {
                    life.put(ix, life.get(ix) + board[x+1][y+1] + board[x+1][y] + board[x][y+1]);
                } else if (x < m - 1) { //south
                    life.put(ix, life.get(ix) + board[x+1][y]);
                } else if (y < n - 1) { //east
                    life.put(ix, life.get(ix) + board[x][y+1]);
                }

                // northeast
                if (x > 0 && y < n - 1) {
                    life.put(ix, life.get(ix) + board[x-1][y+1]);
                }

                // southwest
                if (x < m - 1 && y > 0) {
                    life.put(ix, life.get(ix) + board[x+1][y-1]);
                }

            }
        }

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                int lifepoint = life.get(getIndex(x,y,n));
                if (board[x][y] == 0) { //current status is dead
                    if (lifepoint == 3) board[x][y] = 1;
                } else { //current status is live
                    if (lifepoint < 2 || lifepoint > 3) board[x][y] = 0;
                }
            }
        }
    }

    private int getIndex(int x, int y, int n) {
        return (x * n + y);
    }

    public void gameOfLifeInPlace(int[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                // the tens digit stores the live status
                // the unit digit stores the life point (which woundn't be greater than 8)
                board[x][y] = 10 * board[x][y];
            }
        }

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {

                // northwest
                if (x > 0 && y > 0) {
                    board[x][y] += board[x-1][y-1]/10 + board[x-1][y]/10 + board[x][y-1]/10;
                } else if (x > 0) { //west
                    board[x][y] += board[x-1][y]/10;
                } else if (y > 0) { //east
                    board[x][y] += board[x][y-1]/10;
                }

                // southeast
                if (x < m - 1 && y < n - 1) {
                    board[x][y] += board[x+1][y+1]/10 + board[x+1][y]/10 + board[x][y+1]/10;
                } else if (x < m - 1) { //south
                    board[x][y] += board[x+1][y]/10;
                } else if (y < n - 1) { //east
                    board[x][y] += board[x][y+1]/10;
                }

                // northeast
                if (x > 0 && y < n - 1) {
                    board[x][y] += board[x-1][y+1]/10;
                }

                // southwest
                if (x < m - 1 && y > 0) {
                    board[x][y] += board[x+1][y-1]/10;
                }

            }
        }

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                int lifestatus = board[x][y] / 10;
                int lifepoint = board[x][y] % 10;
                board[x][y] = lifestatus;
                if (lifestatus == 0) { //current status is dead
                    if (lifepoint == 3) board[x][y] = 1;
                } else { //current status is live
                    board[x][y] = lifestatus;
                    if (lifepoint < 2 || lifepoint > 3) board[x][y] = 0;
                }
            }
        }
    }
}
