package one.digitalinnovation.usuario.repositories;

import one.digitalinnovation.usuario.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
