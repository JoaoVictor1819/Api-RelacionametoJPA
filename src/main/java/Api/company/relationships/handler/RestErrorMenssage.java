package Api.company.relationships.handler;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestErrorMenssage {

    private HttpStatus status;
    private String message;
}
