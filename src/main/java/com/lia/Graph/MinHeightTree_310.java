package com.lia.Graph;

import java.util.*;

/**
 * For a undirected graph with tree characteristics, we can choose any node as the root.
 * The result graph is then a rooted tree. Among all possible rooted trees,
 * those with minimum height are called minimum height trees (MHTs). Given such a graph,
 * write a function to find all the MHTs and return a list of their root labels.

 Format
 The graph contains n nodes which are labeled from 0 to n - 1.
 You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 Example 1:
 Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 return [1]

 Example 2:
 Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 return [3,4]

 * Created by liqu on 6/29/16.
 */
public class MinHeightTree_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adjlist = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adjlist.add(new HashSet<>());
        for (int[] edge : edges) {
            adjlist.get(edge[0]).add(edge[1]);
            adjlist.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int v = 0; v < n; v++) if(adjlist.get(v).size() == 1) leaves.add(v);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adjlist.get(i).iterator().next();
                adjlist.get(j).remove(i);
                if (adjlist.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
