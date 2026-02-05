package core.io.library.system.dto.mapper;

import core.io.library.system.dto.MultaRequestDto;
import core.io.library.system.dto.MultaResponseDto;
import core.io.library.system.entity.Multa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MultaMapper {

    public Multa toMulta(MultaRequestDto MultaRequestDto) {
        return new ModelMapper().map(MultaRequestDto, Multa.class);
    }

    public MultaResponseDto toMultaResponseDto(Multa Multa) {
        return new ModelMapper().map(Multa, MultaResponseDto.class);
    }

    public List<MultaResponseDto> MultaResponseDtos(List<Multa> Multas) {
        return Multas.stream().map(Multa -> new ModelMapper().map(Multa, MultaResponseDto.class))
                .collect(Collectors.toList());
    }
}
