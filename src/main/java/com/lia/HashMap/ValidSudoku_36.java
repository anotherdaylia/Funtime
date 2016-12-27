package com.lia.HashMap;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules: http://sudoku.com.au/TheRules.aspx
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Created by liqu on 4/13/16.
 */

public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        int size = board.length;

        for(int i = 0; i < size; i++) {
            boolean[] row = new boolean[size];
            for(int c = 0; c < size; c++) {
                if (board[i][c] != '.') {
                    int ix = board[i][c] - '1';
                    if(row[ix]) return false;
                    else row[ix] = true;
                }
            }
        }

        for(int i = 0; i < size; i++) {
            boolean[] col = new boolean[size];
            for(int r = 0; r < size; r++){
                if (board[r][i] != '.') {
                    int ix = board[r][i] - '1';
                    if(col[ix]) return false;
                    else col[ix] = true;
                }
            }
        }

        // The index of (x, y) needs attention
        for(int i = 0; i < size; i++) {
            boolean[] sqr = new boolean[size];
            for(int m = 0; m < size; m++) {
                int x = m / 3 + (i / 3) * 3;
                int y = m % 3 + (i % 3) * 3;

                if (board[x][y] != '.') {
                    int ix = board[x][y] - '1';
                    if(sqr[ix]) return false;
                    else sqr[ix] = true;
                }
            }
        }

        return true;
    }
}
