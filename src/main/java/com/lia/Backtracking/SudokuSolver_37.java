package com.lia.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 *
 * Created by liqu on 8/23/16.
 */
public class SudokuSolver_37 {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length < 1) return;
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int row, int col) {
        int X = 0, Y = 0;
        boolean finished = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    X = i;
                    Y = j;
                    finished = false;
                    break;
                }
            }
        }

        if (finished) return true;

        List<Character> freeNum = getFreeNum(board, X, Y);
        if (freeNum.isEmpty()) return false;
        System.out.println("(" + X + ", " + Y + "), " + freeNum.toString());

        for (char ch : freeNum) {
            board[X][Y] = ch;
            if (solveSudoku(board, X, Y)) {
                return true;
            }
            board[X][Y] = '.';
        }
        return false;
    }

    //System.out.println("(" + i + ", " + j + "), " + freeNum.toString());
    private List<Character> getFreeNum(char[][] board, int row, int col) {
        List<Character> freeNum = new ArrayList<>();
        char c = '1';
        while (c <= '9') {
            freeNum.add(c);
            c++;
        }
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] != '.') freeNum.remove((Character) board[row][j]);
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != '.') freeNum.remove((Character) board[i][col]);
        }

        int left = (row / 3) * 3, up = (col / 3) * 3;
        for (int i = up; i < up + 3; i++) {
            for (int j = left; j < left + 3; j++) {
                if (board[i][j] != '.') freeNum.remove((Character) board[i][j]);
            }
        }
        return freeNum;
    }
}
