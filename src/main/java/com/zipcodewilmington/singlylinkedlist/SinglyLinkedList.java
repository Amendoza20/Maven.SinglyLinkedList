package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList <T extends Comparable> {
    class Node{
        T value;
        Node next;

        public Node(T value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    Integer count;
    Node start;

    public SinglyLinkedList() {
        count = 0;
    }

    public void add(T value){
        if(start == null) {
            start = new Node(value, null);
        }
        else{
            Node node = start;
            while (node.next != null){
                node = node.next;
            }
        }
        count++;
    }

    public void remove (Integer index){
        Node node = start;
        Node previous = start;

        if(index < count && index >= 0){
            for(int i = 0; i <= index; i++){
                if(i == index && i == 0){
                    start = node.next;
                }else if( i == index){
                    previous.next = node.next;
                }else {
                    previous = node;
                    node = node.next;
                }
            }
            count--;
        }
    }
    public boolean contains (T value){
        Node node = start;

        for(int i = 0; i < count; i++){
            if(node.value.equals(value)){
                return true;

            }
            node = node.next;
        }
        return false;
    }
    public Integer find(T value){
        Node node = start;
        Integer counter = 0;

        for(int i = 0; i < count; i++){
            if(contains(value)){
                counter++;
            }
        }
        return counter;
    }
    public T get(Integer index){
        Node node = start;
        if(index < count){
            for(int i = 0; i <= index; i++){
                if(i == index){
                    return node.value;
                }
                node = node.next;
            }
        }
        return null;
    }
    public void sort(){
        Boolean sorted = false;

        while(!sorted){
            Node node = start;
            Node previous = null;
            sorted = true;

            for(int i = 0; i < count-1; i++){
                Node next = node.next;
                int compareIndex = node.value.compareTo(next.value);
                if(previous !=null){
                    previous.next = next;
                }
                if(i ==0){
                    start = next;
                }
                node = next;
                sorted = false;
            }
            previous = node;
            node = node.next;
        }
    }
}
