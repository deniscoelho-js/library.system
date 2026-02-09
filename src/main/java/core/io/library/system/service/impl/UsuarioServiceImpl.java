package core.io.library.system.service.impl;

import core.io.library.system.dto.UsuarioRequestDto;
import core.io.library.system.dto.UsuarioResponseDto;
import core.io.library.system.dto.mapper.UsuarioMapper;
import core.io.library.system.entity.Usuario;
import core.io.library.system.repository.UsuarioRepository;
import core.io.library.system.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioResponseDto salvarUsuario(UsuarioRequestDto usuarioRequestDto) {
        var usuarioSalvo = usuarioRepository.save(usuarioMapper.toUsuario(usuarioRequestDto));
        return usuarioMapper.toUsuarioResponseDto(usuarioSalvo);
    }

    @Transactional
    @Override
    public UsuarioResponseDto buscarUsuarioId(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Usuario com id %s não encontrado", id)));
        return usuarioMapper.toUsuarioResponseDto(usuario);
    }

    @Override
    public List<UsuarioResponseDto> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarioMapper.UsuarioResponseDtos(usuarios);
    }

    @Override
    public void deletarUsuario(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Usuario com id %s não encontrado", id)));
        usuarioRepository.delete(usuario);
    }

    @Override
    public UsuarioResponseDto editarUsuario(Integer id, UsuarioRequestDto usuarioRequestDto) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Usuario com id %s não encontrado", id)));
        usuarioExistente.setNome(usuarioRequestDto.getNome());
        usuarioExistente.setEmail(usuarioRequestDto.getEmail());
        usuarioExistente.setSenha(usuarioRequestDto.getSenha());

        return usuarioMapper.toUsuarioResponseDto(usuarioRepository.save(usuarioExistente));
    }
}
