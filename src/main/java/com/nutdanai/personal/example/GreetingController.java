package com.nutdanai.personal.example;

import com.nutdanai.personal.example.exceptions.GreetingRequestException;
import com.nutdanai.personal.example.models.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/main")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/error-sample")
    public String errorSample(@RequestParam(value = "id") Integer id) {
        if (id < 0) {
            throw new GreetingRequestException("Id must be more than or equals zero");
        }
        return "Success";
    }

}
