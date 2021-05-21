package com.addressbook.application.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.addressbook.application.dto.ResponseDTO;

@ControllerAdvice
public class AddressBookServiceExceptionHandler {

		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<ResponseDTO> handleArgumentNotValidExceptionEntity (MethodArgumentNotValidException exception){
			List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
			List<String> errorMessage = errorList.stream().map(objectError -> objectError.getDefaultMessage())
																.collect(Collectors.toList());
			
			ResponseDTO responseDTO = new ResponseDTO("Exception while processing ", errorMessage);
			return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(AddressBookServiceException.class)
		public ResponseEntity<ResponseDTO> handleEmployeePayRollException (AddressBookServiceException exception){
			
			ResponseDTO responseDTO = new ResponseDTO("Exception while processing ", exception.getMessage());
			return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
		}

}
