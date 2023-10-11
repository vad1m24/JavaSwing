package main.java.by.task1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        new ConnectionWindow(new LogHandler("./Task_1_Log"));
    }
}
