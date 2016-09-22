package com.lia.Graph;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Let v and w be two vertices in a directed graph G = (V,E). Design a lineartime
 * algorithm to find the number of different shortest paths (not necessarily vertex
 * disjoint) between v and w. Note: the edges in G are unweighted.
 *
 * Created by liqu on 9/15/16.
 */
public class NumberOfShortestPaths implements GraphReadable {

    public int numOfShortestPaths(Vertex v, Vertex w) {
        int[] steps = new int[NUM]; // The distance of path to vertex i
        int[] count = new int[NUM]; // The number of path to vertex i
        boolean[] visited = new boolean[NUM];

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(v);
        visited[v.val - 1] = true;
        // the number of steps to v is 1, the number of path to v is 1
        steps[v.val - 1] = 1;
        count[v.val - 1] = 1;

        while(!queue.isEmpty()){
            Vertex s = queue.poll(); // start point

            for (Vertex t : s.neighbor){
                /* t is visited means we found some paths to it and saved the
                   shortest distance */
                if (visited[t.val - 1]){
                    // if current distance is larger than saved distance, update
                    if (steps[t.val - 1] > steps[s.val - 1] + 1) {
                        steps[t.val - 1] = steps[s.val - 1] + 1;
                        count[t.val - 1] = count[s.val - 1];
                    // if current distance equals to saved distance, add count to it
                    } else if (steps[t.val - 1] == steps[s.val - 1] + 1) {
                        count[t.val - 1] += count[s.val - 1];
                    }
                } else {
                    steps[t.val - 1] = steps[s.val - 1] + 1;
                    count[t.val - 1] = count[s.val - 1];
                    visited[t.val - 1] = true;
                    queue.add(t);
                }
            }
        }
        return count[w.val - 1];
    }

    public static void main(String[] args) throws IOException{
        NumberOfShortestPaths paths = new NumberOfShortestPaths();
        paths.readAdjlist("graph.txt");
        System.out.println(graph[0] + " -> " + graph[4]);
        int number = paths.numOfShortestPaths(graph[0], graph[4]);
        System.out.print("number of shortest path: " + number);
    }
}