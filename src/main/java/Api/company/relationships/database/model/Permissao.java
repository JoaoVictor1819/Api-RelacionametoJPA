package Api.company.relationships.database.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Permissoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permissao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String Permissoes;

    @Column(nullable = false)
    private String permissoesDescricao;


    @JsonProperty(access =  JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "permissao", fetch = FetchType.LAZY)
    private Set<Cargo> cargos = new HashSet<>();
}
