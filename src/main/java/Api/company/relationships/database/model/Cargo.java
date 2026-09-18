package Api.company.relationships.database.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Cargos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nomeCargo;

    @Column(nullable = false)
    private String descricaoCargo;

    @Column(nullable = false)
    private BigDecimal salarioCargo;


}
