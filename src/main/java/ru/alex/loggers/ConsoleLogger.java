package ru.alex.loggers;

public class ConsoleLogger implements Logger {

    @Override
    public void showEvent(String event) {
        System.out.println(event);
    }
}

