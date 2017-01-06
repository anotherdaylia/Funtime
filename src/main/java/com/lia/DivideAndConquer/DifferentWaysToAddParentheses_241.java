package com.lia.DivideAndConquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways
 * to group numbers and operators. The valid operators are +, - and *.

 Example 1
 Input: "2-1-1".

 ((2-1)-1) = 0
 (2-(1-1)) = 2
 Output: [0, 2]

 Example 2
 Input: "2*3-4*5"

 (2*(3-(4*5))) = -34
 ((2*3)-(4*5)) = -14
 ((2*(3-4))*5) = -10
 (2*((3-4)*5)) = -10
 (((2*3)-4)*5) = 10
 Output: [-34, -14, -10, -10, 10]

 * Created by liqu on 6/30/16.
 */
public class DifferentWaysToAddParentheses_241 {
    public List<Integer> diffWaysToCompute(String input) {
        // create a new arraylist to record the sum result of this input
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // divide the input into two part to calculate sum respectively
            if (c == '+' || c == '-' || c == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> part1res = diffWaysToCompute(part1);
                List<Integer> part2res = diffWaysToCompute(part2);
                // two-two sum up the sum in two parts
                for (int a : part1res) {
                    for (int b : part2res) {
                        int sum = 0;
                        if (c == '+')      sum = a + b;
                        else if (c == '-') sum = a - b;
                        else if (c == '*') sum = a * b;
                        // add the sum into the result list to construct this levels sum list
                        res.add(sum);
                    }
                }
            }
        }

        // if there isn't a operator in input, convert input to integer and add to res list
        if (res.isEmpty()) res.add(Integer.valueOf(input));
        return res;
    }

    // Use a HashMap to memorize results for an input
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToComputeHM(String input) {
        // create a new arraylist to record the sum result of this input
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // divide the input into two part to calculate sum respectively
            if (c == '+' || c == '-' || c == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> part1res = map.getOrDefault(part1, diffWaysToComputeHM(part1));
                List<Integer> part2res = map.getOrDefault(part2, diffWaysToComputeHM(part2));
                // two-two sum up the sum in two parts
                for (int a : part1res) {
                    for (int b : part2res) {
                        int sum = 0;
                        if (c == '+')      sum = a + b;
                        else if (c == '-') sum = a - b;
                        else if (c == '*') sum = a * b;
                        // add the sum into the result list to construct this levels sum list
                        res.add(sum);
                    }
                }
            }
        }

        // if there isn't a operator in input, convert input to integer and add to res list
        if (res.isEmpty()) res.add(Integer.valueOf(input));
        map.put(input, res);
        return res;
    }

}
