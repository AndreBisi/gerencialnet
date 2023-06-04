package br.com.gerencialnet.infra.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request){
		
		String errorDescription = e.getMessage();
		if(errorDescription == null) {
			errorDescription = e.toString();
		}
		
		ErrorMessage errorMessage = new ErrorMessage(errorDescription);
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
