package ru.gb.jtwo.lone.online.lesson3;

import java.util.ArrayList;

public class Main {
    static PhoneBook<Person> phoneBook=new PhoneBook<>();
    static String[]words=new String[5];
    static ArrayList<String>unique=new ArrayList<>();


    public static void main(String[] args) {
        phoneBook.add(new Person("Сидоров","111","ыыы"));
        phoneBook.add(new Person("Андреев","222",""));
        phoneBook.add(new Person("Сидоров","5555",""));
        phoneBook.add(new Person("Абдулаев","222455","зы"));
        phoneBook.add(new Person("Путин","25252",""));
        phoneBook.get("Сидоров");

        words[0]="Мама";
        words[1]="Папа";
        words[2]="Мама";
        words[3]="Папа";
        words[4]="Юрий";


        for (int i = 0; i <words.length ; i++) {
            int counter=1;
            for (int j = 0; j <words.length ; j++){
                if (words[i].equals(words[j])&&i!=j){counter++;words[j]="";}
            }
            if (counter==1)unique.add(words[i]);
            if (!words[i].equals(""))System.out.println(words[i]+":"+counter);

        }

        System.out.println(unique);
    }


}
