package de.meisl.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("example-service")
public interface ExampleFeignClient
{
    @RequestMapping(value = "/example-service/{text}", method = RequestMethod.GET)
    String getExample(@PathVariable("text") String text);

    @RequestMapping(value = "/example-service", method = RequestMethod.GET)
    String greet();

}
