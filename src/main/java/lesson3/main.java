package main.java.lesson3;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        String s="Process finished with exit code 0";
        reverseString(s);
    }
    public static String reverseString(String s){
        StringBuilder builder =new StringBuilder();
        char[]chars=s.toCharArray();
        Deque<Character> deque=new Deque<Character>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            deque.push_back(chars[i]);
        }
        while (deque.has_next_to_pop()){
            builder.append(deque.pop_front());
        }
        System.out.println(builder.toString());
        return builder.toString();
    }
}
