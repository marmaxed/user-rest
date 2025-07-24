package userapi.system;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleUserNotFound(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found: " + ex.getMessage());
    }
}
