package org.erp.apigetway.rabbitMQListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@RestController
@CrossOrigin
@RequestMapping("/rabbitMQ")
public class SseController {
    @Autowired
    private EventListener eventListener;

    @GetMapping("/events")
       public Flux<ServerSentEvent<String>> streamEvents() {
        return Flux.create(emitter -> {
            eventListener.registerEventSink((emitter));
        }, FluxSink.OverflowStrategy.LATEST).map(e -> ServerSentEvent.<String>builder((String) e).build());
    }
}
