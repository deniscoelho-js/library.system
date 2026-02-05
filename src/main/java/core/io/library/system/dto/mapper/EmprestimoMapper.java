package core.io.library.system.dto.mapper;

import core.io.library.system.dto.EmprestimoRequestDto;
import core.io.library.system.dto.EmprestimoResponseDto;
import core.io.library.system.entity.Emprestimo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmprestimoMapper {

    public Emprestimo toEmprestimo(EmprestimoRequestDto EmprestimoRequestDto) {
        return new ModelMapper().map(EmprestimoRequestDto, Emprestimo.class);
    }

    public EmprestimoResponseDto toEmprestimoResponseDto(Emprestimo Emprestimo) {
        return new ModelMapper().map(Emprestimo, EmprestimoResponseDto.class);
    }

    public List<EmprestimoResponseDto> EmprestimoResponseDtos(List<Emprestimo> Emprestimos) {
        return Emprestimos.stream().map(Emprestimo -> new ModelMapper().map(Emprestimo, EmprestimoResponseDto.class))
                .collect(Collectors.toList());
    }
}
