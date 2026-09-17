package Api.company.relationships.controller;


import Api.company.relationships.database.entity.User;
import Api.company.relationships.dto.UserDto;
import Api.company.relationships.servise.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiv2/user")
@Tag(name = "User", description = "Crud para cadastro de usuarios")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Operation(summary = "Cadastro de Usuarios", description = "EndPoint feito para Cadastrar Usuario e Salvar")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto dto){
        var user = userService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    @Operation(summary = "Buscar todos", description = "EndPoint que chama todos os usuarios dentro do banco")
    public ResponseEntity<List<User>> getAllUsers(){
        var user = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "EndPoint que buscar o usuario pelo id")
    public ResponseEntity<User> getById(@PathVariable Long id){
        var user = userService.findById(id);
        return  ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um usario", description = "EndPoint que delete um usuario por id")
    public ResponseEntity deleteById(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Sucessfully deleted");
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar Usuario", description = "EndPoint que atualizar o usuario com o id especifico")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody @Valid UserDto dto){
        var userUpdate = userService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(userUpdate);
    }
}
