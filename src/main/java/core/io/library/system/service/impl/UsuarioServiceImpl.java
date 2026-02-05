package core.io.library.system.service.impl;

import core.io.library.system.dto.UsuarioRequestDto;
import core.io.library.system.dto.UsuarioResponseDto;
import core.io.library.system.repository.UsuarioRepository;
import core.io.library.system.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponseDto salvarUsuario(UsuarioRequestDto usuarioRequestDto) {
        return null;
    }

    @Override
    public UsuarioResponseDto buscarUsuarioId(Integer id) {
        return null;
    }

    @Override
    public List<UsuarioResponseDto> listarUsuarios() {
        return List.of();
    }

    @Override
    public void deletarUsuario(Integer id) {

    }

    @Override
    public UsuarioResponseDto editarUsuario(Integer id, UsuarioRequestDto usuarioRequestDto) {
        return null;
    }
}
