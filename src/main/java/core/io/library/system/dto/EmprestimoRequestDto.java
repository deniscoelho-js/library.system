package core.io.library.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmprestimoRequestDto {

    private Integer usuarioId;
    private Integer livroId;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;


}
