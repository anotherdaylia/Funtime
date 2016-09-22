package com.lia.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by liqu on 9/14/16.
 */
interface GraphReadable {

    int NUM = 5; // number of vertices
    Vertex[] graph = new Vertex[NUM];

    default void readAdjlist(String str) throws IOException {
        // initialize graph vertices
        for (int i = 1; i <= NUM; i++) {
            Vertex v = new Vertex(i);
            graph[i - 1] = v;
        }

        BufferedReader rd = new BufferedReader(new FileReader(str));
        while(true) {
            String line = rd.readLine();
            if (line == null) break;

            String[] edge = line.split("\\s+");
            int head = Integer.valueOf(edge[0]);
            int tail = Integer.valueOf(edge[1]);
            graph[head - 1].addEdge(graph[tail - 1]);
        }
        rd.close();
    }
}
