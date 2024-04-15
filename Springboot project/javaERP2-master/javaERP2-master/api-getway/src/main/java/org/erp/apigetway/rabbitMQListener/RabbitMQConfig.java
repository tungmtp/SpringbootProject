package org.erp.apigetway.rabbitMQListener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Configuration
public class RabbitMQConfig {

    @Bean
    public SseEmitter sseEmitter() {
        return new SseEmitter();
    }

    // Các cấu hình khác...
}