package com.lia.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liqu on 6/27/16.
 */
public class CourseScheduleII_210 {
    // DFS Solution
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int label = numCourses - 1;
        int[] result = new int[numCourses];
        boolean[] visited = new boolean[numCourses];

        ArrayList[] adjlist = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) adjlist[i] = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            adjlist[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        boolean[] recVisited = new boolean[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (!visited[course]) {
                label = dfs(adjlist, visited, recVisited, course, result, label);
                if(label == -2) return new int[0];
            }
        }
        return result;
    }

    private int dfs(ArrayList<Integer>[] adjlist, boolean[] visited, boolean[] recVisited, int course, int[] result, int label){
        //System.out.println("course: " + course + ", label: " + label);
        visited[course] = true;
        recVisited[course] = true;
        for (int c : adjlist[course]) {
            if (recVisited[c]) {
                label = -2;
                return label;
            }
            if (!visited[c]) label = dfs(adjlist, visited, recVisited, c, result, label);
            if(label == -2) return label;
        }
        recVisited[course] = false;
        result[label] = course;
        //System.out.println("result[0]: " + result[0] + ", result[1]: " + result[1] + ", result[2]: " + result[2] + ", result[3]: " + result[3]);
        label--;
        return label;
    }

    // BFS Solution
    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        int index = 0;
        int[] result = new int[numCourses];

        int[] degree = new int[numCourses];
        ArrayList[] adjlist = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) adjlist[i] = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            adjlist[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int course = 0; course < numCourses; course++){
            if (degree[course] == 0) queue.add(course);
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;

            for (int i = 0; i < adjlist[course].size(); i++) {
                int c = (int) adjlist[course].get(i);
                degree[c]--;
                if (degree[c] == 0) queue.add(c);
            }
        }

        if (index == numCourses) return result;
        else return new int[0];
    }
}
