package com.example.demo;

import com.example.demo.service.ExampleService;
import com.example.demo.service.ExternalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class ExceptionHandlerAppTest {

    @Autowired
    private ExampleService exampleService;

    // Mock any external service that you don't want to actually invoke
    @MockBean
    private ExternalService externalService;

    @Test
    void contextLoads() {
        assertThat(exampleService).isNotNull();
    }

    @Test
    void serviceBehaviorTest() {
        // given
        when(externalService.getDescription()).thenReturn("mocked response");

        // when
        String result = exampleService.getExternalServiceDescription();

        // then
        assertThat(result).isEqualTo("mocked response");
        verify(externalService, times(1)).getDescription();
    }
}
