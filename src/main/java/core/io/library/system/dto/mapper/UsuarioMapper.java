package core.io.library.system.dto.mapper;

import core.io.library.system.dto.UsuarioRequestDto;
import core.io.library.system.dto.UsuarioResponseDto;
import core.io.library.system.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public Usuario toUsuario(UsuarioRequestDto usuarioRequestDto) {
        return new ModelMapper().map(usuarioRequestDto, Usuario.class);
    }

    public UsuarioResponseDto toUsuarioResponseDto(Usuario usuario) {
        return new ModelMapper().map(usuario, UsuarioResponseDto.class);
    }

    public List<UsuarioResponseDto> UsuarioResponseDtos(List<Usuario> usuarios) {
        return usuarios.stream().map(usuario -> new ModelMapper().map(usuario, UsuarioResponseDto.class))
                .collect(Collectors.toList());
    }
}
