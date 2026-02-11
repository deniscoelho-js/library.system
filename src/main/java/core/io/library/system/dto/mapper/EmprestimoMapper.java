package core.io.library.system.dto.mapper;

import core.io.library.system.dto.EmprestimoDevolucaoResponseDto;
import core.io.library.system.dto.EmprestimoRequestDto;
import core.io.library.system.dto.EmprestimoResponseDto;
import core.io.library.system.entity.Emprestimo;
import core.io.library.system.entity.Livros;
import core.io.library.system.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmprestimoMapper {

    private final ModelMapper modelMapper;

    public EmprestimoMapper() {
        this.modelMapper = new ModelMapper();
        modelMapper.typeMap(Emprestimo.class, EmprestimoResponseDto.class)
                .addMapping(src -> src.getUsuario().getNome(), EmprestimoResponseDto::setNomeUsuario)
                .addMapping(src -> src.getLivros().getTitulo(), EmprestimoResponseDto::setTituloLivro);
    }

    public Emprestimo toEmprestimo(EmprestimoRequestDto emprestimoRequestDto, Usuario usuario, Livros livro) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setLivros(livro);
        emprestimo.setDataEmprestimo(emprestimoRequestDto.getDataEmprestimo());
        emprestimo.setDataDevolucao(emprestimoRequestDto.getDataDevolucao());
        emprestimo.setStatusEmprestimo(emprestimoRequestDto.getStatusEmprestimo());
        return emprestimo;
    }

    public EmprestimoResponseDto toEmprestimoResponseDto(Emprestimo emprestimo) {
        return modelMapper.map(emprestimo, EmprestimoResponseDto.class);
    }

    public List<EmprestimoResponseDto> EmprestimoResponseDtos(List<Emprestimo> emprestimos) {
        return emprestimos.stream()
                .map(this::toEmprestimoResponseDto)
                .collect(Collectors.toList());
    }

    public EmprestimoDevolucaoResponseDto toEmprestimoDevolucaoResponseDto(Emprestimo emprestimo, long diasAtraso, double valorMulta) {
        return new EmprestimoDevolucaoResponseDto(
                emprestimo.getId(),
                emprestimo.getUsuario().getNome(),
                emprestimo.getLivros().getTitulo(),
                emprestimo.getDataDevolucao(),
                diasAtraso,
                valorMulta
        );
    }

}
