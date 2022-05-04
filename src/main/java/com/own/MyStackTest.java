package com.own;

import java.util.Random;
import java.util.Scanner;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        while (true){
            Scanner scanner=new Scanner(System.in);
            String next = scanner.next();
            if(next.contains("pop")){
                myStack.pop();
                System.out.println(myStack.lookStack());
            }
            if (next.contains("push")){
                String num=next.substring(5);
                int target = Integer.parseInt(num);
                myStack.push(target);
                System.out.println(myStack.lookStack());
            }
        }
    }
}
