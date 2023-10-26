package main.java.by.task4.service;

import main.java.by.task4.model.Employees;
import main.java.by.task4.repository.Repository;
import main.java.by.task4.units.Counter;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Service {
    private final Scanner scanner = new Scanner(System.in);
    private final Repository repository = new Repository();
    private final Counter counter = new Counter();

    public void showAllEmployees() {
        repository.showEmployeesRepository();
    }

    public void getEmployeeByName() {
        scanner.nextLine();
        System.out.println("Введите имя сотрудника.");
        String employeeName = scanner.nextLine();
        String employees = repository.getByName(employeeName).stream().map(Employees::toString)
                .collect(Collectors.joining("\n"));
        System.out.println(employees + "\n");
    }

    public void getEmployeeById() {
        scanner.nextLine();
        System.out.println("Введите табельный номер сотрудника.");
        int employeeID = scanner.nextInt();
        System.out.println(repository.getById(employeeID) + "\n");
    }

    public void getEmployeeByStage() {
        scanner.nextLine();
        System.out.println("Введите стаж сотрудника.");
        int employeeStage = scanner.nextInt();
        String employees = repository.getByStage(employeeStage).stream().map(Employees::toString)
                .collect(Collectors.joining("\n"));
        System.out.println(employees + "\n");
    }

    public void showPhoneNumber() {
        scanner.nextLine();
        System.out.println("Введите имя вашего сотрудника.");
        String employeeName = scanner.nextLine();
        System.out.println(getEmployeesPhoneByName(employeeName) + "\n");
    }

    public String getEmployeesPhoneByName(String name) {
        List<Employees> byName = repository.getByName(name);
        return byName.stream().map(Employees::getPhoneNumber).collect(Collectors.joining("\n"));

    }

    public void prepareForCreate() {
        scanner.nextLine();
        System.out.println("Введите имя вашего сотрудника.");
        String employeeName = scanner.nextLine();
        System.out.println("Введите телефонный номер вашего сотрудника.");
        String employeePhoneNumber = scanner.nextLine();
        System.out.println("Введите стаж работы вашего сотрудника.");
        int employeeStage = scanner.nextInt();
        create(counter.getCounter(), employeeName, employeePhoneNumber, employeeStage);
    }

    private void create(int id, String name, String phoneNumber, int stage) {
        Employees employee = new Employees(id, name, phoneNumber, stage);
        repository.addEmployeesRepository(employee);
        counter.add();
    }
}
