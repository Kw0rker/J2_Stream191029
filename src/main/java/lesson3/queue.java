package main.java.lesson3;

import sun.misc.Queue;

public class queue<T> {
    private T[]elements;
    private int start;
    private int end;
    private int in_array=0;

    @SuppressWarnings("unchecked")
    public queue(int size) {
        elements= (T[]) new Object[size];
        end=size;
        start=-1;
    }

    public queue(T[] elements) {
        this.elements = elements;
        end=elements.length;
        start=0;

    }
    synchronized   public void push(T element){
        if (start>=elements.length-1){
            start=-1;
        }
        elements[++start]=element;
        in_array++;
    }
    public T pull(){
        if (end<=0){
            end=elements.length;
        }
        T e=elements[--end];
        in_array--;
        elements[end]=null;
        return e;
    }
    public boolean isEmpty(){
        return in_array==0;
    }
    public boolean isFull(){
        return in_array>=elements.length;
    }

}
