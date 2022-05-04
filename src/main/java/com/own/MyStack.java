package com.own;

public class MyStack {

    private int data[];
    private int PRESENT_CAPACITY;
    private int tail;
    private int INIT_CAPACITY = 10;
    private int usedSize;

    public MyStack() {
        this.PRESENT_CAPACITY = INIT_CAPACITY;
        data = new int[INIT_CAPACITY];
        tail = -1;
        usedSize = 0;
    }

    public MyStack(int capacity) {
        if(capacity<INIT_CAPACITY){
            this.PRESENT_CAPACITY=INIT_CAPACITY;
        }
        this.PRESENT_CAPACITY = capacity;
        data = new int[capacity];
        tail = -1;
        usedSize = 0;
    }

    public void push(int e) {
        if (usedSize >= PRESENT_CAPACITY) {
            resize();
        }
        data[++tail] = e;
        usedSize++;
    }

    private void resize() {
        int oldSize = PRESENT_CAPACITY;
        PRESENT_CAPACITY = PRESENT_CAPACITY << 1;
        int[] temp = new int[PRESENT_CAPACITY];
        for (int i = 0; i < oldSize; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public int pop() {
        if (tail == -1) {
            throw new RuntimeException("栈为空");
        }
        int result = data[tail--];
        usedSize--;
        return result;
    }

    public String lookStack() {
        String pre = "[";
        String tail = "]";
        String result = "";
        if(usedSize==0){
            return "[]";
        }
        for (int i = 0; i < usedSize; i++) {
            result = result + data[i] + ",";
        }
        String substring = result.substring(0, result.length() - 1);
        result = pre + substring + tail;
        return result;
    }
}
