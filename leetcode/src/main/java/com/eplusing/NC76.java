package com.eplusing;

import java.util.Stack;

public class NC76 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else if (!stack1.isEmpty()) {
            do{
                stack2.push(stack1.pop());
            }while(!stack1.isEmpty());

            return stack2.pop();
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        NC76 ins = new NC76();

        ins.push(1);
        ins.push(2);
        ins.push(3);
        System.out.println(ins.pop());
        System.out.println(ins.pop());
        ins.push(4);
        System.out.println(ins.pop());
        ins.push(5);
        System.out.println(ins.pop());
        System.out.println(ins.pop());



    }
}
