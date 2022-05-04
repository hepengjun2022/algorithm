package com.own;

import java.util.Arrays;

public class MyOwnArrayList {

    private int INIT_SIZE = 10;
    public int PRESENT_SIZE = 0;
    Object elementData[];
    public int USED_SIZE = 0;

    public MyOwnArrayList() {
        elementData = new Object[INIT_SIZE];
        PRESENT_SIZE = INIT_SIZE;
    }

    public MyOwnArrayList(int size) {
        if (size < 0) {
            throw new RuntimeException("请保证传入的数值大于0");
        }
        if (size < INIT_SIZE) {
            elementData = new Object[INIT_SIZE];
            PRESENT_SIZE = INIT_SIZE;
        }
        elementData = new Object[size];
        PRESENT_SIZE = size;
    }

    public void add(int num) {
        if (USED_SIZE >= PRESENT_SIZE) {
            resize();
        }
        elementData[USED_SIZE++] = num;
    }

    public void add(int index, int num) {
        rangeCheckForAdd(index);
        ensureCapacityInternal(USED_SIZE + 1);
        System.arraycopy(elementData, index, elementData, index + 1,
                USED_SIZE - index);
        elementData[index]=num;
        USED_SIZE++;
    }

    public void remove(int index) {
        if (index > PRESENT_SIZE - 1) {
            throw new RuntimeException("数组越界");
        }
        if (index > USED_SIZE - 1) {
            throw new RuntimeException("Index:" + index + ", Size: " + USED_SIZE);
        }
        int numMoved = USED_SIZE - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        elementData[--USED_SIZE] = null;
    }

    public int getSize() {
        return USED_SIZE;
    }

    public boolean isEmpty() {
        if (USED_SIZE == 0) {
            return false;
        }
        return true;
    }

    private void resize() {
        PRESENT_SIZE = PRESENT_SIZE + (PRESENT_SIZE >> 1);
        elementData = Arrays.copyOf(elementData, PRESENT_SIZE);
    }

    public String getList() {
        String pre = "[";
        String tail = "]";
        String result = "";
        for (int i = 0; i < USED_SIZE; i++) {
            result = result + elementData[i] + ",";
        }
        String substring = result.substring(0, result.length() - 1);
        result = pre + substring + tail;
        return result;
    }

    private void ensureCapacityInternal(int size) {
        if (size > PRESENT_SIZE) {
            resize();
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > USED_SIZE || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + USED_SIZE;
    }
}
