package org.erp.apigetway.rabbitMQListener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.FluxSink;

@Component
public class EventListener {

    private FluxSink<Object> eventSink;


    public void registerEventSink(FluxSink<Object> eventSink) {
        this.eventSink = eventSink;
    }

    @RabbitListener(queues = "javaguides")
    public void onMessageEvent(String message) {
            System.out.println("Listening message: " + message);
    }
}