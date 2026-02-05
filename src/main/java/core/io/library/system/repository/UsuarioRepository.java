package core.io.library.system.repository;

import core.io.library.system.entity.Emprestimo;
import core.io.library.system.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
