package core.io.library.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusMulta {
    PAGO(0, "pago"),
    ATRASADO(1, "atrasado");

    private final Integer codigo;
    private final String descricao;

}
