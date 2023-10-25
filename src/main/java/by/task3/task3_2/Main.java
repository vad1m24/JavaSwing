package main.java.by.task3.task3_2;

public class Main {

    public static void main(String[] args) {
        ArrayComparison arrCompare = new ArrayComparison();
        Integer[] intArr1 = {1, 4, 5, 19, 23, 10};
        Integer[] intArr2 = {2, 3, 5, 8};
        String[] strArr1 = {"Hello", ", ", "world", "!"};
        String[] strArr2 = {"Java ", "is ", "awesome", "!"};

        System.out.println("Comparison integers arrays");
        System.out.println(arrCompare.compareArrays(intArr1, intArr2));
        System.out.println(arrCompare.compareArraysLength(intArr1, intArr2));
        System.out.println(arrCompare.compareArraysTypes(intArr1, intArr2));
        System.out.println("---------------------------------------------");
        System.out.println("Comparison string arrays");
        System.out.println(arrCompare.compareArrays(strArr1, strArr2));
        System.out.println(arrCompare.compareArraysLength(strArr1, strArr2));
        System.out.println(arrCompare.compareArraysTypes(strArr1, strArr2));
        System.out.println("---------------------------------------------");
        System.out.println("Comparison different types arrays");
        System.out.println(arrCompare.compareArrays(intArr2, strArr2));
        System.out.println(arrCompare.compareArraysLength(intArr2, strArr2));
        System.out.println(arrCompare.compareArraysTypes(intArr2, strArr2));
    }
}
