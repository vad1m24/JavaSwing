package main.java.by.task3.task3_2;

public class ArrayComparison {

    public <U, V> boolean compareArrays(U[] a, V[] b) {
        if (!a.getClass().equals(b.getClass())) {
            return false;
        }
        return a.length == b.length;
    }

    public <U, V> boolean compareArraysLength(U[] a, V[] b) {
        return a.length == b.length;
    }

    public <U, V> boolean compareArraysTypes(U[] a, V[] b) {
        return a.getClass().equals(b.getClass());
    }

}
