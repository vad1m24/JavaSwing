package main.java.by.task3.task3_1;

public class Main {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        UserInterface uf = new UserInterface();

        System.out.println("Input first number: ");
        double num1 = uf.InputNumbers();
        System.out.println("Input second number: ");
        double num2 = uf.InputNumbers();

        System.out.println("Sum = " + calc.sum(num1, num2));
        System.out.println("Multiplication = " + calc.multiply(num1, num2));
        System.out.println("Division = " + calc.divide(num1, num2));
        System.out.println("Subtraction = " + calc.subtract(num1, num2));

    }
}
