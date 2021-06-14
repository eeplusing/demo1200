package com.eplusing.demo1200.hystrix.stack;

import java.util.Stack;
import java.util.Vector;

public class StackTest<E> extends Vector<E> {

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);

        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

    public E push(E item) {
        addElement(item);
        return item;
    }

    public E pop() {
        int len = size();
        E obj = elementAt(len - 1);
        //removeElementAt(len - 1);
        String[] arr = new String[3];
        int index = 1;
        int lastLen = len - index - 1;
        System.arraycopy(arr, index + 1, arr, index, lastLen);
        return obj;
    }


}
