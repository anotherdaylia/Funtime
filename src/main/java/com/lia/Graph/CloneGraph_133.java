package com.lia.Graph;

import java.util.*;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 * Created by liqu on 9/6/16.
 */
public class CloneGraph_133 {

    private class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
    }

    /*
    DFS solution.
     */
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>(); // <orig.label, copy>

    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode orig) {
        if (orig == null) return null;

        if (map.containsKey(orig.label)) {
            return map.get(orig.label);
        }

        UndirectedGraphNode copy = new UndirectedGraphNode(orig.label);
        map.put(orig.label, copy);
        for (UndirectedGraphNode neighbor : orig.neighbors) {
            UndirectedGraphNode neighbor_copy = clone(neighbor);
            copy.neighbors.add(neighbor_copy);
        }
        return copy;
    }

    /*
    BFS solution.
    As we pop a node off the queue, we copy each of its neighbors, and push them to the queue.
     */
    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if (node == null) return null;

        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>(); // <orig.label, copy>
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        UndirectedGraphNode graph_copy = new UndirectedGraphNode(node.label);
        map.put(node.label, graph_copy);
        queue.add(node);

        while (!queue.isEmpty()) {
            // all nodes in the queue has a copy already created
            UndirectedGraphNode orig = queue.poll();
            UndirectedGraphNode copy = map.get(orig.label);
            // working on neighbors
            for (UndirectedGraphNode neighbor : orig.neighbors) {
                if (map.containsKey(neighbor.label)){
                    copy.neighbors.add(map.get(neighbor.label));
                }else {
                    // adding nodes not seen to the queue
                    UndirectedGraphNode neighbor_copy = new UndirectedGraphNode(neighbor.label);
                    copy.neighbors.add(neighbor_copy);
                    map.put(neighbor.label, neighbor_copy);
                    queue.add(neighbor);
                }
            }
        }

        return graph_copy;
    }
}
