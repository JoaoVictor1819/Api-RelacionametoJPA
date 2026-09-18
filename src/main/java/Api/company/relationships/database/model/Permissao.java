package Api.company.relationships.database.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
