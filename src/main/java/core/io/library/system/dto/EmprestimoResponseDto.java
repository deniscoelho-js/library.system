package core.io.library.system.dto;

import core.io.library.system.enums.StatusEmprestimo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmprestimoResponseDto {

    private Integer id;
    private String nomeUsuario;
    private String tituloLivro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private StatusEmprestimo statusEmprestimo;

}
