package Api.company.relationships.database.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Endereco_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String cep;

    private String cidade;

    private String rua;



    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
