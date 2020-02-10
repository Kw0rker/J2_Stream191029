package lesson2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArray<T>  extends ArraySort{
    private T [] array;
    private int size;
    private int inArray;
    public DynamicArray(T[]array) {
        this.array=array;
        this.size=array.length;
        this.inArray=size;
    }
    public DynamicArray(){
        this.array= (T[]) new Object[0];
        this.size=0;
        this.inArray=0;
    }
    public void add(T object){
        if (inArray+1>=size){
            sizeArray(1);
            array[inArray++]=object;
        }
        else array[inArray++]=object;
    }
    @Deprecated
    public void add(T object,int delta){
        if (inArray+delta>=size){
            sizeArray(delta);
        }
        else array[inArray++]=object;
    }
    void sizeArray(int deltaSize){
        T [] newArray= (T[]) new Object[size+deltaSize];
        if (deltaSize>0) {
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
        }
        else {
            for (int i = 0; i < size+deltaSize; i++) {
                newArray[i] = array[i];
            }
        }
        size=newArray.length;
        this.array=newArray;
    }
    public void remove(T object){
        boolean replace=false;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)&&!replace){
                replace=true;
                continue;
            }
            if (replace){
                array[i-1]=array[i];
            }
        }
        if (replace){
            inArray-=1;
            sizeArray(-1);
            remove(object);
        }
    }
    public void remove(int index){
        for (int i = index; i < size; i++) {
            array[i-1]=array[i];
        }
        inArray-=1;
        sizeArray(-1);
    }
    public T get(int index){
        if (index>=size||index<0)throw  new RuntimeException("No element with such index");
        return array[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
