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

    public Livros toLivros(LivrosRequestDto LivrosRequestDto) {
        return new ModelMapper().map(LivrosRequestDto, Livros.class);
    }

    public LivrosResponseDto toLivrosResponseDto(Livros Livros) {
        return new ModelMapper().map(Livros, LivrosResponseDto.class);
    }

    public List<LivrosResponseDto> LivrosResponseDtos(List<Livros> Livross) {
        return Livross.stream().map(Livros -> new ModelMapper().map(Livros, LivrosResponseDto.class))
                .collect(Collectors.toList());
    }
}
