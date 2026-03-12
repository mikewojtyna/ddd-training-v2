package pl.wojtyna.trainings.ddd.claudehello;

public class Calculator {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static Double divide(int firstNumber, int secondNumber) {

        return (double) firstNumber / secondNumber;
    }
}
