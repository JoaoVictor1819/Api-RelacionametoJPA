package Api.company.relationships.exception.handler;


import Api.company.relationships.exception.ResourceExceptonHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceExceptonHandler.class)
    private ResponseEntity<RestErrorMessage> ResourceNotFound(ResourceExceptonHandler ex) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(new Date(),HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMessage);
    }

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<RestErrorMessage> RuntimeExceptionHandler(RuntimeException ex) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(new Date(),HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(restErrorMessage);
    }


}
