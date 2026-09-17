package Api.company.relationships.dto.ErrorDto;

import java.util.Map;

public record ErrorDto(Map<String, String> errors) {
}
