package br.com.makersweb.hexagonal.architecture.adapter.in.event.listener;

import br.com.makersweb.hexagonal.architecture.adapter.in.event.ResourceCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author aaristides
 */
@Component
public class ResourceCreatedListener implements ApplicationListener<ResourceCreatedEvent> {


    @Override
    public void onApplicationEvent(ResourceCreatedEvent event) {
        HttpServletResponse response = event.getResponse();
        var id = event.getId();

        addHeaderLocation(response, id);
    }

    private void addHeaderLocation(HttpServletResponse response, UUID id) {
        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(id).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
