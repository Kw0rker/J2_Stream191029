package main.java.lesson3;

public class Deque<T> {
    private T[] elements;
    private int in_que;
    private int push_front;
    private int push_back;
    private int pop_front;
    private int pop_back;

    @SuppressWarnings("unchecked")
    public Deque(int size) {
        elements= (T[]) new Object[size];
        this.in_que =0;
        push_front =0;
        push_back =size-1;
        pop_back=elements.length;
        pop_front=-1;
    }
    public Deque(T [] array){
        elements=array;
        this.in_que =0;
        push_front =0;
        push_back =array.length-1;
        pop_back=elements.length;
        pop_front=-1;
    }
    public void push_back(T e){
        elements[push_back--]=e;
        if (push_back <0){
            push_back =elements.length-1;
        }
    }
    public void push_front(T e){
        elements[push_front++]=e;
        if (push_front >=elements.length){
            push_front =0;
        }
    }
    public T pop_front(){
        if (pop_front>=elements.length-1){
            pop_front=-1;
        }
        in_que++;
        return elements[++pop_front];
    }
    public T pop_back(){
        if (pop_back<=0){
            pop_back=elements.length;
        }
        in_que++;
        return elements[--pop_back];
    }
    public boolean is_empty(){
        return in_que==0;
    }

   public boolean has_next_to_push(){
        return push_front<=elements.length-1;
   }

    public boolean has_next_to_pop(){
        return pop_front<elements.length-1;
    }

    public boolean has_past_to_push(){
        return push_back>=0;
    }

    public boolean has_past_to_pop(){
        return pop_back>0;
    }
}
