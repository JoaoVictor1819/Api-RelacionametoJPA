package Api.company.relationships.dto.users;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDto(

        @NotBlank(message = "First name is mandatory")
        String firstname,

        @NotBlank(message = "Last name is mandatory")
        String lastname,

        @NotBlank(message = "Email is mandatory")
        @Email(message = "Use a valid email format.")
        String email,

        @NotBlank(message = "Document is mandatory")
        String documento,

        @NotBlank(message = "Password is mandatory")
        @Size(min = 4, max = 10)
        String password,

        Long cargoId) {
}
