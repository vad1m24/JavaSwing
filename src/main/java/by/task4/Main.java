package main.java.by.task4;

import main.java.by.task4.service.Service;

import java.util.Scanner;

public class Main {

    public static Service service = new Service();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать!");
        while (true) {
            System.out.println("""
                    Вот список комманд для проведения операций:
                    1   ->   добавить нового сотрудника
                    2   ->   найти сотрудника по имени
                    3   ->   найти сотрудника по стажу
                    4   ->   найти сотрудника по табельному номеру
                    5   ->   отобразить номер телефона сотрудника по имени
                    6   ->   отобразить список всех сотрудников
                    7   ->   выйти из приложения
                    """);
            System.out.println("Введите вашу комманду: ");

            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                service.prepareForCreate();
            } else if (userChoice == 2) {
                service.getEmployeeByName();
            } else if (userChoice == 3) {
                service.getEmployeeByStage();
            } else if (userChoice == 4) {
                service.getEmployeeById();
            } else if (userChoice == 5) {
                service.showPhoneNumber();
            } else if (userChoice == 6) {
                service.showAllEmployees();
            } else if (userChoice == 7) {
                System.out.println("До свидания!");
                break;
            }
        }
    }
}
