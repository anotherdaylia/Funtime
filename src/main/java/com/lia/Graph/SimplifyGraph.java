package com.lia.Graph;

import java.io.IOException;
import java.util.*;

/**
 * Design a linear-time algorithm to eliminate each vertex v of degree 2 from
 a graph by replacing edges (u, v) and (v,w) by an edge (u,w). We also seek to
 eliminate multiple copies of edges by replacing them with a single edge. Note that
 removing multiple copies of an edge may create a new vertex of degree 2, which has
 to be removed, and that removing a vertex of degree 2 may create multiple edges,
 which also must be removed.

 * Created by liqu on 9/15/16.
 */
public class SimplifyGraph implements GraphReadable{

    public Vertex[] simplify(Vertex[] graph) {
        boolean[] visited = new boolean[NUM];
        Queue<Vertex> queue = new LinkedList<>();

        for (Vertex v : graph) {
            if (v.neighbor.size() >= 2) {
                queue.add(v);
                visited[v.val - 1] = true;
                break;
            }
        }

        Set<Vertex> set = new HashSet<>();
        while (!queue.isEmpty()){
            Vertex v = queue.poll();
            if (v.neighbor.size() == 2){
                shrink(v, visited, queue);
            } else if (v.neighbor.size() > 2) {
                Iterator<Vertex> it = v.neighbor.iterator();
                while(it.hasNext()){
                    Vertex neighbor = it.next();
                    if (set.contains(neighbor)) it.remove();
                    else set.add(neighbor);
                }
                set.clear();
                if (v.neighbor.size() == 2){
                    shrink(v, visited, queue);
                }
            }
        }

        return graph;
    }

    private void shrink(Vertex v, boolean[] visited, Queue<Vertex> queue){
        Vertex neighbor1 = v.neighbor.get(0);
        Vertex neighbor2 = v.neighbor.get(1);
        if (neighbor1 != neighbor2) {
            neighbor1.neighbor.remove(v);
            neighbor2.neighbor.remove(v);
            neighbor1.neighbor.add(neighbor2);
            neighbor2.neighbor.add(neighbor1);
            v.neighbor.remove(neighbor1);
            v.neighbor.remove(neighbor2);
            if (neighbor1.neighbor.size() >= 2 && !visited[neighbor1.val - 1]) {
                queue.add(neighbor1);
                visited[neighbor1.val - 1] = true;
            }
            if (neighbor2.neighbor.size() >= 2 && !visited[neighbor2.val - 1]) {
                queue.add(neighbor2);
                visited[neighbor2.val - 1] = true;
            }
        } else {
            v.neighbor.remove(neighbor1);
            neighbor1.neighbor.remove(v);

            if (neighbor1.neighbor.size() >= 2 && !visited[neighbor1.val - 1]) {
                queue.add(neighbor1);
                visited[neighbor1.val - 1] = true;
            }
        }

    }

    public static void main(String[] args) throws IOException{
        SimplifyGraph sg = new SimplifyGraph();
        sg.readAdjlist("graph.txt");
        sg.simplify(graph);
        for(int i = 0; i < graph.length; i++){
            System.out.println("vertex: " + graph[i] + ", neighbor: " + graph[i].neighbor);
        }
    }
}
