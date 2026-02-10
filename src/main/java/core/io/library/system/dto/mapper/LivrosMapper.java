package core.io.library.system.dto.mapper;

import core.io.library.system.dto.LivrosRequestDto;
import core.io.library.system.dto.LivrosResponseDto;
import core.io.library.system.entity.Livros;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LivrosMapper {

    public Livros toLivros(LivrosRequestDto livrosRequestDto) {
        return new ModelMapper().map(livrosRequestDto, Livros.class);
    }

    public LivrosResponseDto toLivrosResponseDto(Livros livros) {
        return new ModelMapper().map(livros, LivrosResponseDto.class);
    }

    public List<LivrosResponseDto> LivrosResponseDtos(List<Livros> livros) {
        return livros.stream().map(Livros -> new ModelMapper().map(livros, LivrosResponseDto.class))
                .collect(Collectors.toList());
    }
}
