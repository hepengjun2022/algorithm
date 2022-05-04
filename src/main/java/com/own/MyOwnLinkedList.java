package com.own;

public class MyOwnLinkedList<E> {

    transient int size = 0;
    private Node<E> first;
    private Node<E> last;

    class Node<E> {
        E item;
        public Node<E> pre;
        public Node<E> next;

        public boolean hasNext() {
            if (this.next != null) {
                return true;
            }
            return false;
        }
    }

    public MyOwnLinkedList() {
        first = null;
        last = null;
    }

    public void add(E get) {
        if (last == null) {
            Node<E> eNode = new Node<>();
            eNode.item = get;
            eNode.pre = null;
            eNode.next = null;
            first = eNode;
            last = eNode;
            size++;
        } else {
            Node<E> eNode = new Node<>();
            eNode.item = get;
            eNode.pre = last;
            last.next = eNode;
            last = eNode;
            size++;
        }
    }

    public void add(int index, E value) {
        checkPositionIndex(index);
        //找出插入位置
        Node<E> target_node_next = first;
        for (int i = 0; i < index ; i++) {
            target_node_next=target_node_next.next;
        }
        if(first==null){
            add(value);
        }
        if(index==0){
            Node<E> node = new Node<>();
            node.item = value;

            first.pre=node;
            node.pre=null;
            node.next=first;
            first=node;
            return;
        }
        if (target_node_next!=null){
            Node<E> target_node_pre =target_node_next.pre;
            //新建节点
            Node<E> node = new Node<>();
            node.item = value;
            node.next=target_node_next;
            node.pre=target_node_pre;
            target_node_next.pre=node;
            target_node_pre.next=node;
        }else {
            add(value);
        }
    }
    public void remove(E value){
        Node<E> target_node;
        for (int i = 0; i < size ; i++) {
            target_node=first;
            
        }
    }

    public String getList() {
        String pre = "[";
        String tail = "]";
        String result = "";
        if (size == 0) {
            return null;
        }
        Node<E> present_node = first;
        Node<E> next_node;
        while (present_node != null) {
            result = result + present_node.item + ",";
            present_node = present_node.next;
        }
        String substring = result.substring(0, result.length() - 1);
        result = pre + substring + tail;
        return result;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
}

