package ru.alex;

import org.junit.jupiter.api.Test;
import ru.alex.loggers.ConsoleLogger;
import ru.alex.loggers.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestApp {

    private static final String MSG = "Hello world";

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        DummyLogger dummyLogger = new DummyLogger();
        App app = new App(dummyLogger);

        invokeLogger(app, MSG);
        assertTrue(dummyLogger.getEvent().contains(MSG));

    }

    ;

    private void invokeLogger(App app, String message) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {
        Method method = app.getClass().getDeclaredMethod("logEvent", String.class);
        method.setAccessible(true);
        method.invoke(app, message);
    }

    private class DummyLogger extends ConsoleLogger implements Logger {

        private String msg;

        @Override
        public void showEvent(String msg) {
            this.msg = msg;
        }

        public String getEvent() {
            return msg;
        }

    }


}
