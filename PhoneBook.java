package ru.gb.jtwo.lone.online.lesson3;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;


public class PhoneBook<P> extends ArrayList {

    @NotNull public void get(String name) {
        for (Object o:this){
            o.equals(name);
        }
    }
}
