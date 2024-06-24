package org.erp.apigetway.rabbitMQListener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.FluxSink;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class EventListener {
    private FluxSink<Object> eventSink;
    private final List<FluxSink<Object>> sinks = new CopyOnWriteArrayList<>();

    public void registerEventSink(FluxSink<Object> eventSink) {
        sinks.add(eventSink);
    }

    public void removeEventSink(FluxSink<Object> eventSink) {
        sinks.remove(eventSink);
    }

    @RabbitListener(queues = "javaguides")
    public void onMessageEvent(String message) {
        System.out.println("Listening message: " + message);
        for (FluxSink<Object> sink : sinks) {
            sink.next(message);
        }
    }
}
