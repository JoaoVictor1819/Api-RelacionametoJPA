package Api.company.relationships.exception.ErrorDto;

import java.util.Map;

public record ErrorDto(Map<String, String> errors) {
}
