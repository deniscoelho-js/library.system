package core.io.library.system.repository;

import core.io.library.system.entity.Livros;
import core.io.library.system.entity.Multa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepository extends JpaRepository<Livros, Integer> {
}
