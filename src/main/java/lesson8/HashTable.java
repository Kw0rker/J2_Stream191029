package main.java.lesson8;

import java.util.LinkedList;
import java.util.Objects;

public class HashTable<T> {
    private LinkedList<T>[] array;
    private static final int constant=13024;
    private int capability;
    @SuppressWarnings("unchecked")
    public HashTable(int capability) {
        this.capability=capability;
        array=new LinkedList[capability];
        for (int i = 0; i < capability; i++) {
            array[i]=new LinkedList<>();
        }
    }
    public void add(T o){
        int hash1=o.hashCode();
        int hash=(constant- Objects.hash(hash1)%constant);
        System.out.println("hash="+hash);
        if (hash>=capability)throw new RuntimeException("Hash more then array size");
        else{
            array[hash].push(o);
        }

    }
    public void remove(T o){
        int hash1=o.hashCode();
        int hash=(constant- Objects.hash(hash1)%constant);
        array[hash].remove(o);
    }
    public boolean contains(T o){
        int hash1=o.hashCode();
        int hash=(constant- Objects.hash(hash1)%constant);
        return array[hash].size()!=0;
    }
}
