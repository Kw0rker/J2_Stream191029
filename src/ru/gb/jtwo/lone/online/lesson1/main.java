package ru.gb.jtwo.lone.online.lesson1;

import javafx.util.Pair;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class main {
    public static void main(String[] args) {

    }
    public HashSet<Triplet<Integer,Integer,Integer>> findTriples(int [] arr){
        HashSet<Triplet<Integer,Integer,Integer>> result=new HashSet<>();
        for (int i = 0; i < arr.length;) {
            Triplet<Integer,Integer,Integer> triplet;
            if (i+2==arr.length)return result;
            if (arr[i]+arr[i+1]+arr[i+2]==0) {triplet=new Triplet<>(i,i+1,i+2);result.add(triplet);}
            i=(arr[i+3]!=arr[i])?i+2:i+1;
        }
        System.out.println("Сложность = (n -a)");
        return result;
    }
    public Pair<Integer,Integer> findBiggestPair(int [] arr){
        Three<Integer> three=new Three<>(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            three.insert(new Three<Integer>(arr[i]));

        }
        LinkedList<Integer> result=new LinkedList<>();
        result=three.sort(result);
        System.out.println("сложность nlog(n");
        return new Pair<>(result.get(arr.length-2),result.get(arr.length-1));
    }
}
class Triplet<T1,T2,T3>{
    T1 f;
    T2 s;
    T3 t;
    Triplet(T1 f,T2 s,T3 t){
        this.f=f;
        this.s=s;
        this.t=t;
    }

    public T1 getF() {
        return f;
    }

    public T2 getS() {
        return s;
    }

    public T3 getT() {
        return t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triplet<?, ?, ?> triplet = (Triplet<?, ?, ?>) o;
        return Objects.equals(f, triplet.f) &&
                Objects.equals(s, triplet.s) &&
                Objects.equals(t, triplet.t);
    }

    @Override
    public int hashCode() {
        return Objects.hash(f, s, t);
    }
}
class Three<T>{
    T t;
    Three(T t){
        this.key=t.hashCode();
        this.t=t;
    }
    int key;
    Three right;
    Three left;
    public void insert(Three three){
        if (three.key<this.key){
            if (left!=null)left.insert(three);
            else left=three;
        }
        else{
            if (right!=null)right.insert(three);
            else right=three;
        }
    }
    public LinkedList<T> sort(LinkedList<T> result){
        if (this.left!=null)this.left.sort(result);
        result.add(t);
        if (this.right!=null)this.right.sort(result);
        return result;

    }
}
