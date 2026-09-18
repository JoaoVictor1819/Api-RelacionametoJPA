package Api.company.relationships.database.model;


import Api.company.relationships.dto.users.UserRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime created = LocalDateTime.now();

    private String firstname;

    private String lastname;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String documento;

    @Column(unique = true)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Endereco endereco;

    public User(UserRequestDto dto) {

        this.firstname = dto.firstname();
        this.lastname = dto.lastname();
        this.email = dto.email();
        this.documento = dto.documento();
        this.password = dto.password();
    }
}
