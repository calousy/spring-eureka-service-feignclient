package de.meisl.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleService
{
    private final Logger LOG = LogManager.getLogger(getClass());

    @RequestMapping(value = "/example-service/{text}")
    public String helloText(@PathVariable("text") String text)
    {
        LOG.info("helloText(" + text + ")");

        return "Hello '" + text + "'";
    }

    @RequestMapping(value = "/example-service", method = RequestMethod.GET)
    public String greeting()
    {
        LOG.info("greeting()");
        return "Hello!";
    }
}
