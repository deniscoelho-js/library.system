package core.io.library.system.service;

import core.io.library.system.dto.LivrosRequestDto;
import core.io.library.system.dto.UsuarioRequestDto;
import core.io.library.system.dto.LivrosResponseDto;

import java.util.List;

public interface LivrosService {
    public LivrosResponseDto salvarLivro(LivrosRequestDto livrosRequestDto);
    public LivrosResponseDto buscarLivroId(Integer id);
    public List<LivrosResponseDto> listarLivros();
    public void deletarLivro(Integer id);
    public LivrosResponseDto editarLivro(Integer id, LivrosRequestDto livrosRequestDto);
}
