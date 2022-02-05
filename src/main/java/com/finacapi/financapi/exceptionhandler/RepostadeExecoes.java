package com.finacapi.financapi.exceptionhandler;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class RepostadeExecoes  extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mesagemUsuario = messageSource.getMessage("menssagem.invalida", null, LocaleContextHolder.getLocale());
        String mesagemDesenvolvedor = ex.getCause().toString();
        return handleExceptionInternal(ex,new Erro(mesagemUsuario, mesagemDesenvolvedor),headers, HttpStatus.BAD_REQUEST,request) ;
    }

    public static class Erro {


        @Getter
        private String mensagemUsuario;

        @Getter
        private String mensagemDesenvolvedor;


        public Erro(String mensagemUsuario, String mensagemDesenvolvedor) {
            this.mensagemUsuario = mensagemUsuario;
            this.mensagemDesenvolvedor = mensagemDesenvolvedor;
        }
    }

    }

