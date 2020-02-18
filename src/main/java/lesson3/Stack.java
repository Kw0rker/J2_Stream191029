package main.java.lesson3;

import org.omg.CORBA.Object;

public class Stack<T> {
    int last=0;
    T[] elements;

    public Stack(T[] elements) {
        this.elements = elements;
    }

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        elements = (T[]) new Object[size];
    }

    public void push(T element){
        elements[last++]=element;
    }
    public T pull(){
        return elements[--last];
    }
    public boolean isEmpty(){
        return last==0;
    }
    public boolean isFull(){
        return last>=elements.length;
    }
}
