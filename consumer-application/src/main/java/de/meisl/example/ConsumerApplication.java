package de.meisl.example;

import de.meisl.example.client.ExampleFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@RestController
public class ConsumerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Autowired
    private ExampleFeignClient greetingClient;

    @RequestMapping("/test/{text}")
    public String test(@PathVariable("text") String text)
    {
        return greetingClient.getExample(text);
    }

    @RequestMapping(value = "/greet")
    public String greet()
    {
        return greetingClient.greet();
    }
}
