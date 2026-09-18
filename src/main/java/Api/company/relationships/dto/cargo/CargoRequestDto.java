package Api.company.relationships.dto.cargo;

import java.math.BigDecimal;

public record CargoRequestDto(

        String nomeCargo,

        String descricaoCargo,

        BigDecimal salarioCargo) {
}
