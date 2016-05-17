package com.lia.StackAndQueue;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"

 Corner Cases:
 Did you consider the case where path = "/../"?
 In this case, you should return "/".
 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 In this case, you should ignore redundant slashes and return "/home/foo".

 * Created by liqu on 5/16/16.
 */
public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        for(String s : path.split("/+")) {
            if (s.equals("..")) {
                if(!stack.empty())stack.pop();
            } else if(!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }

        StringBuilder sb = new StringBuilder("/");
        for(String s : stack) {
            sb.append(s);
            sb.append("/");
        }
        if(!stack.empty()) sb.setLength(sb.length()-1);

        return sb.toString();
    }
}
