package core.io.library.system.dto;

import core.io.library.system.entity.Livros;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDto {

    private Integer id;
    private String nome;
    private String email;
    private String senha;

    private List<LivrosResponseDto> livrosResponseDtos = new ArrayList<>();

}
