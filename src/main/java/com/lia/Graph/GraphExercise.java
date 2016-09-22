package com.lia.Graph;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/**
 * Created by liqu on 9/13/16.
 */
public class GraphExercise implements GraphReadable{

    /*
    Detect if an undirected graph is Cyclic.
    return true if the graph contains a cycle, else false.
     */
    public boolean isCyclic() {
        // mark all vertices as not visited, not part of rec stack
        boolean[] visited = new boolean[NUM];
        for (int i = 0; i < NUM; i++) visited[i] = false;

        // Call the helper to detect cycle in different DFS trees
        for (Vertex v : graph) {
            if (!visited[v.val - 1]) {
                // only return when cycle is found
                if (isCyclicUntil(v, visited, null)) return true;
            }
        }
        return false;
    }

    /*
    A recursive helper function that uses visited[] and parent to detect cycle.
     */
    private boolean isCyclicUntil(Vertex v, boolean[] visited, Vertex parent) {
        // mark the current node as visited
        visited[v.val - 1] = true;

        for (Vertex u : v.neighbor){
            // if a neighbor is not visited, recur for that neighbor
            if (!visited[u.val - 1]) {
                if (isCyclicUntil(u, visited, v)) return true;
            // There is a cycle if the neighbor is visited and is not parent
            } else {
                if (u != parent) return true;
            }
        }
        return false;
    }

    /*
    Detect if an directed graph is Cyclic. Return true if the graph contains a cycle, else false.
     */
    public boolean isCyclicDAG(){
        // mark all vertices as not visited, not part of rec stack
        boolean[] visited = new boolean[NUM];
        for (int i = 0; i < NUM; i++) visited[i] = false;

        for (Vertex v : graph) {
            if (!visited[v.val - 1]){
                if (isCyclicDAG(v, visited)) return true;
            }
        }
        return false;
    }

    private boolean isCyclicDAG(Vertex v, boolean[] visited){
        visited[v.val - 1] = true;

        for (Vertex u : v.neighbor){
            if (visited[u.val - 1]) {
                return true;
            } else {
                if(isCyclicDAG(u, visited)) return true;
            }
        }
        return false;
    }

    /*
    Detect if an undirected graph is bipartite.
     */
    public boolean isBipartite() {
        boolean[] visited = new boolean[NUM];
        Color[] color = new Color[NUM];
        for (int i = 0; i < NUM; i++) visited[i] = false;

        for (Vertex v : graph) {
            if (!visited[v.val - 1]) {
                color[v.val - 1] = Color.black;
                if (!isBipartite(v, visited, color)) return false;
            }
        }
        return true;
    }

    private boolean isBipartite(Vertex v, boolean[] visited, Color[] color) {
        visited[v.val - 1] = true;

        for (Vertex u : v.neighbor){
            if (visited[u.val - 1]) {
                if (color[u.val - 1] == color[v.val - 1]) return false;
            } else {
                color[u.val - 1] = color[v.val - 1] == Color.black? Color.red : Color.black;
                isBipartite(u, visited, color);
            }
        }

        return true;
    }

    /*
    Topological sort by DFS
     */
    private int index = NUM - 1;
    private Vertex[] result = new Vertex[NUM];
    private Vertex[] topSort() throws Exception{
        boolean[] visited = new boolean[NUM];
        boolean[] processed = new boolean[NUM];
        for (int i = 0; i < NUM; i++) {
            visited[i] = false;
            processed[i] = false;
        }

        for (Vertex v : graph) {
            if (!visited[v.val - 1]) {
                topSort(v, visited, processed);
            } else if (!processed[v.val - 1]) {
                throw new Exception("This graph contains cycle.");
            }
        }
        return result;
    }

    private void topSort(Vertex v, boolean[] visited, boolean[] processed) throws Exception{
        visited[v.val - 1] = true;
        for (Vertex u : v.neighbor) {
            if (!visited[u.val - 1]) {
                topSort(u, visited, processed);
            } else if (!processed[v.val - 1]) {
                throw new Exception("This graph contains cycle.");
            }
        }
        processed[v.val - 1] = true;
        result[index] = v;
        index--;
    }

    public static void main(String[] args) throws Exception{
        GraphExercise ge = new GraphExercise();
        ge.readAdjlist("graph.txt");
        for(int i = 0; i < 3; i++){
            System.out.println("vertex: " + graph[i] + ", neighbor: " + graph[i].neighbor);
        }
        //System.out.println("isCyclicDAG: " + ge.isCyclic());
        //System.out.println("isCyclicDAG: " + ge.isBipartite());
        System.out.println("Toplogical order: " + Arrays.toString(ge.topSort()));
    }

}
