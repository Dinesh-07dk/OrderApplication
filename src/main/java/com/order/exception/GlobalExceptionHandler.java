package com.order.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestControllerAdvice.class)
@Slf4j
public class GlobalExceptionHandler extends Exception {

	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleException(final Exception e){
		log.error(e.getMessage());
		return new ErrorResponse("Exception occurred, please contact support team");
	}

}
