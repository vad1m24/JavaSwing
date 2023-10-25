package main.java.by.task4.model;

public class Employees {
    int id;
    String name;
    String phoneNumber;
    int stage;

    public Employees(int id, String name, String phoneNumber, int stage) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.stage = stage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getStage() {
        return stage;
    }

    @Override
    public String toString() {
        return "Employee: " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", phoneNumber = '" + phoneNumber + '\'' +
                ", stage = " + stage
                ;
    }
}
