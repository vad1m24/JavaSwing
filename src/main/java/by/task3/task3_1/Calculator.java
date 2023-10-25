package main.java.by.task3.task3_1;

public class Calculator {

    public <T extends Number> double sum(T num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public <T extends Number> double multiply(T num1, T num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public <T extends Number> double divide(T num1, T num2) {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("Dividing by 0 is not allowed");
        } else {
            return num1.doubleValue() / num2.doubleValue();
        }
    }

    public <T extends Number> double subtract(T num1, T num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}
