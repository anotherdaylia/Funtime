package com.lia.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liqu on 6/27/16.
 */

public class CourseSchedule_207 {
    // DFS Solution
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];

        ArrayList[] adjlist = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) adjlist[i] = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            adjlist[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!canFinish(adjlist, visited, course)) return false;
        }
        return true;
    }

    private boolean canFinish(ArrayList<Integer>[] adjlist, boolean[] visited, int course) {
        if (visited[course]) return false;
        else visited[course] = true;

        /*
        A cast of adjlist[course] to ArrayList<Integer> is required if not declare T in method signature
        */
        for (int c : adjlist[course]) {
            if (!canFinish(adjlist, visited, c)) return false;
        }
        visited[course] = false;
        return true;
    }

    // BFS Solution
    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        ArrayList<Integer>[] adjlist = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) adjlist[i] = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            adjlist[prerequisites[i][1]].add(prerequisites[i][0]);
            degree[prerequisites[i][0]]++;
        }

        int count = numCourses;
        Queue<Integer> queue = new LinkedList<>();
        for (int course = 0; course < degree.length; course++) {
            if (degree[course] == 0) {
                queue.add(course);
                count--;
            }
        }

        while(!queue.isEmpty()) {
            int course = queue.poll();
            for (int i = 0; i < adjlist[course].size(); i++) {
                /*
                 A cast of adjlist[course].get(i) to (int) is required if not declare T in Arraylist Arr at line 42
                 */
                int c = adjlist[course].get(i);
                degree[c]--;
                if (degree[c] == 0) {
                    queue.add(c);
                    count--;
                }
            }
        }
        return count == 0;
    }
}

