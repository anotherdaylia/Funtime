package com.lia.foobar;

/**
 * Maximum equality
 * ================
 * Beta Rabbit will provide you with an array x, where each element in the array is an integer representing the number
 * of rabbits that want to share a particular car. You can give the command for a rabbit to move from any one car to any other,
 * and you have enough time to give as many commands as you need. In other words, choose two elements of the array,
 * x[i] and x[j] (idistinct fromj) and simultaneously increment x[i] by 1 and decrement x[j] by 1. Your goal is to get
 * as many elements of the array to have equal value as you can.

 For example, if the array was [1,4,1] you could perform the operations as follows:
 Send a rabbit from the 1st car to the 0th: increment x[0], decrement x[1], resulting in [2,3,1]
 Send a rabbit from the 1st car to the 2nd: increment x[2], decrement x[1], resulting in [2,2,2].

 All the elements are of the array are equal now, and you've got a strategy to report back to Beta Rabbit!

 Note that if the array was [1,2], the maximum possible number of equal elements we could get is 1, as the cars could
 never have the same number of rabbits in them.

 Write a function answer(x), which takes the array of integers x and returns the maximum number of equal array
 elements that we can get, by doing the above described command as many times as needed.

 The number of cars in the train (elements in x) will be at least 2, and no more than 100. The number of rabbits
 that want to share a car (each element of x) will be an integer in the range [0, 1000000].

 Languages
 =========
 To provide a Python solution, edit solution.py
 To provide a Java solution, edit solution.java

 Test cases
 ==========
 Inputs: (int list) x = [1, 4, 1]
 Output: (int) 3

 Inputs: (int list) x = [1, 2]
 Output: (int) 1

 * Created by liqu on 6/11/16.
 */
public class maximum_equality {
    public static int answer(int[] x) {
        int n = x.length;
        int sum = 0;
        for (int i : x) sum += i;

        if (sum % n == 0) return n;
        else return n - 1;
    }

    public static void main(String[] args) {
        maximum_equality  me = new maximum_equality();
        int[] x = new int[] {4,7,22,97,1,3,6,288,446,77};
        int answer = answer(x);
        System.out.println("answer: " + answer);

    }
}
