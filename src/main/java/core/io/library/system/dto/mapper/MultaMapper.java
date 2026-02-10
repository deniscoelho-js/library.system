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

    public Multa toMulta(MultaRequestDto multaRequestDto) {
        return new ModelMapper().map(multaRequestDto, Multa.class);
    }

    public MultaResponseDto toMultaResponseDto(Multa multa) {
        return new ModelMapper().map(multa, MultaResponseDto.class);
    }

    public List<MultaResponseDto> MultaResponseDtos(List<Multa> multas) {
        return multas.stream().map(multa -> new ModelMapper().map(multa, MultaResponseDto.class))
                .collect(Collectors.toList());
    }
}
