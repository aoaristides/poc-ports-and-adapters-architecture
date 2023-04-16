package br.com.makersweb.hexagonal.architecture.adapter.in.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author aaristides
 */
public class ResourceCreatedEvent extends ApplicationEvent {

    private transient HttpServletResponse response;
    private UUID id;

    public ResourceCreatedEvent(Object source, HttpServletResponse response, UUID id) {
        super(source);
        this.response = response;
        this.id = id;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public UUID getId() {
        return id;
    }
}
