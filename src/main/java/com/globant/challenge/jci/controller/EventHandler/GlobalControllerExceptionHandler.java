package com.globant.challenge.jci.controller.EventHandler;

import com.globant.challenge.jci.application.exception.NotAvailableReservationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

  public static final String NOT_AVAILABLE_FOR_RESERVATION = "Room not available for reservation";

  @ExceptionHandler(NotAvailableReservationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<String> handleConnversion(RuntimeException ex) {
    return new ResponseEntity<>(NOT_AVAILABLE_FOR_RESERVATION, HttpStatus.BAD_REQUEST);
  }

}
