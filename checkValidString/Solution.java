package checkValidString;

import java.util.Stack;

class Solution {

    public boolean checkValidString(String s) {

        int n = s.length();
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i=0;i<n;i++) {

            if (s.charAt(i) == '(') {

                leftStack.push(i);//存的是下标
            } else if (s.charAt(i) == '*') {

                starStack.push(i);
            } else {

                if (!leftStack.isEmpty()) {

                    leftStack.pop();
                } else {

                    if (!starStack.isEmpty()) {
                    
                        starStack.pop();
                    } else {

                        return false;
                    }
                }
            }
        }
        if (starStack.size() < leftStack.size()) return false;
        else {

            while (!starStack.isEmpty() && !leftStack.isEmpty()) {

                if (starStack.peek() < leftStack.peek()) {

                    return false;
                }
                starStack.pop();
                leftStack.pop();
            }
            return true;
        }
    }
}