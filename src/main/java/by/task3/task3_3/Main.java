package main.java.by.task3.task3_3;

import main.java.by.task3.task3_2.ArrayComparison;

public class Main {

    public static void main(String[] args) {

        ArrayComparison arrComp = new ArrayComparison();
        String[] strArr1 = {"Hello", ", ", "world", "!"};
        Integer[] intArr2 = {2, 3, 5, 8};

        Pair<Integer, Boolean> pair = new Pair<>(10, arrComp.compareArrays(strArr1, intArr2));
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        System.out.println(pair);

    }
}
