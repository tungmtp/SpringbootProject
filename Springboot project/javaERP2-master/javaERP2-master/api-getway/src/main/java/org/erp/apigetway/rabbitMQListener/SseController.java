package org.erp.apigetway.rabbitMQListener;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@RestController
@CrossOrigin
@RequestMapping("rabbitMQ")
public class SseController {


        private final EventListener eventListener;

    public SseController(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    @GetMapping("/events")
       public Flux<ServerSentEvent<String>> streamEvents() {
        return Flux.create(emitter -> {
            eventListener.registerEventSink((emitter));

        }, FluxSink.OverflowStrategy.LATEST).map(e -> ServerSentEvent.<String>builder((String) e).build());
    }
}
