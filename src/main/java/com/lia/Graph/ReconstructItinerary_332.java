package com.lia.Graph;

import java.util.*;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus,
 * the itinerary must begin with JFK.

 Note:
 If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order
 when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"]

 All airports are represented by three capital letters (IATA code).
 You may assume all tickets form at least one valid itinerary.

 Example 1:
 tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 Return ["JFK", "MUC", "LHR", "SFO", "SJC"].

 Example 2:
 tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

 * Created by liqu on 6/29/16.
 */
public class ReconstructItinerary_332 {
    /*
    Recursive solution.
    First keep going forward until you get stuck. That's a good main path already.
    Remaining tickets form cycles which are found on the way back and get merged into that main path.
    By writing down the path backwards when retreating from recursion, merging the cycles into the main path is easy
    - the end part of the path has already been written, the start part of the path hasn't been written yet,
    so just write down the cycle now and then keep backwards-writing the path.
     */
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> itinerary = new LinkedList<>();

        Map<String, PriorityQueue<String>> map = new HashMap<>(); //<From, PriorityQueue<To>>
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])){
                map.put(ticket[0], new PriorityQueue<>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }

        path(map, itinerary, "JFK");
        return itinerary;
    }

    private void path(Map<String, PriorityQueue<String>> map, LinkedList<String> itinerary, String departure) {
        PriorityQueue<String> arrivals = map.get(departure);
        // while loop to traverse all the neighbors
        while (arrivals != null && !arrivals.isEmpty()){
            path(map, itinerary, arrivals.poll());
        }
        itinerary.addFirst(departure);
    }

    /*
    Iterative solution.
    A. Start with an empty stack and an empty path
    - if all vertices have even degree - choose any of them.
    - if there are exactly 2 vertices having an odd degree -  choose one of them.
    B. If the current vertex has neighbor, add the vertex to the stack, take any of its neighbors, remove the edge between selected neighbor and that vertex, and set that neighbor as the current vertex.
       If the current vertex has no neighbors, add it to circuit(backwards?), remove the last vertex from the stack and set it as the current vertex.
    C. Repeat step B until the current vertex has no more neighbors and the stack is empty.
     */
    public List<String> findItineraryIterative(String[][] tickets) {
        LinkedList<String> itinerary = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>(); //<From, PriorityQueue<To>>

        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])){
                map.put(ticket[0], new PriorityQueue<>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()){
                stack.push(map.get(stack.peek()).poll());
            }
            itinerary.addFirst(stack.pop());
        }
        return itinerary;
    }
}
