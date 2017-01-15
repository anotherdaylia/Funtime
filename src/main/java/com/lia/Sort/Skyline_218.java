package com.lia.Sort;

import java.util.*;

/**
 * Please see requirement at https://leetcode.com/problems/the-skyline-problem/
 * Created by liqu on 1/14/17.
 */
public class Skyline_218 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<Point> heights = new ArrayList<>();

        /* add points to heights list and sort:
           Sorting method:
           1. sort points by x first.
           2. if both on the left side, higher point go first.
              if both on the right side, lower point go first.
           3. left piont go first.
        */
        for (int[] b : buildings) {
            heights.add(new Point(b[0], b[2], true));
            heights.add(new Point(b[1], b[2], false));
        }
        Collections.sort(heights, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.x != p2.x) return p1.x - p2.x;
                if (p1.isLeft && p2.isLeft) {
                    return p2.y - p1.y;
                } else if (!p1.isLeft && !p2.isLeft) {
                    return p1.y - p2.y;
                } else {
                    if (p1.isLeft) return -1;
                    else return 1;
                }
            }
        });

        /* Use a maxPQ to keep track of the highest height.
           If a point is from left side, add it's height to the PQ - when its in the PQ meaning we have not scan through the rectangele. If a point is from right side, remove the height from the PQ.
           Everytime traverse a new point, compare the prevHighest height and curHighest height. If different, then need to add the current point's x and current highest height to result..
        */
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> (b - a));

        maxPQ.add(0); // ground height
        int prevHighest = 0; // ground height
        for (Point p : heights) {
            if (p.isLeft) maxPQ.add(p.y);
            else maxPQ.remove(p.y);

            int curHighest = maxPQ.peek();
            if (prevHighest != curHighest) {
                result.add(new int[] {p.x, curHighest});
                prevHighest = curHighest;
            }
        }
        return result;
    }

    /*
    Point class with info of its location and which side of rectangle it's at.
    */
    class Point {
        int x;
        int y;
        boolean isLeft;

        Point(int x, int y, boolean isLeft) {
            this.x = x;
            this.y = y;
            this.isLeft = isLeft;
        }
    }
}
