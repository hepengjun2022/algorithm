package com.own;

import java.util.Random;

public class ListTest {
    public static void main(String[] args) {
        MyOwnArrayList myOwnArrayList = new MyOwnArrayList();
//        myOwnList.add(1);
//        myOwnList.add(8);
//        myOwnList.add(4);
        for (int i = 0; i < 15; i++) {
            myOwnArrayList.add(new Random().nextInt(10));
        }
//        System.out.println(myOwnList.PRESENT_SIZE);
//        System.out.println(myOwnList.USED_SIZE);
//        System.out.println(myOwnList.getList());
//        myOwnList.remove(2);
//        System.out.println(myOwnList.getSize());
        System.out.println(myOwnArrayList.PRESENT_SIZE);
        myOwnArrayList.add(0, 20);
        System.out.println(myOwnArrayList.PRESENT_SIZE);
        System.out.println(myOwnArrayList.getList());


//        List list=new ArrayList();
//        list.add(3);
//        list.add(3);
//        list.add(3,8);
//        list.remove(0);
//        System.out.println(list);
    }
}
