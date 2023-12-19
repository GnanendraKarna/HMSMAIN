package com.hospital.exceptions.handler;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hospital.exceptions.response.CustomErrorResponse;
import com.hospital.exceptions.response.CustomInvalidResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidException.class)
	public ResponseEntity<CustomInvalidResponse> handleException(InvalidException ex) {
		CustomInvalidResponse response = new CustomInvalidResponse();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMsg(ex.getMessage());
		response.setTimestamp(new Date());
		
		return new ResponseEntity<CustomInvalidResponse>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleException(NotFoundException ex) {
		CustomErrorResponse response = new CustomErrorResponse();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMsg(ex.getMessage());
		response.setTimestamp(new Date());
		
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TrainedInNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handlerTrainedInException(Exception e){
		CustomErrorResponse errorResp=new CustomErrorResponse();
		 errorResp.setStatus(HttpStatus.NOT_FOUND.value());
		 errorResp.setMsg(e.getMessage());
		 errorResp.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
		   return new ResponseEntity<>(errorResp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handlerAppointmentException(Exception e){
		CustomErrorResponse errorResp=new CustomErrorResponse();
		 errorResp.setStatus(HttpStatus.NOT_FOUND.value());
		 errorResp.setMsg(e.getMessage());
		 errorResp.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
		   return new ResponseEntity<>(errorResp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProcedureNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handlerProcedureException(Exception e){
		CustomErrorResponse errorResp=new CustomErrorResponse();
		 errorResp.setStatus(HttpStatus.NOT_FOUND.value());
		 errorResp.setMsg(e.getMessage());
		 errorResp.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
		   return new ResponseEntity<>(errorResp, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AffiliatedWithNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handlerAffiliatedWithException(Exception e){
		CustomErrorResponse errorResp=new CustomErrorResponse();
		 errorResp.setStatus(HttpStatus.NOT_FOUND.value());
		 errorResp.setMsg(e.getMessage());
		 errorResp.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
		   return new ResponseEntity<>(errorResp, HttpStatus.NOT_FOUND);
	}
	
			
	@ExceptionHandler(NurseNotFoundException.class)
	public ResponseEntity<CustomErrorResponse>handleNurseNotFoundException(Exception e){
		CustomErrorResponse errorResp=new CustomErrorResponse();
		 errorResp.setStatus(HttpStatus.NOT_FOUND.value());
		 errorResp.setMsg(e.getMessage());
		 errorResp.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
		   return new ResponseEntity<>(errorResp, HttpStatus.NOT_FOUND);
		}
	@ExceptionHandler(PhysicianNotFoundException.class)
    public ResponseEntity<CustomErrorResponse>handlePhysicianNotFoundException(Exception e){
		CustomErrorResponse errorResp=new CustomErrorResponse();
		 errorResp.setStatus(HttpStatus.NOT_FOUND.value());
		 errorResp.setMsg(e.getMessage());
		 errorResp.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
		   return new ResponseEntity<>(errorResp, HttpStatus.NOT_FOUND);
		}
	@ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<CustomErrorResponse>handlePatientNotFoundException(Exception e){
		CustomErrorResponse errorResp=new CustomErrorResponse();
		 errorResp.setStatus(HttpStatus.NOT_FOUND.value());
		 errorResp.setMsg(e.getMessage());
		 errorResp.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
		   return new ResponseEntity<>(errorResp, HttpStatus.NOT_FOUND);
		}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> validationErrs = new ArrayList<>();
		for (FieldError err : ex.getBindingResult().getFieldErrors())
			validationErrs.add(err.getDefaultMessage());
		CustomErrorResponse errResp = new CustomErrorResponse();
		errResp.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
		errResp.setMsg(ex.getBindingResult().getFieldError().getDefaultMessage());
		errResp.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<Object>(errResp, status);
	}
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<CustomErrorResponse>handleDepartmentNotFoundException(Exception e){
		CustomErrorResponse errorResp=new CustomErrorResponse();
		 errorResp.setStatus(HttpStatus.NOT_FOUND.value());
		 errorResp.setMsg(e.getMessage());
		 errorResp.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
		   return new ResponseEntity<>(errorResp, HttpStatus.NOT_FOUND);
		}

}
