package com.orangetalents.desafio.restapi.exception;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.orangetalents.desafio.restapi.exception.Problema.Campo;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(EntidadeNaoLocalizadaException.class)
	public ResponseEntity<Object> handleEntidadeNaoEncontrada(NegocioException ex, WebRequest req){
		HttpStatus status = HttpStatus.NOT_FOUND;
		return handleExceptionInternal(ex, getProblema(ex, status), new HttpHeaders(), status, req);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleBadRequest(NegocioException ex, WebRequest req){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return handleExceptionInternal(ex, getProblema(ex, status), new HttpHeaders(), status, req);
	}
	
	protected ResponseEntity<Object> handleArgumentoInvalido(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest req){
		List<Campo> campos = new ArrayList<Problema.Campo>();
		for(ObjectError error:ex.getBindingResult().getAllErrors()) {
			String campo = ((FieldError) error).getField();
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			campos.add(new Problema.Campo(campo, mensagem));
		}
		Problema problema = new Problema();
		problema.setStatus(status.value());
		problema.setTitulo("Um ou mais campos estão inválidos.");
		problema.setDataHora(OffsetDateTime.now());
		problema.setCampos(campos);
		
		return super.handleExceptionInternal(ex, problema, headers, status, req);
	}
	
	private Problema getProblema(NegocioException ex, HttpStatus status) {
		Problema problema = new Problema();
		problema.setStatus(status.value());
		problema.setTitulo(ex.getMessage());
		problema.setDataHora(OffsetDateTime.now());
		return problema;
	}

}
