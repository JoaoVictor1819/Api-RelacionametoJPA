package Api.company.relationships.database.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Empresa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @JsonProperty(access =  JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "empresa",fetch =  FetchType.LAZY)
    private Set<Cargo> cargos = new HashSet<>();


}
