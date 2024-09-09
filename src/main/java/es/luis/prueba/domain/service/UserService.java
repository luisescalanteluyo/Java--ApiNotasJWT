package es.luis.prueba.domain.service;


import es.luis.prueba.domain.model.User;
import es.luis.prueba.domain.reporitoy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createOrUpdateUser(User user) {
        return userRepository.save(user);
    }
}