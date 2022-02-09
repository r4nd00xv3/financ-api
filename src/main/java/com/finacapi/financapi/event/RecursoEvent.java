package com.finacapi.financapi.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;
import java.time.Clock;

public class RecursoEvent extends ApplicationEvent {

    private HttpServletResponse response;
    private Long codigo;

    public RecursoEvent(Object source, HttpServletResponse response, Long codigo) {
        super(source);
        this.response = response;
                this.codigo = codigo;

    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Long getCodigo() {
        return codigo;
    }
}
