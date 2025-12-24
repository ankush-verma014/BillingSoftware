package com.ankush.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling 
{
//	@ExceptionHandler(CategoryNotFound.class)
//  public ResponseEntity<String> handleCategoryNotFound(CategoryNotFound ex)
//  {
//		// return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//		
//		
//  }
	
	   @ExceptionHandler(CategoryNotFound.class)
	    public ResponseEntity<Map<String, Object>> handleCategoryNotFound(CategoryNotFound ex) {
	        Map<String, Object> body = new HashMap<>();
	        body.put("timestamp", LocalDateTime.now().toString());
	        body.put("status", HttpStatus.NOT_FOUND.value());
	        body.put("error", "Not Found");
	        body.put("message", ex.getMessage());
	        // optional: requested path nahin pata to hata bhi sakte ho
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        
     }
	   
}
