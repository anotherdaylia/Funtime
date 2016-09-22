package com.lia.Graph;

import java.util.LinkedList;

/**
 * Created by liqu on 9/13/16.
 */
class Vertex {
    int val;
    LinkedList<Vertex> neighbor = new LinkedList<>();

    Vertex(int v) { this.val = v; }
    void addEdge(Vertex vertex) { neighbor.add(vertex); }
    void removeEdge(Vertex vertex) { neighbor.remove(vertex); }
    public String toString() {
        return "value: " + this.val;
    }
}
