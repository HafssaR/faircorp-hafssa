package com.esme.spring.faircorp.hello;

import org.junit.Rule;
import org.junit.Test;
import org.hamcrest.Matchers;

import org.springframework.boot.test.rule.OutputCapture;

public class ConsoleGreetingServiceTests {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testGreeting() {
        ConsoleGreetingService greetingService = new ConsoleGreetingService(); // (1)
        greetingService.greet("Spring");
        outputCapture.expect(Matchers.startsWith("Hello, Spring!"));
    }
}
