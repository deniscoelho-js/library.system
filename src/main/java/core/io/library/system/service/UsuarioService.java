package core.io.library.system.service;

import core.io.library.system.dto.UsuarioRequestDto;
import core.io.library.system.dto.UsuarioResponseDto;

import java.util.List;

public interface UsuarioService {
    public UsuarioResponseDto salvarUsuario(UsuarioRequestDto usuarioRequestDto);
    public UsuarioResponseDto buscarUsuarioId(Integer id);
    public List<UsuarioResponseDto> listarUsuarios();
    public void deletarUsuario(Integer id);
    public UsuarioResponseDto editarUsuario(Integer id, UsuarioRequestDto usuarioRequestDto);
}
