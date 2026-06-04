package com.app;

public class App {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println("Addition: " + app.add(2, 3));
        System.out.println("Multiplication: " + app.multiply(2, 3));
    }
}
