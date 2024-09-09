package es.luis.prueba.domain.reporitoy;


import es.luis.prueba.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}