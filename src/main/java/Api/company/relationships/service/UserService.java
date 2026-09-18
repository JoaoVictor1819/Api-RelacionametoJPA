package Api.company.relationships.service;


import Api.company.relationships.database.model.User;
import Api.company.relationships.database.repository.UserRepository;
import Api.company.relationships.dto.UserDto;
import Api.company.relationships.exception.ResourceExceptonHandler;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(UserDto dto){
        var user = new User(dto);
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceExceptonHandler("User with id " + id + " not found"));
    }

    public void delete(Long id){
        if (!userRepository.existsById(id) || userRepository.findById(id).isEmpty()){
            throw new ResourceExceptonHandler("Cadastro with id"  + id + " not found");
        }
        userRepository.deleteById(id);
    }


    @Transactional
    public User update(Long id, UserDto dto){
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceExceptonHandler("User with id " + id + " not found"));

        user.setFirstname(dto.firstname());
        user.setLastname(dto.lastname());
        user.setPassword(dto.password());

        return userRepository.save(user);
    }
}
