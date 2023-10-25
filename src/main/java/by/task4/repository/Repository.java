package main.java.by.task4.repository;

import main.java.by.task4.model.Employees;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private List<Employees> employees = new ArrayList<>();

    public void showEmployeesRepository() {
        employees.forEach(System.out::println);
    }

    public void addEmployeesRepository(Employees employee) {
        employees.add(employee);
    }

    public Employees getByName(String name) {
        return employees.stream().filter(employee -> employee.getName().equals(name)).findAny().orElse(null);
    }

    public Employees getById(int id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);
    }

    public Employees getByStage(int stage) {
        return employees.stream().filter(employee -> employee.getStage() == stage).findAny().orElse(null);
    }

}
