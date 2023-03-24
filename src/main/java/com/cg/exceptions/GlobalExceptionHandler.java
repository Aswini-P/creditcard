package com.cg.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.responses.ErrorInfo;
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handlingException(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new LinkedHashMap<>();
		List<FieldError> list = ex.getFieldErrors();
		for (FieldError temp : list) {
			String fieldName = temp.getField();
			String errorMsg = temp.getDefaultMessage();
			errorMap.put(fieldName, errorMsg);
			}
		return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
		}
	@ExceptionHandler(UserAlreadyExistException.class)
		public ResponseEntity<ErrorInfo> handlingException(UserAlreadyExistException ex, HttpServletRequest request) {
			String msg = ex.getMessage();
			ErrorInfo eInfo = new ErrorInfo(LocalDateTime.now(), HttpStatus.BAD_REQUEST.name(),HttpStatus.BAD_REQUEST.value(), msg, request.getRequestURI());
			return new ResponseEntity<>(eInfo, HttpStatus.BAD_REQUEST);
			}
		@ExceptionHandler(WrongPasswordException.class)
		public ResponseEntity<ErrorInfo> handlingException(WrongPasswordException ex,HttpServletRequest request){
			String msg = ex.getMessage();
			ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),msg,request.getRequestURI());
			return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
			}
		@ExceptionHandler(UserIdNotFoundException.class)
		public ResponseEntity<ErrorInfo> handlingException(UserIdNotFoundException ex,HttpServletRequest request){
			String msg = ex.getMessage();
			ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),msg,request.getRequestURI());
			return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
			}
		@ExceptionHandler(NotLoggedInException.class)
		public ResponseEntity<ErrorInfo> handlingException(NotLoggedInException ex,HttpServletRequest request){
			String msg = ex.getMessage();
			ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),msg,request.getRequestURI());
			return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);}
		@ExceptionHandler(CreditCardNotFoundException.class)
		public ResponseEntity<ErrorInfo> handlingException(CreditCardNotFoundException ex,HttpServletRequest request){
			String msg = ex.getMessage();
			ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),msg,request.getRequestURI());
			return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
			}

}
