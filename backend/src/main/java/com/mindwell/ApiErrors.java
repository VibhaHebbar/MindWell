package com.mindwell;
import org.springframework.web.bind.annotation.*;import org.springframework.http.*;import org.springframework.web.bind.MethodArgumentNotValidException;import java.util.Map;
@RestControllerAdvice public class ApiErrors {
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<?> invalid(MethodArgumentNotValidException e){return ResponseEntity.badRequest().body(Map.of("message","Please check the information you entered."));}
}
