package es.luis.prueba.domain.reporitoy;

import es.luis.prueba.domain.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}