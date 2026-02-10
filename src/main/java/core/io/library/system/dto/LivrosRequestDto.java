package core.io.library.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivrosRequestDto {

    private String titulo;
    private String autor;
    private String dataLancamento;
    private long quantidadeDisponivelEmprestimo;

}
