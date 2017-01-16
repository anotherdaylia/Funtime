package com.lia.Backtracking;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.

 * Created by liqu on 6/21/16.
 */
public class WordSearch_79 {
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    /*
    A DFS helper function.
     */
    private boolean exist(char[][] board, int i, int j, String word, int k) {
        // base case 1: all character in word are checked and match
        if (k == word.length()) return true;

        /*
         start checking for this level.
         base case 2: index out of bound
         base case 3: char does not match or visited

         Note:
         1. case 1 must be checked first and separated with case 2 and case 3, b/c they check different levels.
         2. index check must be seperated with DFS calls, b/c still need to go to next level to check k.
          */
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(k) || visited[i][j]) return false;

        // general case
        visited[i][j] = true;
        if (exist(board, i - 1, j, word, k + 1) ||
                exist(board, i + 1, j, word, k + 1) ||
                exist(board, i, j - 1, word, k + 1) ||
                exist(board, i, j + 1, word, k + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
