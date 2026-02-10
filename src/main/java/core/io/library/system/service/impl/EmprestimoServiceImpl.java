package core.io.library.system.service.impl;

import core.io.library.system.dto.EmprestimoRequestDto;
import core.io.library.system.dto.EmprestimoResponseDto;
import core.io.library.system.dto.mapper.EmprestimoMapper;
import core.io.library.system.entity.*;
import core.io.library.system.entity.Emprestimo;
import core.io.library.system.entity.Emprestimo;
import core.io.library.system.entity.Emprestimo;
import core.io.library.system.repository.EmprestimoRepository;
import core.io.library.system.repository.LivrosRepository;
import core.io.library.system.repository.UsuarioRepository;
import core.io.library.system.service.EmprestimoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        // Buscar o livro pelo ID
        Livros livro = livrosRepository.findById(emprestimoRequestDto.getLivroId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Emprestimo emprestimo = emprestimoRepository.save(emprestimoMapper.toEmprestimo(emprestimoRequestDto, usuario, livro));
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



}
