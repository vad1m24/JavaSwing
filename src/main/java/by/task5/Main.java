package main.java.by.task5;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {

        Thread philosopher1 = new Thread(() -> {
            AtomicBoolean switcher = new AtomicBoolean(true);
            AtomicInteger counter = new AtomicInteger(0);
            System.out.println("Философ 1 размышляет о бытии.");
            while (counter.get() < 3) {
                System.out.println("Философ 1 решил подкрепиться " + (counter.get() + 1) + " раз.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.set(counter.get() + 1);
                System.out.println("Философ 1 размышляет о бытии.");
                switcher.set(!switcher.get());
            }
        });

        Thread philosopher2 = new Thread(() -> {
            AtomicBoolean switcher = new AtomicBoolean(true);
            AtomicInteger counter = new AtomicInteger(0);
            System.out.println("Философ 2 размышляет о бытии.");
            while (counter.get() < 3) {
                System.out.println("Философ 2 решил подкрепиться " + (counter.get() + 1) + " раз.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.set(counter.get() + 1);
                System.out.println("Философ 2 размышляет о бытии.");
                switcher.set(!switcher.get());
            }
        });

        Thread philosopher3 = new Thread(() -> {
            AtomicBoolean switcher = new AtomicBoolean(true);
            AtomicInteger counter = new AtomicInteger(0);
            System.out.println("Философ 3 размышляет о бытии.");
            while (counter.get() < 3) {
                System.out.println("Философ 3 решил подкрепиться " + (counter.get() + 1) + " раз.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.set(counter.get() + 1);
                System.out.println("Философ 3 размышляет о бытии.");
                switcher.set(!switcher.get());
            }
        });

        Thread philosopher4 = new Thread(() -> {
            AtomicBoolean switcher = new AtomicBoolean(true);
            AtomicInteger counter = new AtomicInteger(0);
            System.out.println("Философ 4 размышляет о бытии.");
            while (counter.get() < 3) {
                System.out.println("Философ 4 решил подкрепиться " + (counter.get() + 1) + " раз.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.set(counter.get() + 1);
                System.out.println("Философ 4 размышляет о бытии.");
                switcher.set(!switcher.get());
            }
        });

        Thread philosopher5 = new Thread(() -> {
            AtomicBoolean switcher = new AtomicBoolean(true);
            AtomicInteger counter = new AtomicInteger(0);
            System.out.println("Философ 5 размышляет о бытии.");
            while (counter.get() < 3) {
                System.out.println("Философ 5 решил подкрепиться " + (counter.get() + 1) + " раз.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.set(counter.get() + 1);
                System.out.println("Философ 5 размышляет о бытии.");
                switcher.set(!switcher.get());
            }
        });

        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();
    }
}
