package listAndTree.validateStackSequences;

import java.util.Stack;

public class Solution {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }

        int len = popped.length;

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num: pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return i == len;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3 ,4, 5};
        int[] num2 = new int[]{4,5,1,2,3};
        System.out.println(validateStackSequences(num1, num2));
    }
}
