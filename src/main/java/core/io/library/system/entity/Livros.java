package core.io.library.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String autor;
    private String dataLancamento;
    private long quantidadeDisponivelEmprestimo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
