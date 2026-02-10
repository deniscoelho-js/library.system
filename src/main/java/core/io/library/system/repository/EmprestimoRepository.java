package core.io.library.system.repository;

import core.io.library.system.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {

    List<Emprestimo> findByUsuarioId(Integer usuarioId);

    List<Emprestimo> findByLivrosId(Integer livroId);
}
