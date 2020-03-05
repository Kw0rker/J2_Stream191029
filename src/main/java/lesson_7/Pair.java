package main.java.lesson_7;

import java.util.Objects;

public class Pair<T,T1> {
    private T value;
    private T1 value2;

    public Pair(T value, T1 value2) {
        this.value = value;
        this.value2 = value2;
    }

    public Pair(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return value.equals(pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value,value2);
    }

    @Override
    public String toString() {
        return value +"->"+value2;
    }

    public T getValue() {
        return value;
    }

    public T1 getValue2() {
        return value2;
    }
}
