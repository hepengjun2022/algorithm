package com.own;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        MyOwnLinkedList list1=new MyOwnLinkedList();
        list1.add("er");
        list1.add("zhangsan");
        list1.add("erha");
        list1.add("wudi");
        list1.add(3,"lisi");
        System.out.println(list1.getList());

//        LinkedList list=new LinkedList();
//        list.add("张三");
//        list.add(5,"df");
//        System.out.println(list);
    }
}
