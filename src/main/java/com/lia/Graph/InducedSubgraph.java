package com.lia.Graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an undirected graph G with n vertices and m edges, and an integer k,
 * give an O(m + n) algorithm that finds the maximum induced subgraph H of G
 * such that each vertex in H has degree ≥ k, or prove that no such graph exists.
 * An induced subgraph F = (U,R) of a graph G = (V,E) is a subset of U of the vertices
 * V of G, and all edges R of G such that both vertices of each edge are in U.
 *
 * Created by liqu on 9/14/16.
 */
public class InducedSubgraph implements GraphReadable{

    public List<Vertex> induce(Vertex[] graph, int k){
        int[] degree = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            degree[i] = graph[i].neighbor.size();
        }

        Queue<Vertex> queue = new LinkedList<>();
        for (int i = 0; i < NUM; i++) {
            if (degree[i] < k) queue.add(graph[i]);
        }

        while (!queue.isEmpty()){
            Vertex v = queue.poll();
            for (Vertex u : v.neighbor){
                u.removeEdge(v);
                if (u.neighbor.size() < k) queue.add(u);
            }
            graph[v.val - 1] = null;
        }

        List<Vertex> subgraph = new ArrayList<>();
        for (Vertex v : graph){
            if (v != null) subgraph.add(v);
        }

        return subgraph;
    }

    public static void main(String[] main) throws IOException{
        InducedSubgraph kcore = new InducedSubgraph();
        kcore.readAdjlist("graph.txt");
//        System.out.println("Original list:");
//        for(int i = 0; i < NUM; i++){
//            System.out.println("vertex: " + graph[i] + ", neighbor: " + graph[i].neighbor);
//        }
//        System.out.println("");

        int k = 2;
        List<Vertex> subgraph = kcore.induce(graph, k);

        System.out.println("Subgraph size: " + subgraph.size());
        for(int i = 0; i < subgraph.size(); i++){
            System.out.println("vertex: " + subgraph.get(i) +
                    ", neighbor: " + subgraph.get(i).neighbor);
        }
    }
}
