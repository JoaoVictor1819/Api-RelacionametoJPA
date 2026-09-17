package Api.company.relationships.database.entity;


import Api.company.relationships.dto.UserDto;
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

    private String email;

    private String documento;

    private String password;


    public User(UserDto dto) {

        this.firstname = dto.firstname();
        this.lastname = dto.lastname();
        this.email = dto.email();
        this.documento = dto.documento();
        this.password = dto.password();
    }
}
