package ru.alex;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.alex.loggers.ConsoleLogger;

public class App {

    private ConsoleLogger consoleLogger;

    public App(ConsoleLogger consoleLogger) {
        super();
        this.consoleLogger = consoleLogger;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("App");

        app.logEvent("Hello world");

        ctx.close();
    }

    private void logEvent(String msg) {
        consoleLogger.showEvent(msg);
    }
}
