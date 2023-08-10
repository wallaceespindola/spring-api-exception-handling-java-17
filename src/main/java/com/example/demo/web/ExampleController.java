package com.example.demo.web;

import com.example.demo.service.ExampleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String apiBaseEndpoint() {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "    <title>API Endpoint</title>" +
                "</head>" +
                "<body>" +
                "    <h1>Welcome to the API</h1>" +
                "    <p>This is a user-friendly response for the /api endpoint.</p>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("/order")
    public Object getOrder() {
        return exampleService.getOrder("-1");
    }

    @GetMapping("/orders/{id}")
    public Object getOrders(@PathVariable("id") String id) {
        return exampleService.getOrder(StringUtils.isNotBlank(id) ? id : "-1");
    }

    @GetMapping("/payment")
    public Object getPayment() {
        return exampleService.getPayment("-1");
    }

    @GetMapping("/payments/{id}")
    public Object getPayments(@PathVariable("id") String id) {
        return exampleService.getPayment(StringUtils.isNotBlank(id) ? id : "-1");
    }

}
