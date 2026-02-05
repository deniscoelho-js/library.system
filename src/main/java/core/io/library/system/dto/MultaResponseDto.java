package core.io.library.system.dto;

import core.io.library.system.entity.Emprestimo;
import core.io.library.system.entity.Usuario;
import core.io.library.system.enums.StatusMulta;

public class MultaResponseDto {
    private UsuarioResponseDto usuarioResponseDto;
    private EmprestimoResponseDto emprestimoResponseDto;
    private double valorMulta;
    private StatusMulta statusMulta;
}
