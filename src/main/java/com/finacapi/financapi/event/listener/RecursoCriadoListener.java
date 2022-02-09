package com.finacapi.financapi.event.listener;

import com.finacapi.financapi.event.RecursoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoEvent> {

    @Override
    public void onApplicationEvent(RecursoEvent recursoEvent) {
        HttpServletResponse response = recursoEvent.getResponse();
        Long codigo = recursoEvent.getCodigo();
        addHeadLocation(response, codigo);
    }

    private void addHeadLocation(HttpServletResponse response, Long codigo){

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(codigo).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}