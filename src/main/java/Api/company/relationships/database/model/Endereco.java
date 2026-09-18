package Api.company.relationships.database.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Endereco_usuario")
public class Endereco {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String cep;

}
