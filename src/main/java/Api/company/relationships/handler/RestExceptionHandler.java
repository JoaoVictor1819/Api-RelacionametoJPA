package Api.company.relationships.handler;


import Api.company.relationships.exception.ResourceExcepitonHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceExcepitonHandler.class)
    private ResponseEntity<RestErrorMenssage> ResourceNotFound(ResourceExcepitonHandler ex) {
        RestErrorMenssage restErrorMenssage = new RestErrorMenssage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMenssage);
    }

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<RestErrorMenssage> RuntimeExceptionHandler(RuntimeException ex) {
        RestErrorMenssage restErrorMenssage = new RestErrorMenssage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(restErrorMenssage);
    }

}
