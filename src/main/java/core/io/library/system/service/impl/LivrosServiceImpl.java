package core.io.library.system.service.impl;

import core.io.library.system.dto.LivrosRequestDto;
import core.io.library.system.dto.LivrosResponseDto;
import core.io.library.system.dto.mapper.LivrosMapper;
import core.io.library.system.entity.Livros;
import core.io.library.system.repository.LivrosRepository;
import core.io.library.system.service.LivrosService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivrosServiceImpl implements LivrosService {

    private final LivrosRepository livrosRepository;
    private final LivrosMapper livrosMapper;

    @Override
    public LivrosResponseDto salvarLivro(LivrosRequestDto livrosRequestDto) {
        Livros livros = livrosRepository.save(livrosMapper.toLivros(livrosRequestDto));
        return livrosMapper.toLivrosResponseDto(livros);
    }

    @Transactional
    @Override
    public LivrosResponseDto buscarLivroId(Integer id) {
        Livros livros = livrosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
        return livrosMapper.toLivrosResponseDto(livros);
    }

    @Override
    public List<LivrosResponseDto> listarLivros() {
        List<Livros> livros = livrosRepository.findAll();
        return livrosMapper.LivrosResponseDtos(livros);
    }

    @Override
    public void deletarLivro(Integer id) {
        Livros livros = livrosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
        livrosRepository.deleteById(id);
    }

    @Override
    public LivrosResponseDto editarLivro(Integer id, LivrosRequestDto livrosRequestDto) {
        Livros livros = livrosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
        livros.setTitulo(livrosRequestDto.getTitulo());
        livros.setAutor(livrosRequestDto.getAutor());
        livros.setDataLancamento(livrosRequestDto.getDataLancamento());
        livros.setQuantidadeDisponivelEmprestimo(livrosRequestDto.getQuantidadeDisponivelEmprestimo());
        return livrosMapper.toLivrosResponseDto(livrosRepository.save(livros));
    }
}
