package core.io.library.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEmprestimo {
    ATIVO(0, "ativo"),
    DEVOLVIDO(1, "devolvido"),
    ATRASADO(2, "atrasado");

    private final Integer codigo;
    private final String descricao;
}
