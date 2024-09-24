package com.LinkedLists;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item){
        var node = new Node(item);

        if(isEmpty())
            first = last = node;
        else{
            last.next = node;
            last = node;
        }

        size++;
    }

    public void addFirst(int item){
        var node = new Node(item);

        if(isEmpty())
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexOf(int item){
        var current = first;
        int index = 0;

        while(current != null){
            if(current.value == item)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    public void removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();

        if(first == last)
            first = last = null;
        else{
            var previous = first;
            first = first.next;
            previous.next = null;
        }
        size--;
    }

    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();

        if(first == last)
            first = last = null;
        else{
            var previous = getPrevious(last);
            last = previous;
            previous.next = null;
        }
        size--;
    }

    public int getSize(){
        return size;
    }

    private Node getPrevious(Node node){
        var current = first;
        while(current != null){
            if(current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public int[] toArray(){
        var array = new int[size];
        var current = first;
        var index = 0;

        while(current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }


    private boolean isEmpty(){
        return first == null;
    }
}
