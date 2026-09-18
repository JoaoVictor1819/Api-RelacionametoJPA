package Api.company.relationships.exception.handler;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestErrorMessage {

    private Date data;
    private HttpStatus status;
    private String message;
}
