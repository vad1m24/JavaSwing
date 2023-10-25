package main.java.by.task3.task3_3;

public class Pair<U, V> {
    U first;
    V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first = " + first +
                ", second = " + second +
                '}';
    }
}
