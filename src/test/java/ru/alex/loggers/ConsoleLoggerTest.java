package ru.alex.loggers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleLoggerTest {
    private static final String MSG = "Hello world";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testLogEvent() {
        ConsoleLogger logger = new ConsoleLogger();
        logger.showEvent(MSG);

        Assert.assertTrue(outContent.toString().contains(MSG));
        Assert.assertEquals(MSG.trim(), outContent.toString().trim());
    }

}