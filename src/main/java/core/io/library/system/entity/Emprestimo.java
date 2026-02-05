package core.io.library.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import core.io.library.system.enums.StatusEmprestimo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIgnoreProperties({"id", "email", "senha"})
    private Usuario usuario;

    @ManyToOne
    @JsonIgnoreProperties({"id", "autor", "dataLancamento", "quantidadeDisponivelEmprestimo"})
    private Livros livros;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private StatusEmprestimo statusEmprestimo;
}
