package com.example.demo.service;

import com.example.demo.exception.ApiException;
import com.example.demo.exception.impl.OrderException;
import com.example.demo.exception.impl.PaymentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @Autowired
    private ExternalService externalService;

    public Object getOrder(String id) {
        if (id.equals("-1")) {
            throw new ApiException(OrderException.ORDER_NOT_FOUND);
        }
        return "Product" + id;
    }

    public Object getPayment(String id) {
        if (id.equals("-1")) {
            throw new ApiException(PaymentException.PAYMENT_NOT_FOUND);
        }
        return "Payment" + id;
    }

    public String getExternalServiceDescription() {
        return externalService.getDescription();
    }
}
