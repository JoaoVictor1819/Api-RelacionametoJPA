package Api.company.relationships.dto.cargo;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public record CargoDto(

        String nomeCargo,

        String descricaoCargo,

        BigDecimal salarioCargo) {
}
