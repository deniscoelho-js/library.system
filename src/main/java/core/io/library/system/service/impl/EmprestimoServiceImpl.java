package core.io.library.system.service.impl;

import core.io.library.system.dto.EmprestimoDevolucaoResponseDto;
import core.io.library.system.dto.EmprestimoRequestDto;
import core.io.library.system.dto.EmprestimoResponseDto;
import core.io.library.system.dto.mapper.EmprestimoMapper;
import core.io.library.system.entity.*;
import core.io.library.system.entity.Emprestimo;
import core.io.library.system.entity.Emprestimo;
import core.io.library.system.entity.Emprestimo;
import core.io.library.system.enums.StatusEmprestimo;
import core.io.library.system.repository.EmprestimoRepository;
import core.io.library.system.repository.LivrosRepository;
import core.io.library.system.repository.UsuarioRepository;
import core.io.library.system.service.EmprestimoService;
import core.io.library.system.util.Multa;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimoServiceImpl implements EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final EmprestimoMapper emprestimoMapper;
    private final UsuarioRepository usuarioRepository;
    private final LivrosRepository livrosRepository;

    @Override
    public EmprestimoResponseDto salvarEmprestimo(EmprestimoRequestDto emprestimoRequestDto) {

        Usuario usuario = usuarioRepository.findById(emprestimoRequestDto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Livros livro = livrosRepository.findById(emprestimoRequestDto.getLivroId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Emprestimo emprestimo = emprestimoMapper.toEmprestimo(emprestimoRequestDto, usuario, livro);

        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucao(emprestimo.getDataEmprestimo().plusDays(15));

        emprestimo = emprestimoRepository.save(emprestimo);
        return emprestimoMapper.toEmprestimoResponseDto(emprestimo);
    }

    @Override
    public EmprestimoResponseDto buscarEmprestimoId(Integer id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
        return emprestimoMapper.toEmprestimoResponseDto(emprestimo);
    }

    @Override
    public List<EmprestimoResponseDto> listarEmprestimos() {
        List<Emprestimo> emprestimo = emprestimoRepository.findAll();
        return emprestimoMapper.EmprestimoResponseDtos(emprestimo);
    }

    @Override
    public void deletarEmprestimo(Integer id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
        emprestimoRepository.deleteById(id);
    }

    @Override
    public List<EmprestimoResponseDto> buscarEmprestimosPorUsuario(Integer usuarioId) {
        List<Emprestimo> emprestimos = emprestimoRepository.findByUsuarioId(usuarioId);
        if (emprestimos.isEmpty()) {
            throw new EntityNotFoundException("Nenhum empréstimo encontrado para o usuário ID: " + usuarioId);
        }
        return emprestimoMapper.EmprestimoResponseDtos(emprestimos);
    }

    @Override
    public List<EmprestimoResponseDto> buscarEmprestimosPorLivro(Integer livroId) {
        List<Emprestimo> emprestimos = emprestimoRepository.findByLivrosId(livroId);
        if (emprestimos.isEmpty()) {
            throw new EntityNotFoundException("Nenhum empréstimo encontrado para o livro ID: " + livroId);
        }
        return emprestimoMapper.EmprestimoResponseDtos(emprestimos);
    }

    @Override
    public EmprestimoDevolucaoResponseDto devolverEmprestimo(Integer id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));

        LocalDate dataPrevista = emprestimo.getDataDevolucao();
        LocalDate dataReal = LocalDate.now();
        long diasAtraso = 0;
        double valorMulta = 0.0;

        if (emprestimo.getStatusEmprestimo().equals(StatusEmprestimo.ATRASADO)) {
            Multa multa = new Multa(dataPrevista, dataReal);
            diasAtraso = multa.getDiasAtraso();
            valorMulta = multa.getValorTotal();
        }

        emprestimo.setStatusEmprestimo(StatusEmprestimo.DEVOLVIDO);
        emprestimo.setDataDevolucao(dataReal);
        emprestimoRepository.save(emprestimo);

        return emprestimoMapper.toEmprestimoDevolucaoResponseDto(emprestimo, diasAtraso, valorMulta);
    }


}
