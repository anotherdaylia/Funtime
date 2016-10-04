package com.lia.StackAndQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * return 13.
 *
 * Created by liqu on 9/25/16.
 */
public class KthSmallestEleInASortedMatrix_378 {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 0) return -1;
        Queue<Number> minPQ = new PriorityQueue<>(new Comparator<Number>() {
            @Override
            public int compare(Number n1, Number n2) {
                return n1.val - n2.val;
            }
        }); // maintain at most kth smallest Number
        boolean[][] visited = new boolean[n][n];

        int[] dx = {1, 0}; //down, right
        int[] dy = {0, 1}; //down, right

        int x = 0, y= 0;
        Number last = null;
        minPQ.add(new Number(x, y, matrix[x][y]));
        while (k != 0) {
            last = minPQ.poll();
            k--;
            for (int i = 0; i < dx.length; i++) {
                x = last.x + dx[i];
                y = last.y + dy[i];
                if (isValid(x, y, n, visited)) {
                    minPQ.add(new Number(x, y, matrix[x][y]));
                    visited[x][y] = true;
                }
            }
        }
        return last.val;
    }

    private boolean isValid(int x, int y, int n, boolean[][] visited){
        return (x < n && y < n && !visited[x][y]);
    }

    class Number{
        int x;
        int y;
        int val;
        public Number(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
